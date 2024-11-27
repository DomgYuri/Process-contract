package models.services;

import models.entities.Contract;
import models.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContrac (Contract contract, int mounths) {
        double valueContract = contract.getTotalValue() / mounths;
        for (int i = 1; i <= mounths; i++) {
            double paymentInterst = onlinePaymentService.interst(valueContract, i);
            double valueFinal = onlinePaymentService.paymentFee(paymentInterst);
            LocalDate dueDate = contract.getDate().plusMonths(i);
            contract.setInstallments(new Installment(dueDate, valueFinal));
        }
    }
}
