/**
 * Base interface for CPU and RAM types in Abstract Factory pattern
 * But i defined it as a class to prevent code duplication and for easier use
 *
 * Its Factorial instance is protected and initialized in subclasses in constructors
 * and no other way to change its value again
 * */
public class CPURam{

    double cpuSpeed;
    int ramSize;
    protected int cpuCount;
    /**
     * For printing the properties of a CPU and RAM
     *
     * */
    public String getProperties(){
        return "CPU & RAM: \n"
                + "\tCPU Speed: " + cpuSpeed +"GHz\n"
                + "\tRAM Size: " + ramSize +"GB\n"
                + "\tCore Count: " +cpuCount +"\n";
    }

}
