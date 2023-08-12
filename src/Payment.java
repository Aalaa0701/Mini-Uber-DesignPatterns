import java.util.Scanner;

public class Payment {

    public Payment() {
        while(true){
            System.out.println("Type V for Visa Or C for Cash");
            Scanner Input = new Scanner(System.in);
            char Reply = Input.next().charAt(0);
            if(Reply == 'V' || Reply == 'v'){
                Visa VisaObject = new Visa();
                break;
            }
            else if(Reply == 'C' || Reply == 'c') {
                Cash CashObject = new Cash();
                break;
            }

        }

    }


}
