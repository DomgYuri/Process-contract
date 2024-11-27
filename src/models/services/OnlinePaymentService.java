package models.services;

public interface OnlinePaymentService {

    double paymentFee(double amount);

    double interst (double amount, int mounts);

}
