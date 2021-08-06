package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import java.util.Random;

/**
 * Our backbone individual class
 *
 * Its our content for state pattern. It calls state function when some action requested from it
 * It has 5 states
 * Healty: initial state most of the time
 * Infected: can be initial state or can be changed from healty or collided
 * Collided: Wait state
 * Hospitalized: Hospitalization trough mediator
 * Dead: empty state...
 * */
public class Individual {

    private int X;
    private int Y;
    private int C;
    private double Mask;
    private int Speed;
    private int D;

    private int waitTime;
    private int deathTimer;

    public Random rand = new Random();
    HealthState state;


    Individual(HealthState initialState) {
        state = initialState;
        state.setContext(this);
        setX(rand.nextInt(995));
        setY(rand.nextInt(595));
        setC(rand.nextInt(5)+ 1);
        setSpeed(rand.nextInt(50)+1);
        setD(rand.nextInt(10));
        setMask(rand.nextBoolean());
    }
    Individual(HealthState gState,int gC, boolean gMask,int gDistance,int gSpeed) {
        state = gState;
        state.setContext(this);
        setX(rand.nextInt(995));
        setY(rand.nextInt(595));
        setC(gC);
        setSpeed(gSpeed);
        setD(gDistance);
        setMask(gMask);
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        if(x>=0 &&x<=995)
            X = x;
        else
            System.out.println("Error Code 5");
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        if(y>=0 && y<=595)
            Y = y;
        else
            System.out.println("Error Code 4");
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        if(c>=1 && c<=5)
            C = c;
        else
            System.out.println("Error Code 3");
    }

    public double getMask() {
        return Mask;
    }

    public void setMask(boolean mask) {
        Mask = mask ? 0.2 : 1.0;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        if(speed>=1 && speed<=500)
            Speed = speed;
        else
            System.out.println("Error Code 2");
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        if(d>=0 && d<=9)
        D = d;
        else
            System.out.println("Error Code 1");
    }

    public HealthStateNames getStateName() {
        return state.getStateName();
    }

    public HealthState getState(){
        return state.getState();
    }

    public void draw(Canvas map) {
        state.draw(map);
    }

    public void move() { state.move(); }

    public void changeState(HealthState gState) {
        state = gState;
        state.setContext(this);
    }
}
