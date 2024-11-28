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
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interst = onlinePaymentService.interst(valueContract, i);
            double fee = onlinePaymentService.paymentFee(interst + valueContract);
            double totalValue = valueContract + interst + fee;
            contract.setInstallments(new Installment(dueDate, totalValue));
        }
    }
}
