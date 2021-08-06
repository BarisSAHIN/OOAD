/**
 * old binary library from the 1990s called
 * TurboPayment for card payments
 *
 *
 * */
public interface TurboPayment {

    /**
     * Old payment method
     *
     * */
    int payInTurbo(String turboCardNo, float turboAmount,
                   String destinationTurboOfCourse, String installmentsButInTurbo);
}
