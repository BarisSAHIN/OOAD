/**
 * Test class for singleton illegal cloning experiments
 * */

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("If you see the same value, then singleton was successfully implemented" + "\n" +
                "If you see different values, then 2 singletons were created (Fail)" + "\n\n" +
                "RESULT:" + "\n");
        Singleton singleton = Singleton.getInstance("TestObj1");
        Singleton anotherSingleton = Singleton.getInstance("TestObj2");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);

        System.out.println("Illegal cloning experiment >:)");
        Singleton molly = (Singleton) singleton.clone();

        System.out.println("\nSingleton hashCode:- "
                + singleton.hashCode());
        System.out.println("Molly hashCode:- "
                + molly.hashCode());
    }


}
