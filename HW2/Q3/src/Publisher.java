public interface Publisher {

    void addSubscriber(Subscriber subscriber);
    void deleteSubscriber(Subscriber subscriber);
    void notifySubscribers(boolean flag);
}
