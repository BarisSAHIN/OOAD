import java.util.Scanner;

/**
 * Test midterm TeplateQ4
 */
public class Test{
        public static void main(String[] args) {
            System.out.println("Liste:" + args.length);
            FunctionTransform sol1 = new DFT(args[0],args[1]);
            FunctionTransform sol2 = new DCT(args[0],args[1]);


            System.out.println("Select solution:\n1 for DFT\n2 for DCT");
            Scanner reader = new Scanner(System.in);
            String opt = reader.next();
            while(true){
                if (opt == "1"){
                    sol1.calculateSolution();
                    return;
                }
                else if (opt == "2"){
                    sol2.calculateSolution();
                    return;}
                else{
                    System.out.println("Please only enter 1 or 2:\n1 for DFT\n2 for DCT");
                }
            }





        }

}
