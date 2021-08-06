/**
 * Base interface for Case types in Abstract Factory pattern
 * But i defined it as a class to prevent code duplication and for easier use
 *
 * Its Factorial instance is protected and initialized in subclasses in constructors
 * and no other way to change its value again
 * */
public class Case{

    String size;
    boolean dustproof;
    boolean waterproof;
    protected int waterproofCm;
    String material;
    /**
     * For printing the properties of a case
     *
     * */
    public String getProperties(){
        return "Case: \n"
                + "\tSize: " + size +"mm\n"
                + "\tDustproof: " + dustproof +"\n"
                + "\tWaterproof: " +waterproof +"\n"
                + "\tWaterproof range: " +waterproofCm +"cm\n"
                + "\tMaterial: "  + material + "\n";
    }

}
