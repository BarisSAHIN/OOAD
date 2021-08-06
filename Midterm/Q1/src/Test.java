/**
 * Test class for midterm AbstractFactoryQ1
 *
 * */
public class Test {

    public static void main(String[] args){

        AbstarctFactory turkeyFactory = new TurkeyFactory();
        AbstarctFactory euFactory = new EUFactory();
        AbstarctFactory globalFactory = new GlobalFactory();

        System.out.println("#################################");
        System.out.println("Tests For Turkey Factory");
        System.out.println("#################################");
        System.out.println("Test Maximum Efford");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        turkeyFactory.takeOrder(Model.MAXIMUMEFFORD);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        turkeyFactory.takeOrder(Model.IFLASDELUXE);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        turkeyFactory.takeOrder(Model.IIAMANIFLAS);
        System.out.println("#################################");
        System.out.println("Tests For Turkey Factory Finished");
        System.out.println("#################################");
        System.out.println("\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
        System.out.println("#################################");
        System.out.println("Tests For EU Factory");
        System.out.println("#################################");
        System.out.println("Test Maximum Efford");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        euFactory.takeOrder(Model.MAXIMUMEFFORD);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        euFactory.takeOrder(Model.IFLASDELUXE);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        euFactory.takeOrder(Model.IIAMANIFLAS);
        System.out.println("#################################");
        System.out.println("Tests For EU Factory Finished");
        System.out.println("#################################");
        System.out.println("\nVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV\n");
        System.out.println("#################################");
        System.out.println("Tests For Global Factory");
        System.out.println("#################################");
        System.out.println("Test Maximum Efford");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        globalFactory.takeOrder(Model.MAXIMUMEFFORD);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        globalFactory.takeOrder(Model.IFLASDELUXE);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        globalFactory.takeOrder(Model.IIAMANIFLAS);
        System.out.println("#################################");
        System.out.println("Tests For Global Factory Finished");
        System.out.println("#################################");
    }
}
