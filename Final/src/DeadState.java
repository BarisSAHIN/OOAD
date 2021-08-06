package sample;

import javafx.scene.canvas.Canvas;
/**
 *
 * Dead state has an empty move and draw function so dead individual cant move or draw itself
 *
 * */
public class DeadState implements HealthState{
    @Override
    public void setContext(Individual individual) {

    }

    @Override
    public void move() {

    }

    @Override
    public void draw(Canvas map) {

    }

    @Override
    public HealthState getState() {
        return this;
    }

    @Override
    public HealthStateNames getStateName() {
        return HealthStateNames.DEAD;
    }
}
