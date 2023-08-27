import java.util.Scanner;

public class Payment {
    PaymentMethod paymentMethod;

    public Payment(){};


    void handlePayment(int amount){
        while(true){
            System.out.println("Type V for Visa Or C for Cash");
            Scanner Input = new Scanner(System.in);
            char Reply = Input.next().charAt(0);
            if(Reply == 'V' || Reply == 'v'){
                Visa visaObject = new Visa();
                paymentMethod = visaObject;
                executePayment(amount);
                break;
            }
            else if(Reply == 'C' || Reply == 'c') {
                Cash cashObject = new Cash();
                paymentMethod = cashObject;
                executePayment(amount);
                break;
            }

        }
    }

    void executePayment(int amount){
        paymentMethod.Pay(amount);
    }


}
