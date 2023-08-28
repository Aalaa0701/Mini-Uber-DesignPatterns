public class Cash implements PaymentMethod{
    @Override
    public void Pay(double amount) {
        System.out.println("You will pay an amount of: "+amount+"$");
    }
}
