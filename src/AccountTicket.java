import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class AccountTicket implements Request_ticket{
int operationNumber;
    Map<String, User> usersMap;



    public AccountTicket(Map map) {
        this.usersMap=map;
    }


    @Override
    public void request() {
        System.out.println("Forget Password click 1 ");
        System.out.println("Account Hacked click 2 (change Password)");

        Scanner myObj = new Scanner(System.in);
        operationNumber = myObj.nextInt();
        if(operationNumber  == 1){
            executeOperation1();
        }

        else if(operationNumber == 2){
            executeOperation2();
        }

    }


    void executeOperation1(){
        System.out.println(" Please Enter Your username :  ");
        Scanner operation1Input = new Scanner(System.in);
        String username = operation1Input.nextLine();
        if(usersMap.containsKey(username)){
            System.out.println("Your Password Is : " + usersMap.get(username).getPassword());
        }
        else {
            System.out.println("Not Found");
        }
    }
    void executeOperation2(){
        System.out.println(" Please Enter Your username :  ");
        Scanner operation2Input = new Scanner(System.in);
        String username = operation2Input.nextLine();
        if(usersMap.containsKey(username)){
            System.out.println(" Please enter your new password");
            String input = operation2Input.nextLine();
            User userTemp = new User(username,input);
            usersMap.put(username,userTemp);
        }
        else {
            System.out.println("Not Found ! ");
        }
    }


}
