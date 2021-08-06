/**
 * Smart phone model Maximum Effort blueprint class
 *
 * It has all the function the build a Maximum Effort smart phone
 *
 * It changes changeable parameters in given component according to given features in Maximum Effort doc
 *  *  * end does told operation
 * */
public class MaximumEfford extends AbstractPhone {


    @Override
    public void attachCPUandRAM(CPURam gcpuRam) {
        System.out.println("-----------------");
        System.out.println("Producing Maximum Efford" );
        System.out.println("-----------------");
        System.out.println("CPU attaced");
        gcpuRam.cpuSpeed = 2.8;
        gcpuRam.ramSize = 8;
        super.cpuRam = gcpuRam;
        System.out.println(gcpuRam.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachDisplay(Display gDisplay) {
        System.out.println("Display attaced");
        gDisplay.size = 5.5;
        super.display = gDisplay;
        System.out.println(gDisplay.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachBattery(Battery gBattery) {
        System.out.println("Battery attaced");
        gBattery.hours = 27;
        gBattery.amper = 3600;
        super.battery = gBattery;
        System.out.println(gBattery.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachStorage(Storage gStorage) {
        System.out.println("Storage attaced");
        gStorage.current = 64;
        gStorage.microSDSup = true;
        super.storage = gStorage;
        System.out.println(gStorage.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachCamera(PhoneCamera gCamera) {
        System.out.println("Camera attaced");
        gCamera.front = 12;
        gCamera.rear = 8;
        super.camera = gCamera;
        System.out.println(gCamera.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void enclosePhoneCase(Case gCase) {
        System.out.println("Case enclosed");
        gCase.size = "151x73x7.7";
        gCase.dustproof = true;
        gCase.waterproof = true;
        gCase.material = "Aluminum";
        super.phoneCase = gCase;
        System.out.println(gCase.getProperties());
        System.out.println("-----------------");
        System.out.println("Maximum Efford produced!");
        System.out.println("-----------------");
    }
}
