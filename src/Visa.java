import java.util.Scanner;

public class Visa implements PaymentMethod{
    @Override
    public void pay(double amount) {
        do {
            Scanner Input = new Scanner(System.in);
            System.out.println("Please enter your 16-digits visa number!");
            String VisaNumber = Input.next();
            if(ValidateNumber(VisaNumber)){
                //Right visa number
                System.out.println("Successful");
                System.out.println("Your have paid "+amount +"$ successfully" );

                break;
            }
            else{
                System.out.println("Not A valid number");
            }
        }while (true);

    }
     boolean ValidateNumber(String NumberToBeValidated){
         return NumberToBeValidated.length() == 16;
    }
}
