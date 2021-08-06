/**
 * Base interface for Storge types in Abstract Factory pattern
 * But i defined it as a class to prevent code duplication and for easier use
 *
 * Its Factorial instance is protected and initialized in subclasses in constructors
 * and no other way to change its value again
 * */
public class Storage{
    boolean microSDSup;
    int current;
    protected int max;

    /**
     * For printing the properties of a Storage
     *
     * */
    public String getProperties(){
        return "Storage: \n"
                + "\tMicroSD Support: " + microSDSup +"\n"
                + "\tStart Storage: " + current +"GB\n"
                + "\tMAX Storage: " +max +"GB\n";
    }
}
