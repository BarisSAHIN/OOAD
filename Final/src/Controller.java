package sample;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


import static java.lang.Thread.sleep;
/**
 * Controller class for fxml
 *
 * It holds a simulator object and call its fuctions to do everything
 * When start button pressed it creates a thread and runs run(gameloop) funciton in simulator
 * */
public class Controller {

    Thread simulatorThread;


    @FXML public Pane outerPane;


    @FXML private TextField popInput;
    @FXML private TextField errorPop;
    @FXML private TextField SInput;
    @FXML private TextField CInput;
    @FXML private TextField DInput;
    @FXML private TextField ZInput;
    @FXML private TextField RInput;

    @FXML private Button startButton;
    @FXML private Button pauseButton;
    @FXML private Button addMany;
    @FXML private Button addOne;
    @FXML private Button setZ;
    @FXML private Button setR;

    @FXML private RadioButton InfectedInput;
    @FXML private RadioButton MInput;

    @FXML private Label popCount;
    @FXML private Label infectedCount;
    @FXML private Label deadCount;
    @FXML private Label timeNow;
    @FXML private Label collidedCount;
    @FXML private Label empty;
    @FXML private Label occupied;
    @FXML private Label maskPersantage;
    @FXML private Label avgD;

    @FXML private ProgressBar progressBar;

    @FXML private CategoryAxis x;
    @FXML private NumberAxis y;
    @FXML private LineChart<?,?> lineChart;
    private XYChart.Series graphHealty;
    private XYChart.Series graphInfected;
    private XYChart.Series graphDead;

    @FXML private Canvas mapCanvas;

    private Object pauseLock;
    private boolean simFlag;

    public Simulator simulator;
    private boolean RZEntered;


    @FXML
    public void initialize(){
        pauseLock = new Object();
        simulator = new Simulator(mapCanvas,pauseLock);
        simFlag = false;
        RZEntered = false;

        graphInfected = new XYChart.Series();
        graphDead = new XYChart.Series();
        graphHealty = new XYChart.Series();

    }
    /**
     * When app shutdown waits for simulator thread and joins it
     *
     * */
    public void End() throws InterruptedException {

        if(simulatorThread != null){
            if(simulatorThread.isAlive()){
                simulator.setSimWorks(false);
                System.out.println("The End is comming");
                synchronized (pauseLock){
                    pauseLock.notify();
                }
                simulatorThread.join();
            }
        }
        return;
    }

    @FXML public void AddMany() throws InterruptedException {
        int popCountVal= 0;
        try
        {

            System.out.println(popCountVal = Integer.parseInt(popInput.getText()));
            errorPop.setVisible(false);
            simulator.addMany(popCountVal);
            popCount.setText("" + simulator.getPopCount());
            infectedCount.setText("" + simulator.getInfectedCount());
            simulator.render();
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            errorPop.setText("NumberFormatException: " + nfe.getMessage());
            errorPop.setVisible(true);
        }
        popInput.setText("");
    }
    @FXML public void AddOne(){
        int SInputVal = 0;
        int DInputVal = 0;
        int CInputVal = 0;
        boolean MInputVal = false;
        boolean InfectedInputVal = false;

        try
        {
            System.out.println(SInputVal = Integer.parseInt(SInput.getText()));
            System.out.println(DInputVal = Integer.parseInt(DInput.getText()));
            System.out.println(CInputVal = Integer.parseInt(CInput.getText()));
            System.out.println(MInputVal = MInput.isSelected());
            System.out.println(InfectedInputVal = InfectedInput.isSelected());
            simulator.addOne(InfectedInputVal,CInputVal,MInputVal,DInputVal,SInputVal);
            popCount.setText("" + simulator.getPopCount());
            infectedCount.setText("" + simulator.getInfectedCount());
            errorPop.setVisible(false);
            simulator.render();
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            errorPop.setText("NumberFormatException: " + nfe.getMessage());
            errorPop.setVisible(true);
        }

    }
    @FXML void SetR(){
        double RInputVal = 0;
        try
        {
            System.out.println(RInputVal = Double.parseDouble(RInput.getText()));
            simulator.setInfectionRate(RInputVal);
            errorPop.setVisible(false);
            if(RZEntered){
                addMany.setDisable(false);
                addOne.setDisable(false);
                startButton.setDisable(false);
                ZInput.setDisable(true);
                RInput.setDisable(true);
            }
            else{
                RZEntered = true;
            }
            setR.setDisable(true);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            errorPop.setText("NumberFormatException: " + nfe.getMessage());
            errorPop.setVisible(true);

        }
    }
    @FXML void SetZ(){
        double ZInputVal = 0;
        try
        {
            System.out.println(ZInputVal = Double.parseDouble(ZInput.getText()));
            simulator.setLetality(ZInputVal);
            errorPop.setVisible(false);
            if(RZEntered){
                addMany.setDisable(false);
                addOne.setDisable(false);
                startButton.setDisable(false);
                ZInput.setDisable(true);
                RInput.setDisable(true);
            }
            else{
                RZEntered = true;
            }
            setZ.setDisable(true);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            errorPop.setText("NumberFormatException: " + nfe.getMessage());
            errorPop.setVisible(true);
        }

    }
    @FXML void SimStart(){

        if(!simFlag){
            simulator.setSimWorks(true);
            simulatorThread = new Thread(){public void run(){
                try {
                    simulator.run();

                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            };
            simulatorThread.start();
            System.out.println("Start");
            simFlag = true;
        }
        else{
            synchronized (pauseLock){
                System.out.println("Continue");
                simulator.Unpause();
                pauseLock.notify();
                System.out.println(simulatorThread.isAlive());
            }

        }
        pauseButton.setDisable(false);
        startButton.setDisable(true);
    }
    @FXML void SimPause(){
        simulator.Pause();
        pauseButton.setDisable(true);
        startButton.setDisable(false);
    }

    /**
     * Updates GUI with simulator values
     *
     * */
    public void update() {
        int time =  simulator.getLoopCount();
        int popCountVal = simulator.getPopCount();
        int infectedCountVal = simulator.getInfectedCount();
        int deathCountVal = simulator.getDeaths();
        popCount.setText(""+popCountVal);
        infectedCount.setText(""+infectedCountVal);
        deadCount.setText(""+deathCountVal);
        timeNow.setText(""+time);
        collidedCount.setText(""+simulator.getCollidedCount());

        if(simFlag){
            maskPersantage.setText(""+simulator.getMaskPersantage());
            avgD.setText(""+simulator.getAvgDistance());
            int occupiedVal = (simulator.getHospitalCapacity()-simulator.getHospitalEmpty());
            occupied.setText("" + occupiedVal);
            progressBar.setProgress((double)(occupiedVal)/(double)simulator.getHospitalCapacity());
            empty.setText(""+simulator.getHospitalEmpty());

            graphHealty.getData().add(new XYChart.Data(""+time,popCountVal-infectedCountVal));
            graphDead.getData().add(new XYChart.Data(""+time,deathCountVal));
            graphInfected.getData().add(new XYChart.Data(""+time,infectedCountVal));

            lineChart.getData().addAll(graphDead,graphInfected,graphHealty);
        }

    }
}
