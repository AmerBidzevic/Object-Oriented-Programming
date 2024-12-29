package Lab13;
import java.util.*;


interface Payment {
    void processPayment();
}

class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing Credit Card Payment.");
    }
}

class PayPalPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing PayPal Payment.");
    }
}

interface PaymentFactory {
    Payment createPayment();
}

class CreditCardPaymentFactory implements PaymentFactory {
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}

class PayPalPaymentFactory implements PaymentFactory {
    public Payment createPayment() {
        return new PayPalPayment();
    }
}
class Main{
    public static void main(String[] args) {
        PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
        Payment creditPayment = creditCardFactory.createPayment();
        creditPayment.processPayment();

        PaymentFactory payPalFactory = new PayPalPaymentFactory();
        Payment payPalPayment = payPalFactory.createPayment();
        payPalPayment.processPayment();
    }
}