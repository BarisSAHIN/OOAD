package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
/**
 *Concrete Healt State
 *
 *This is our infected state
 *
 * When every time a individual in this state moves its reduces its lifetime.
 * When life time reaches the zero it will go Dead State
 * It also counts backwards from 25 to go hospital.
 * When count reaches the zero simulator can take this individual to a hospital if there is a empty room
 * */
public class InfectedState implements HealthState{
    Individual content;
    private int hospitalizeTime = 25;
    private boolean hospitalizable;
    private double deathTimer;
    MovementDirection direction;


    /**
     * Sets individual of the state also assign a direction
     * */
    @Override
    public void setContext(Individual individual){
        content = individual;
        direction = MovementDirection.values()[content.rand.nextInt(4)];
    }

    /**
     * Gets a deathTime for countdown
     * */
    public InfectedState(double gDeathTimer) {

        deathTimer = gDeathTimer;
        hospitalizable = false;
    }

    /**
     When every time a individual in this state moves its reduces its lifetime.
     * When life time reaches the zero it will go Dead State
     * It also counts backwards from 25 to go hospital.
     * When count reaches the zero simulator can take this individual to a hospital if there is a empty room
     *
     * */
    @Override
    public void move() {
        if(deathTimer <= 0){
            content.changeState(new DeadState());
            return;
        }
        else {
            deathTimer --;
        }
        if (hospitalizeTime == 0){
            hospitalizable = true;
        }
        else{
            hospitalizeTime --;
        }
        while(true){
            if(direction== MovementDirection.LEFT){
                int newX = content.getX()-content.getSpeed();
                if(newX < 0)
                    direction = MovementDirection.values()[content.rand.nextInt(4)];
                else{
                    content.setX(newX);
                    return;
                }
            }
            if(direction== MovementDirection.RIGHT){
                int newX = content.getX()+content.getSpeed();
                if(newX > 995)
                    direction = MovementDirection.values()[content.rand.nextInt(4)];
                else{
                    content.setX(newX);
                    return;
                }
            }
            if(direction== MovementDirection.UP){
                int newY = content.getY() - content.getSpeed();
                if(newY < 0)
                    direction = MovementDirection.values()[content.rand.nextInt(4)];
                else{
                    content.setY(newY);
                    return;
                }
            }
            if(direction== MovementDirection.DOWN){
                int newY = content.getY() + content.getSpeed();
                if(newY > 595)
                    direction = MovementDirection.values()[content.rand.nextInt(4)];
                else{
                    content.setY(newY);
                    return;
                }
            }
        }
    }

    /**
     * draws individual as red
     *
     * */
    @Override
    public void draw(Canvas map) {
        map.getGraphicsContext2D().setFill(Color.RED);
        map.getGraphicsContext2D().fillRect(content.getX(),content.getY(), 5, 5);
    }

    /**
     * @return Returns related HealtStateName
     * */
    @Override
    public HealthStateNames getStateName(){
        return HealthStateNames.INFECTED;
    }
    /**
     *
     * @return returns itself
    * */
    @Override
    public HealthState getState(){
        return this;
    }


    /**
     * @return Resturns is Individual can be taken to hospital
     *
     * */
    public boolean isHospitalizable(){
        return hospitalizable;
    }
}
