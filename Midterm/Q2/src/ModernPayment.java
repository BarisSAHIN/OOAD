/**
 * After long hours at work I have finally completed the new java
 * interface for credit card payments!
 *
 *
 * */

public interface ModernPayment {

    /**
     * New payment method
     *
     * */
    int pay(String cardNo, float amount, String destination, String installments);
}
