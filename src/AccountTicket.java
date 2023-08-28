import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class AccountTicket extends Ticket implements Request_ticket {
int operationNumber;

    Map<String, String> map = new HashMap<>();
    //private ArrayList<String> Account_Issues;

    public AccountTicket() {
        super("Account");
    }
    public void request(){
        System.out.println("Forget Password click 1 ");
        System.out.println("Account Hacked click 2 (change Password)");

        Scanner myObj = new Scanner(System.in);
        operationNumber = myObj.nextInt();
        if(operationNumber  == 1){
            executeOperation1();
        }

        else if(operationNumber == 2){
            executeOperation2();
            // hyd5l input be el new password
        }

    }
    void executeOperation1(){
        System.out.println(" Please Enter Your number :  ");
        Scanner operation1Input = new Scanner(System.in);
        String num = operation1Input.nextLine();
        if(map.containsKey(num)){
            System.out.println("Your Password Is : " + map.get(num));
        }
        else {
            System.out.println("Not Found");
        }
    }
    void executeOperation2(){
        System.out.println(" Please Enter Your number :  ");
        Scanner operation2Input = new Scanner(System.in);
        String num2 = operation2Input.nextLine();
        if(map.containsKey(num2)){
         //   Scanner m1 = new Scanner(System.in);
            String input = operation2Input.nextLine();
            map.put(num2,input);
        }
        else {
            System.out.println("Not Found ! ");
        }
    }


}
