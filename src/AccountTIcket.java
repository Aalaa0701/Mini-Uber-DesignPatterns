import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class AccountTIcket extends Ticket implements Request_ticket {
int op ;

    Map<String, String> map = new HashMap<>();
    //private ArrayList<String> Account_Issues;

    public AccountTIcket() {
        super("Account");
    }
    public void request(){
System.out.println("Forget Password click 1 ");
System.out.println("Account Hacked click 2 (change Password)");

        Scanner myObj = new Scanner(System.in);
        Integer op = myObj.nextInt();
if(op  == 1){

    System.out.println(" Please Enter Your number :  ");
    Scanner my = new Scanner(System.in);
    String num = myObj.nextLine();
if(map.containsKey(num)){
    System.out.println("Your Password Is : " + map.get(num));
}
else {
    System.out.println("Not Found");
}

}

else if(op == 2){
    System.out.println(" Please Enter Your number :  ");
    Scanner m = new Scanner(System.in);
    String num2 = myObj.nextLine();
    if(map.containsKey(num2)){
        Scanner m1 = new Scanner(System.in);
        String input = myObj.nextLine();
        map.put(num2,input);
    }
    else {
        System.out.println("Not Found ! ");
    }
// hyd5l input be el new password

}

    }


}
