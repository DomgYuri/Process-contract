import models.entities.Contract;
import models.entities.Installment;
import models.services.ContractService;
import models.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("enter a data contrat: ");
        System.out.print("Contract number: ");
        int numberContract = sc.nextInt();
        System.out.print("Data(dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), formatter);
        System.out.print("Value cotract: ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(numberContract, date, totalValue);

        System.out.print("Enter a number installment: ");
        int numberInstallment = sc.nextInt();

        ContractService service = new ContractService(new PaypalService());
        service.processContrac(contract, numberInstallment);

        System.out.println("Parcelas:");
        for (Installment intallment : contract.getInstallments()) {
            System.out.println(intallment);
        }
    }
}