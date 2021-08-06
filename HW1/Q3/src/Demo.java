public class Demo {

    public static void main(String[] args){
        BattleSuit warMachine = new Tor();

        System.out.println("Warmachine MK1: " + warMachine.getName());
        System.out.println("Price: " + warMachine.getPrice() + " $");
        System.out.println("Weight: " + warMachine.getWeight() + " kg");

        warMachine = new RocketLauncher(warMachine);


        System.out.println("Warmachine MK2: " + warMachine.getName());
        System.out.println("Price: " + warMachine.getPrice() + " $");
        System.out.println("Weight: " + warMachine.getWeight() + " kg");

        warMachine = new AutoRifle(warMachine);


        System.out.println("Warmachine MK3: " + warMachine.getName());
        System.out.println("Price: " + warMachine.getPrice() + " $");
        System.out.println("Weight: " + warMachine.getWeight() + " kg");

        warMachine = new Flamethrower(warMachine);


        System.out.println("Warmachine MK4: " + warMachine.getName());
        System.out.println("Price: " + warMachine.getPrice() + " $");
        System.out.println("Weight: " + warMachine.getWeight() + " kg");


    }
}
