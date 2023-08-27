public class Cash implements PaymentMethod{
    @Override
    public void Pay(int amount) {
        System.out.println("You have Paid an amount of: "+amount+"$ Successfully");
    }
}
