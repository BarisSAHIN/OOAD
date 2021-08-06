/**
 * Gauissan elimination method for solving linear equations.
 */
public class GaussianElimination implements SolverMethod {

    /**
     * Solves the linear equations and returns the solution.
     * @param leftSide Left hand side of the linear equations, two dimensional array.
     * @param rightSide Right hand side of the linear equations, array.
     * @return If linear equations have solution returns the solution array, otherwise null.
     */
    @Override
    public double[] solve(double[][] leftSide, double[] rightSide) {
        boolean noSolution = false;
        double[] solution = new double[rightSide.length];

        int N = rightSide.length;
        for (int row = 0; row < (N - 1); row++) {
            for (int i = row + 1; i < N; i++) {
                double factor = leftSide[i][row] / leftSide[row][row];
                for (int j = row; j < N; j++) {
                    leftSide[i][j] = leftSide[i][j] - (factor * leftSide[row][j]);
                }
                rightSide[i] = rightSide[i] - (factor * rightSide[row]);
            }
        }

        if (!checkHaveSolution(leftSide)) {
            return null;
        }

        for (int i = N - 1; i > -1; i--) {
            double s = 0;
            for (int j = N - 1; j > i; j--) {
                s += (leftSide[i][j] * solution[j]);
            }
            solution[i] = (rightSide[i] - s) / leftSide[i][i];
        }

        return solution;
    }

    /**
     * Check if the linear equations have solution.
     * @param leftSide Left hand side after apply gaussian elimination.
     * @return If equations have solution true, otherwise false.
     */
    private boolean checkHaveSolution(double[][] leftSide) {
        for (int i = 0; i < leftSide[0].length; i++) {
            int zeroElementCount = 0;
            for (int j = 0; j < leftSide[i].length; j++) {
                if (leftSide[i][j] == 0) zeroElementCount++;
            }
            if (zeroElementCount >= leftSide[0].length) return false;
        }
        return true;
    }
}
