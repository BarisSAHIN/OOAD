/**
 * Container class for  satellite transmits data
 */
public class STDRepository implements Container{

    int[][] data;

    /**
     * Constructor
     * @param data
     */
    public STDRepository(int[][] data) {
        this.data = data;
    }

    /**
     * Iterator Method
     * @return
     */
    @Override
    public Iterator getIterator() {
        return new STDIterator(data);
    }
}
