package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 *This state is represent Individual is in contact with other individual
 *In move it waits for given time.
 * After that time it will change its state to next state given by Mediator
 *
 * */
public class CollisionState implements HealthState{
    Individual content;
    HealthState nextState;
    int contact;

    @Override
    /**
     * takes individual
     *
     * */
    public void setContext(Individual individual){
        content = individual;
    }

    /**
     * Takes wait time and next state
     *
     * */
    CollisionState(HealthState gNextState, int waitSec){
        nextState = gNextState;
        contact = waitSec;
    }

    /**
     * doesnt moves
     * Just waits for the time
     * When wait time is up it will chage its state
     * */
    @Override
    public void move() {
        if(contact == 0){
            content.changeState(nextState);
            content.move();
            return;
        }
        else {
            contact --;
        }
    }
    /**
     * draws individual as orange
     *
     * */
    @Override
    public void draw(Canvas map) {
        map.getGraphicsContext2D().setFill(Color.ORANGE);
        map.getGraphicsContext2D().fillRect(content.getX(),content.getY(), 5, 5);
    }

    @Override
    public HealthState getState() {
        return this;
    }

    @Override
    public HealthStateNames getStateName() {
        return HealthStateNames.INCONTACT;
    }
}
