/**
 * Base interface for Display types in Abstract Factory pattern
 * But i defined it as a class to prevent code duplication and for easier use
 *
 * Its Factorial instance is protected and initialized in subclasses in constructors
 * and no other way to change its value again
 * */
public class Display{

    double size;
    protected int bit;
    /**
     * For printing the properties of a display
     *
     * */
    public String getProperties(){
        return "Display: \n"
                + "\tSize: " + size +" inch\n"
                + "\tBit: " + bit +" bit\n";
    }

}
