import org.apache.commons.math3.linear.*;

/**
 * MatrixInversion method for solving linear equations.
 */
public class MatrixInversion implements SolverMethod {
    /**
     * Solves the linear equations and returns the solution.
     * @param leftSide Left hand side of the linear equations, two dimensional array.
     * @param rightSide Right hand side of the linear equations, array.
     * @return If linear equations have solution returns the solution array, otherwise null.
     */
    @Override
    public double[] solve(double[][] leftSide, double[] rightSide) {
        RealMatrix matrix = MatrixUtils.createRealMatrix(leftSide);
        double det = new LUDecomposition(matrix).getDeterminant();
        if(det == 0){
            return null;
        }
        RealMatrix inverseOfMatrix = MatrixUtils.inverse(matrix);
        RealMatrix rightSideMatrix = MatrixUtils.createColumnRealMatrix(rightSide);
        RealMatrix multiplyResult = inverseOfMatrix.multiply(rightSideMatrix);
        return multiplyResult.getColumn(0);
    }
}
