package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
/**
 * This state waits for 10 secs and change its state via Mediator
 *
 * */
public class HospitalizedState implements HealthState{

    private int hospitalizedTime = 10;
    Individual content;
    Hospital hospital;
    HospitalizedState(Hospital H){
        hospital = H;
    }
    @Override
    public void setContext(Individual individual){
        content = individual;
    }

    @Override
    public void move() {
        if(hospitalizedTime == 0){
            Mediator.dischargeIndividual(content,hospital);
            return;
        }
        else
            hospitalizedTime --;
    }

    @Override
    public void draw(Canvas map) {

    }
    @Override
    public HealthStateNames getStateName(){
        return HealthStateNames.HOSPITALIZED;
    }

    @Override
    public HealthState getState(){
        return this;
    }
}
