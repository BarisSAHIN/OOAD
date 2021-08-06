package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * Initial State for most of the individuals most of the time
 *
 * */
public class HealtyState implements HealthState{
    Individual content;
    MovementDirection direction;
    @Override
    public void setContext(Individual individual){
        content = individual;
        direction = MovementDirection.values()[content.rand.nextInt(4)];
    }
    /**
     * Moves at random direction
     *
     *
     * */
    @Override
    public void move() {

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
     * Draws itself on canvas
     *
     * */
    @Override
    public void draw(Canvas map) {

        map.getGraphicsContext2D().setFill(Color.GREEN);
        map.getGraphicsContext2D().fillRect(content.getX(),content.getY(), 5, 5);
    }
    @Override
    public HealthStateNames getStateName(){
        return HealthStateNames.HEALTY;
    }


    @Override
    public HealthState getState(){
        return this;
    }

}
