import java.util.Scanner;

public class Visa implements PaymentMethod{
    public Visa(){
        Pay();
    }
    @Override
    public void Pay() {
        Scanner Input = new Scanner(System.in);
        System.out.println("Please enter your 16-digits visa number!");
        String VisaNumber = Input.next();
        if(ValidateNumber(VisaNumber)){
            //Right visa number
            System.out.println("Successful");
        }
        else{
            System.out.println("Not A valid number");
        }
    }
     boolean ValidateNumber(String NumberToBeValidated){
         return NumberToBeValidated.length() == 16;
    }
}
