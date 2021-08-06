package sample;
import javafx.scene.canvas.Canvas;
import java.util.ArrayList;

/**
 * It our simulator class
 * Basically backend Server for our App
 * It has list of individuals and all things about it
 * It has our gameloop. When simulation started from UI Controller creates a thread runs this class's
 * run function(Our gameloop)
 * */
public class Simulator {

    private final Canvas map;
    private ArrayList<Individual> alivePopulation;
    private ArrayList<Individual> deadPopulation;
    private IndividualFactory factory;
    private Object pauseLock;
    private Hospital hospital;

    private double deathTimer = 0;

    private double letality;
    private double infectionRate;
    private boolean simWorks;
    private int loopCount = 0;
    private boolean pause;
    private int maskPersantage;
    private double avgDistance;

    /**
     *
     * Gets a Map for draw Individuals to draw themselves onto it
     * Gets a Object for synchronization in game loop(pause)
     *
     * */
    Simulator(Canvas gMap,Object gPauseLock){

        alivePopulation = new ArrayList<>();
        deadPopulation = new ArrayList<>();
        map = gMap;
        pauseLock = gPauseLock;
    }

    /**
     * Checks collision and update the state of individuals collided via Mediator.
     *
     * */
    private void collisionCheck(){
        for (int i = 0; i <alivePopulation.size() ; i++) {
            for (int j = 0; j <alivePopulation.size() ; j++) {
                if(i!=j){
                    Individual I1 = alivePopulation.get(i);
                    Individual I2 = alivePopulation.get(j);
                    if(Mediator.isColliding(I1,I2))
                        Mediator.contact(I1,I2,infectionRate,deathTimer);
                }

            }
        }
    }
    /**
     * Checks individual should be hospitalized and hospitalize it via Mediator.
     *
     * */
    private void hospitalizeInfected(){
        for (Individual I: alivePopulation) {
            if(I.getStateName() == HealthStateNames.INFECTED){
                if(((InfectedState) I.getState()).isHospitalizable()){
                    Mediator.hospitalize(I,hospital);
                }

            }
        }
    }

    /**
     * Relocate Individuals in Dead State to an other list
     * Basically Grim reaper
     * */
    private void cleanDead(){
        for (int i = 0; i <alivePopulation.size() ; i++) {
            if(alivePopulation.get(i).getStateName() == HealthStateNames.DEAD){
                deadPopulation.add(alivePopulation.remove(i));

            }
        }

    }

    /**
     * Call all individuals draw function. Individuals will use the draw function of their states
     *
     * */
    public void render(){
        map.getGraphicsContext2D().clearRect(0, 0, map.getWidth(), map.getHeight());
        for(int i =0;i<alivePopulation.size();i++)
            alivePopulation.get(i).draw(map);
    }

    /**
     *
     * Call all individuals move function. Individuals will use the move function of their states
     *
     * */
    private void move(){
        for (int i = 0; i < alivePopulation.size(); i++) {
            alivePopulation.get(i).move();
        }
    }

    /**
     * Uses Individual factories and create that many Individual and add them to alivePopulation list
     *
     * */

    public int addMany(int pop){

        factory = new HealtyIndividualFactory();

        alivePopulation.addAll(factory.createMany(pop-1));

        factory = new InfectedIndividualFactory(deathTimer);

        alivePopulation.addAll(factory.createMany(1));

        return alivePopulation.size();
    }

    /**
     * Uses Individual factories and create that specific Individual and add it to alivePopulation list
     *
     * */
    public int addOne(boolean infected, int gC, boolean gMask, int gDistance, int gSpeed){

        factory = infected ? new InfectedIndividualFactory(deathTimer) : new HealtyIndividualFactory();
        alivePopulation.add(factory.createOne(gC,gMask,gDistance,gSpeed));
        return alivePopulation.size();
    }

    /**
     *
     *
     * @return Returns the living individual count
     * */
    public int getPopCount() {
        return alivePopulation.size();
    }

    /**
     *
     *
     * @return Returns the infected individual count
     * */
    public int getInfectedCount() {
        int count = 0;
        for(int i =0;i<alivePopulation.size();i++)
            if(alivePopulation.get(i).getStateName() == HealthStateNames.INFECTED)
                count ++;
        return count;
    }
    /**
     * Sets lethality nad calculates deathTime
     *
     * */
    public void setLetality(double gLetality) {
        letality = gLetality;
        deathTimer = (100.0*(1.0-letality));
    }

    /**
     * Its our main gameloop
     * It does some further initialization after construction
     * Because hospital other calculations need Pop count
     * It calls move cleanDead collisionCheck hospitalizeInfected render
     * it checks every time pause boolean if "pause" assigned as true it will wait for a lock
     * In controller continue notifies that lock so it can continue
     * it runs until simWorks flag is true when sim ends controller turn that flag false and joins the thread
     * */
    public void run() throws InterruptedException {

        hospital = new Hospital(alivePopulation.size()/100);
        maskPersantage = calculateMaskPersantage();
        avgDistance = calculateAvgDistance();
        synchronized (pauseLock){

            while (simWorks){
                if(pause){
                    pauseLock.wait();
                }
                Thread.sleep(1000);
                loopCount++;
                move();
                cleanDead();
                collisionCheck();
                hospitalizeInfected();
                render();
            }
        }
    }
    /**
     * Calculates Initial Mask Percentage
     * */
    private int calculateMaskPersantage() {
        int count = 0;
        for (Individual I: alivePopulation) {
            if(I.getMask()==0.2)
                count++;
        }
        return ((count*100)/alivePopulation.size());
    }
    /**
     * Calculates Initial avg Distance for all individuals
     * */
    private double calculateAvgDistance() {
        int avg = 0;
        for (Individual I: alivePopulation) {
            avg += I.getD();
        }
        return (avg/alivePopulation.size());
    }
    void setSimWorks(boolean gSimWorks){
        simWorks = gSimWorks;
    }
    int getLoopCount(){
        return loopCount;
    }

    public void Pause() {
        pause = true;
    }
    public void Unpause() {
        pause = false;
    }

    public void setInfectionRate(double infectionRate) {
        this.infectionRate = infectionRate;
    }
    public double getInfectionRate(){
        return infectionRate;
    }
    public int getDeaths(){
        return deadPopulation.size();
    }
    public int getCollidedCount(){
        int count = 0;
        for (Individual ind : alivePopulation) {
            if(ind.getStateName()==HealthStateNames.INCONTACT)
                count++;
        }
        return count;
    }
    public int getHospitalCapacity(){
        return hospital.getHospitalCapacity();
    }
    public int getHospitalEmpty(){
        return hospital.getEmpty();
    }

    public int getMaskPersantage() {
       return maskPersantage;
    }
    public double getAvgDistance(){
        return avgDistance;
    }

}
