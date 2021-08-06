package sample;

/**
 * Hospital class for keeping the count of a hospital
 *
 * */
public class Hospital {

    private final int hospitalCapacity;
    private int empty;
    Hospital(int capacity){
        hospitalCapacity = capacity;
        empty = capacity;
    }

    public boolean isEmpty(){
        return empty != 0;
    }
    public boolean hospitalize() {
        if (empty != 0) {
            empty--;
            return true;
        }
        else return false;
    }
    public boolean discharge(){
        if (empty < hospitalCapacity) {
            empty++;
            return true;
        }
        else return false;
    }
    public int getHospitalCapacity(){
        return hospitalCapacity;
    }
    public int getEmpty(){
        return empty;
    }
}
