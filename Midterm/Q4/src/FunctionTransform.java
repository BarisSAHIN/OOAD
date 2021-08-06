import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class FunctionTransform {
    /**
     * Read from file 1d double array
     * @throws FileNotFoundException
     */
    public abstract void readFromFile() throws FileNotFoundException;

    /**
     * Write result for the method
     * @throws IOException
     */
    public abstract void writeToFile() throws IOException;

    /**
     * Solving function template method
     */
    public abstract void  solve();

    /**
     * Exec time see question method
     */
    public abstract boolean ExecTimeWant();
    /**
     * Final method for calculation
     */
    public final void calculateSolution(){

        try {

            readFromFile();
            ExecTimeWant();
            solve();
            writeToFile();

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
