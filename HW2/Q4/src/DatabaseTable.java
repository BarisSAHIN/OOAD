/**
 * Old service with no sync
 *
 *
 * */
public class DatabaseTable implements ITable{

    Object [][] table;

    DatabaseTable(){
        int i = 0;
        int j = 0;
        table = new Object[10][10];
        for(i = 0;i<10;i++) {
            for (j = 0; j < 10; j++)
                table[i][j] = i + j;
        }
    }

    /**
     * Unsynchronized  getElement method
     *
     *
     * */
    @Override
    public Object getElementAt(int row, int column) {
        return table[row][column];
    }
    /**
     * Unsynchronized  setElement method
     *
     *
     * */
    @Override
    public void setElementAt(int row, int column, Object o) {
        table[row][column] = o;
    }

    @Override
    public int getNumberOfRows() {
        return table.length;
    }

    @Override
    public int getNumberOfColumns() {
        return table[0].length;
    }
}
