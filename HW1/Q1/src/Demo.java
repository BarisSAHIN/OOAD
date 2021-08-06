import javax.naming.OperationNotSupportedException;
import java.util.Scanner;

/**
 * Demo class illustrates our program.
 */
public class Demo {
    public static void main(String[] args) {

        System.out.println("Soltion for:\n| 2 4 -8| |10|\n|4 2 -12| |16|\n|8 -2 -24| |26|\n");

        test();

    }

    /**
     * Test with static input.
     */
    static void test() {
        try {
            double[][] leftSide = new double[][]{
                    {2, 4, -8},
                    {4, 2, -12},
                    {8, -2, -24}
            };

            double[] rightSide = new double[]{
                    10, 16, 26
            };
            SolverMethod m = new MatrixInversion();
            SolverMethod g = new GaussianElimination();
            LinearEquationSolver solver = new LinearEquationSolver(leftSide, rightSide, m);
            double[] res = solver.solveEquations();

            if (res != null) {
                for (int i = 0; i < res.length; i++) {
                    System.out.println("X" + i + "= " + res[i]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test with user input. User need to enter equations one by one.
     */
}
