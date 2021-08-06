public class YellowLight implements LighrState {
    @Override
    public void waitLight() throws InterruptedException {
        System.out.println("Yellow Light waiting for 3 sec");
        Thread.sleep(30);
    }
}
