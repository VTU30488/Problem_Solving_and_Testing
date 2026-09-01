import java.util.*;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
    }
}

class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
    }
}

class NetBankingPayment implements Payment {
    @Override
    public void pay(double amount) {
    }
}

abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

class OnlinePaymentProcessor extends PaymentProcessor {

    @Override
    double processPayment(Payment payment, double amount) {
        if (payment instanceof CreditCardPayment) {
            return amount + (amount * 0.02);
        } 
        else if (payment instanceof UPIPayment) {
            return amount + (amount * 0.01);
        } 
        else if (payment instanceof NetBankingPayment) {
            return amount + (amount * 0.015);
        }

        return amount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < n; i++) {
            int paymentType = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;
            String paymentName;

            if (paymentType == 1) {
                payment = new CreditCardPayment();
                paymentName = "CreditCard";
            } 
            else if (paymentType == 2) {
                payment = new UPIPayment();
                paymentName = "UPI";
            } 
            else {
                payment = new NetBankingPayment();
                paymentName = "NetBanking";
            }

            double finalAmount = processor.processPayment(payment, amount);

            System.out.printf("%s %.2f%n", paymentName, finalAmount);
        }

        sc.close();
    }
}