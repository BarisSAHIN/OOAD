/**
 * Main product
 *
 * */
public abstract class AbstractPhone {

    protected Display display;
    protected Battery battery;
    protected CPURam cpuRam;
    protected Storage storage;
    protected PhoneCamera camera;
    protected Case phoneCase;

    /**Attaches the CPU and RAM  to the mainboard it takes CPU type as parameter
     * But only CPU count is unchangeable
     * All other paramaters in CPURam object can be changed by the class that implements this*/
    public abstract void attachCPUandRAM(CPURam gcpuRam);

    /**Attaches the Display  to the mainboard it takes Display type as parameter
     * But only bit is unchangeable
     * All other paramaters in Display object can be changed by the class that implements this*/
    public abstract void attachDisplay(Display gDisplay);

    /**Attaches the Battery  to the mainboard it takes Battery type as parameter
     * But only Materrial is unchangeable
     * All other paramaters in CPURam object can be changed by the class that implements this*/
    public abstract void attachBattery(Battery gBattery);

    /**Attaches the Storage  to the mainboard it takes Storage type as parameter
     * But only Max storage is unchangeable
     * All other paramaters in CPURam object can be changed by the class that implements this*/
    public abstract void attachStorage(Storage gStorage);

    /**Attaches the Camera to the mainboard it takes CPU type as parameter
     * But only zoom is unchangeable
     * All other paramaters in CPURam object can be changed by the class that implements this*/
    public abstract void attachCamera(PhoneCamera gCamera);

    /**Encloses the phone case it takes Case type as parameter
     * But only WatterproofMeter is unchangeable
     * All other paramaters in CPURam object can be changed by the class that implements this*/
    public abstract void enclosePhoneCase(Case gCase);
}
