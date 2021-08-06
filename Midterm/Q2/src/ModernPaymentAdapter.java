
/**
 * Adapter class for adept old turbo interface to ModernPayment interface
 *
 * */
public class ModernPaymentAdapter implements ModernPayment{
    TurboPayment oldInterface;
    ModernPaymentAdapter(TurboPayment turbo){
        oldInterface = turbo;
    }
    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        return oldInterface.payInTurbo(cardNo,amount,destination,installments);
    }
}
