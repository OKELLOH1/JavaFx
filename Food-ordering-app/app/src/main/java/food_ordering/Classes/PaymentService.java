package food_ordering.Classes;
import food_ordering.Interfaces.*;

// PaymentService class that implements Payment interface
public class PaymentService implements Payment {
    public void pay(double amount) {
        // code to process payment
        System.out.println("Payment of $" + amount + " processed successfully!");
    }

    public void refund(double amount) {
        // code to process refund
        System.out.println("Refund of $" + amount + " processed successfully!");
    }
}
