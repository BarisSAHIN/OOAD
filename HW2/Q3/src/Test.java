public class Test {

    public static void main(String[] args) throws InterruptedException {

        HiTech cam = new HiTech();
        GreenLight green = new GreenLight();
        RedLight red = new RedLight();
        YellowLight yellow = new YellowLight();
        TraficLight lights = new TraficLight(red);
        cam.addSubscriber(green);
        int i = 0;
        boolean trafficFlag = true;
        while(i<100){
            System.out.println("----------------------------Loop "+ i + " starts---------------------------\n");
            lights.waitLight();
            lights.changeState(green);
            lights.waitLight();
            lights.changeState(yellow);
            lights.waitLight();
            lights.changeState(red);
            if(i%25 == 0){
                cam.notifySubscribers(trafficFlag);
                trafficFlag = !trafficFlag;
            }
            i++;
        }

    }

}
