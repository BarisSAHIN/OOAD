package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * Main FX class
 *
 * Starts our application
 * */

public class Main extends Application {

    Controller controller;
    /**
     * Its start fuction for our App
     * This function has UI update loop
     * This loop runs in separate thread because of AnimationTime
     * */
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        primaryStage.setTitle("Corona Simulator");
        primaryStage.setScene(new Scene(root, 1920, 800));
        primaryStage.show();

        final long[] time = {System.nanoTime()};
        new AnimationTimer() {


            @Override
            public void handle(long currentTime) {
                double elapsedTime = (currentTime-time[0])/1000000000.0;
                if(elapsedTime > 1){
                    time[0] = currentTime;
                    controller.update();
                }
            }
        }.start();

    }

    /**
     * Its called when app closed
     * We call our end function in controller for join simulation thread
     *
     * */
    @Override
    public void stop() throws InterruptedException {
        controller.End();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
