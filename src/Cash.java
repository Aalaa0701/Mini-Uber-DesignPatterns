public class Cash implements PaymentMethod{
    @Override
    public void Pay(double amount) {
        System.out.println("You have Paid an amount of: "+amount+"$ Successfully");
    }
}
