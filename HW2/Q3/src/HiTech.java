import java.util.ArrayList;

public class HiTech implements Publisher {

    ArrayList<Subscriber> subs;

    HiTech(){

        subs = new ArrayList<>();
    }
    @Override
    public void addSubscriber(Subscriber subscriber) {
        subs.add(subscriber);
    }

    @Override
    public void deleteSubscriber(Subscriber subscriber) {
        subs.remove(subs.indexOf(subscriber));
    }

    @Override
    public void notifySubscribers(boolean flag) {
        if(flag == true)
            System.out.println("Traffic has increased substantially");
        else
            System.out.println("Traffic runs normaly");
        for (int i = 0; i < subs.size(); i++) {
            subs.get(i).update(flag);
        }
    }
    public void changeDetected(boolean flag){
        notifySubscribers(flag);
    }
}
