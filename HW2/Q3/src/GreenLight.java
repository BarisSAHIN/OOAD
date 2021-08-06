public class GreenLight implements LighrState,Subscriber{
    private int timeoutX;

    GreenLight(){
        timeoutX = 60;
    }
    @Override
    public void waitLight() throws InterruptedException {
        System.out.println("Red Light waiting for " + timeoutX + " sec");
        Thread.sleep(timeoutX);
    }

    @Override
    public void update(boolean flag) {
        if(flag){
            timeoutX = 90;
        }
        else
            timeoutX = 60;
    }
}
