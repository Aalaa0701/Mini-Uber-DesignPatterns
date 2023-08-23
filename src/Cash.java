public class Cash implements PaymentMethod{
    @Override
    public void Pay() {
        System.out.println("Cash");
    }
}
