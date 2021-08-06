import java.util.ArrayList;

/**
 * Iterator class for satellite transmits data Container
 */

public class STDIterator implements Iterator {

    private ArrayList<Integer> STDlist;
    private java.util.Iterator<Integer> iter = null;

    /**
     * Generate iterotor on constructor
     * @param data
     */
    public  STDIterator(int[][] data){
        STDlist = new ArrayList<Integer>();
        int colLenght=data.length;
        int rowLenght=data[0].length;
        int rowNum=0, colNum=0;
        while (colLenght>0 && rowLenght>0){
            if (colLenght == 1) {
                for (int i = 0; i <rowLenght; i++) {
                    STDlist.add(data[rowNum][colNum++]);
                }
                break;
            }
            else if (rowLenght == 1) {
                for (int i = 0; i < colLenght ; i++) {
                    STDlist.add(data[rowNum++][colNum]);
                }
                break;
            }

            for (int i = 0; i < rowLenght-1 ; i++) {
                STDlist.add(data[rowNum][colNum++]);
            }
            for (int i = 0; i < colLenght-1 ; i++) {
                STDlist.add(data[rowNum++][colNum]);
            }
            for (int i = 0; i < rowLenght-1 ; i++) {
                STDlist.add(data[rowNum][colNum--]);
            }
            for (int i = 0; i < colLenght-1 ; i++) {
                STDlist.add(data[rowNum--][colNum]);
            }
            rowLenght-=2;
            colLenght-=2;
            colNum++;
            rowNum++;
        }
            iter = STDlist.iterator();
    }
    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Object next() {
        return iter.next();
    }
}
