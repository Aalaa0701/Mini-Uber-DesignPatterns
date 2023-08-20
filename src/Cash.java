public class Cash implements PaymentMethod{
    public Cash(){
        Pay();
    }
    @Override
    public void Pay() {
        System.out.println("Cash");
    }
}
