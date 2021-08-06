public class TraficLight {
    LighrState state;

    TraficLight(LighrState initalState){
        state = initalState;
    }
    public void changeState(LighrState gState){
        state = gState;
    }
    public void waitLight() throws InterruptedException {
        state.waitLight();
    }

}
