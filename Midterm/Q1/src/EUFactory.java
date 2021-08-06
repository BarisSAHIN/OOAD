/**
 * EU Factory
 * it gives phone specific components related with its market
 * 24 bit
 * Lithium-Ion
 * 4 cores
 * Max 64GB
 * Opt. zoom x3
 * Waterproof up to 1m
 * */
public class EUFactory extends  AbstarctFactory{
    @Override
    public AbstractPhone takeOrder(Model model) {
        AbstractPhone phone = choosePhone(model);
        if(phone == null){
            System.out.println("Iflas-Technologies Ltd has no model like this please give a valid model:");
            System.out.println("Our models are:");
            System.out.println("MAXIMUMEFFOR\nIFLASDELUXE\nIIAMANIFLAS\n");
            return null;
        }

        System.out.println("EU Factory Working!");
        phone.attachCPUandRAM(new CPU4Core());
        phone.attachDisplay(new Display24Bit());
        phone.attachBattery(new BatteryIon());
        phone.attachStorage(new Storage64GB());
        phone.attachCamera(new CameraX3());
        phone.enclosePhoneCase(new Case1M());
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
