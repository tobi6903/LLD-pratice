package PaymentStrategyPattern;

public class Payment {
    private PaymentStrategy paymentStrategy;
    private double amount;

    public Payment(double amount, PaymentStrategy paymentStrategy){
        this.amount=amount;
        this.paymentStrategy=paymentStrategy;
    }

    public void processPayment(double amount){
        if(amount > 0){
            paymentStrategy.processPayment(amount);
        }
        else{
            System.out.println("Invalid payment amount.");
        }
    }
}
