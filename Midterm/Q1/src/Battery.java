/**
 * Base interface for Battery types in Abstract Factory pattern
 * But i defined it as a class to prevent code duplication and for easier use
 *
 * Its Factorial instance is protected and initialized in subclasses in constructors
 * and no other way to change its value again
 * */
public class Battery{
    int hours;
    int amper;
    protected String material;
    /**
     * For printing the properties of a battery
     *
     * */
    public String getProperties(){
        return "Battery: \n"
                + "\tHours: " + hours +"h\n"
                + "\tAmper: " + amper +"mAh\n"
                + "\tMaterial: " +material +"\n";
    }
}
