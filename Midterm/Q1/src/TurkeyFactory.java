/**
 * Turkey Factory
 * it gives phone specific components related with its market
 *32 bit
 * Lithium-Boron
 * 8 cores
 * Max 128GB
 * Opt. zoom x4
 * Waterproof up to 2m
 * */
public class TurkeyFactory extends  AbstarctFactory{
    @Override
    public AbstractPhone takeOrder(Model model) {
        AbstractPhone phone = choosePhone(model);
        if(phone == null){
            System.out.println("Iflas-Technologies Ltd has no model like this please give a valid model:");
            System.out.println("Our models are:");
            System.out.println("MAXIMUMEFFOR\nIFLASDELUXE\nIIAMANIFLAS\n");
            return null;
        }
        System.out.println("Turkey Factory Working!");
        phone.attachCPUandRAM(new CPU8Core());
        phone.attachDisplay(new Display32Bit());
        phone.attachBattery(new BatteryBoron());
        phone.attachStorage(new Storage128GB());
        phone.attachCamera(new CameraX4());
        phone.enclosePhoneCase(new Case2M());
        return phone;
    }

    @Override
    protected AbstractPhone choosePhone(Model model) {
        if(model == Model.MAXIMUMEFFORD)
            return new MaximumEfford();
        else if(model == Model.IFLASDELUXE)
            return new IflasDeluxe();
        else if (model == Model.IIAMANIFLAS)
            return new IIAmanIflas();
        return null;
    }
}
