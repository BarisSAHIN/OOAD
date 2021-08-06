import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * Our proxy for synchronized access
 *
 * */
public class Proxy implements ITable{

    ITable table;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    int readerCount = 0;
    Proxy(ITable gTable){
        table = gTable;
    }

    /**Reader prioritized get element function
     *
     *
     */

    @Override
    public Object getElementAt(int row, int column) {
        readerCount ++;
        if(readerCount == 1)
            readWriteLock.writeLock().lock();
        readWriteLock.readLock().lock();
        Object returnVal = table.getElementAt(row,column);
        readWriteLock.readLock().unlock();
        readerCount--;
        if(readerCount == 0)
            readWriteLock.writeLock().unlock();
        return returnVal;

    }
    /**
     *
     * Synchronized setElement function
     *
     * */
    @Override
    public void setElementAt(int row, int column, Object o) {
        readWriteLock.writeLock().lock();
        table.setElementAt(row,column,o);
        readWriteLock.writeLock().unlock();
    }

    @Override
    public int getNumberOfRows() {
        return table.getNumberOfRows();
    }

    @Override
    public int getNumberOfColumns() {
        return table.getNumberOfColumns();
    }
}
