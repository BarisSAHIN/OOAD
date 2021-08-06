/**
 * Smart phone model IflasDeluxe blueprint class
 *
 * It has all the function the build a IflasDeluxe smart phone
 *
 * It changes changeable parameters in given component according to given features in IflasDeluxe doc
 * end does told operation
 * */
public class IflasDeluxe extends AbstractPhone{

    @Override
    public void attachCPUandRAM(CPURam gcpuRam) {
        System.out.println("-----------------");
        System.out.println("Producing Iflas Deluxe" );
        System.out.println("-----------------");
        System.out.println("CPU attaced");
        gcpuRam.cpuSpeed = 2.2;
        gcpuRam.ramSize = 6;
        super.cpuRam = gcpuRam;
        System.out.println(gcpuRam.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachDisplay(Display gDisplay) {
        System.out.println("Display attaced");
        gDisplay.size = 5.3;
        super.display = gDisplay;
        System.out.println(gDisplay.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachBattery(Battery gBattery) {
        System.out.println("Battery attaced");
        gBattery.hours = 20;
        gBattery.amper = 2800;
        super.battery = gBattery;
        System.out.println(gBattery.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachStorage(Storage gStorage) {
        System.out.println("Storage attaced");
        gStorage.current = 34;
        gStorage.microSDSup = true;
        super.storage = gStorage;
        System.out.println(gStorage.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachCamera(PhoneCamera gCamera) {
        System.out.println("Camera attaced");
        gCamera.front = 12;
        gCamera.rear = 5;
        super.camera = gCamera;
        System.out.println(gCamera.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void enclosePhoneCase(Case gCase) {
        System.out.println("Case enclosed");
        gCase.size = "149x73x7.7";
        gCase.dustproof = false;
        gCase.waterproof = true;
        gCase.material = "Aluminum";
        super.phoneCase = gCase;
        System.out.println(gCase.getProperties());
        System.out.println("-----------------");
        System.out.println("Iflas Deluxe produced!");
        System.out.println("-----------------");
    }

}
