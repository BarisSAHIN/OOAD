/**
 * Global Factory
 * it gives phone specific components related with its market
 * 24 bit
 * Lithium-Cobalt
 * 2 cores
 * Max 32GB
 * Opt. zoom x2
 * Waterproof up to 50Cm
 * */
public class GlobalFactory extends  AbstarctFactory{
    @Override
    public AbstractPhone takeOrder(Model model) {
        AbstractPhone phone = choosePhone(model);
        if(phone == null){
            System.out.println("Iflas-Technologies Ltd has no model like this please give a valid model:");
            System.out.println("Our models are:");
            System.out.println("MAXIMUMEFFOR\nIFLASDELUXE\nIIAMANIFLAS\n");
            return null;
        }

        System.out.println("Global Factory Working!");
        phone.attachCPUandRAM(new CPU2Core());
        phone.attachDisplay(new Display24Bit());
        phone.attachBattery(new BatteryCobalt());
        phone.attachStorage(new Storage32GB());
        phone.attachCamera(new CameraX2());
        phone.enclosePhoneCase(new Case50CM());
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
