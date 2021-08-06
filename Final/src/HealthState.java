package sample;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
/**
 * Our healt state interface
 *
 *
 * */
public interface HealthState {

    void setContext(Individual individual);
    void move();
    void draw(Canvas map);
    HealthState getState();
    HealthStateNames getStateName();
}
