package models.services;

public class PaypalService implements OnlinePaymentService {

    private final double FEE = 0.02;
    private final double INTEREST = 0.01;

    @Override
    public double paymentFee(double amount) {
        return amount += amount * FEE;
    }

    @Override
    public double interst(double amount, int mounths) {
        double value = amount * INTEREST * mounths;
        return value + amount;
    }
}
