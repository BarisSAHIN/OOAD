/**
 * Base interface for Camera types in Abstract Factory pattern
 * But i defined it as a class to prevent code duplication and for easier use
 *
 * Its Factorial instance is protected and initialized in subclasses in constructors
 * and no other way to change its value again
 * */
public class PhoneCamera{

    int front;
    int rear;
    protected int zoom;
    /**
     * For printing the properties of a Camera
     *
     * */
    public String getProperties(){
        return "Camera: \n"
                + "\tFront: " + front +"Mp\n"
                + "\tRear: " + rear +"Mp\n"
                + "\tZoom: X" +zoom +"\n";
    }
}
