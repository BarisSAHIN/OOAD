public class RedLight implements LighrState {
    @Override
    public void waitLight() throws InterruptedException {
        System.out.println("Red Light waiting for 15 sec");
        Thread.sleep(15);
    }
}
