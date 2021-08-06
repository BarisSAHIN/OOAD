import javax.naming.OperationNotSupportedException;
import java.util.Scanner;

/**
 * Linear equation solver class.
 */
public class LinearEquationSolver {

    private double[][] leftSide;
    private double[] rightSide;
    private SolverMethod solverMethod;
    private boolean isInputAdmitted;

    LinearEquationSolver(double[][] leftSide, double[] rightSide, SolverMethod solverMethod) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.solverMethod = solverMethod;
        isInputAdmitted = true;
    }

    LinearEquationSolver() {
    }

    /**
     * Set solver method, Gaussian elimination or Matrix inversion method for now.
     * @param solverMethod Method that imlements the SolverMethod interface.
     */
    public void setSolverMethod(SolverMethod solverMethod) {
        this.solverMethod = solverMethod;
    }

    /**
     * Solve equation using specified solver method.
     * @return If equations have solution return solution array otherwise null.
     * @throws OperationNotSupportedException If inputs are not given, the exception will be thrown.
     */
    public double[] solveEquations() throws OperationNotSupportedException {
        if (!isInputAdmitted) {
            throw new OperationNotSupportedException("Please use getInputsFromUser() method to before solve equations!");
        }
        if (this.solverMethod == null) {
            throw new OperationNotSupportedException("Please use setSolverMethod before solve equations!");
        }
        double[] result = solverMethod.solve(leftSide, rightSide);

        if (result == null) {
            System.out.println("No solution!");
        }
        return result;
    }

    /**
     * Get equations values from user. If you do not want to enter values, you can pass your equations as array to constructor.
     */
    public void getInputsFromUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter linear equation count that you will enter:");
        int size = scan.nextInt();
        scan.nextLine();

        leftSide = new double[size][size];
        rightSide = new double[size];

        System.out.println("Please enter linear equation like below:");
        System.out.println("1;2;-4=5\n2;1;-6=8\n4;-1;-12=13");
        for (int j = 0; j < size; j++) {
            System.out.print(j + ": ");
            String line = scan.nextLine();
            double right;
            double[] left = new double[size];
            String[] leftAndRightSide = line.split("=");
            right = Double.parseDouble(leftAndRightSide[1]);

            String[] leftStr = leftAndRightSide[0].split(";");
            for (int i = 0; i < leftStr.length; i++) {
                left[i] = Double.parseDouble(leftStr[i]);
            }
            leftSide[j] = left;
            rightSide[j] = right;
        }

        isInputAdmitted = true;

    }


}
