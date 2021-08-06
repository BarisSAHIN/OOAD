/**
 * Smart phone model I-I Aman Iflas blueprint class
 *
 * It has all the function the build a I-I Aman Iflas smart phone
 *
 * It changes changeable parameters in given component according to given features in I-I Aman Iflas doc
 *  * end does told operation
 * */
public class IIAmanIflas extends AbstractPhone{
    @Override
    public void attachCPUandRAM(CPURam gcpuRam) {
        System.out.println("-----------------");
        System.out.println("Producing I-I-Aman-Iflas" );
        System.out.println("-----------------");
        System.out.println("CPU attaced");
        gcpuRam.cpuSpeed = 2.2;
        gcpuRam.ramSize = 4;
        super.cpuRam = gcpuRam;
        System.out.println(gcpuRam.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachDisplay(Display gDisplay) {
        System.out.println("Display attaced");
        gDisplay.size = 4.5;
        super.display = gDisplay;
        System.out.println(gDisplay.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachBattery(Battery gBattery) {
        System.out.println("Battery attaced");
        gBattery.hours = 16;
        gBattery.amper = 2000;
        super.battery = gBattery;
        System.out.println(gBattery.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachStorage(Storage gStorage) {
        System.out.println("Storage attaced");
        gStorage.current = 16;
        gStorage.microSDSup = true;
        super.storage = gStorage;
        System.out.println(gStorage.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void attachCamera(PhoneCamera gCamera) {
        System.out.println("Camera attaced");
        gCamera.front = 8;
        gCamera.rear = 5;
        super.camera = gCamera;
        System.out.println(gCamera.getProperties());
        System.out.println("-----------------");
    }

    @Override
    public void enclosePhoneCase(Case gCase) {
        System.out.println("Case enclosed");
        gCase.size = "143x69x7.3";
        gCase.dustproof = false;
        gCase.waterproof = true;
        gCase.material = "Plastic";
        super.phoneCase = gCase;
        System.out.println(gCase.getProperties());
        System.out.println("-----------------");
        System.out.println("I-I-Aman-Iflas produced!");
        System.out.println("-----------------");
    }
}
