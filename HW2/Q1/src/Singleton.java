/**
 * Singleton class with clone function overwritten
 *
 * */
public final class Singleton extends Parent{
    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        // I put a sleep in initialization for observation.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
        System.out.println("Singleton created(Constructor)");
    }

    @Override
    protected Object clone() {
        return instance;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            System.out.println("Singleton created(getInstance)");
            instance = new Singleton(value);

        }
        return instance;
    }
}