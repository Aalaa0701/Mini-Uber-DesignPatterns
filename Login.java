import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login implements InputData,  Validation{
    private String username;
    private String password;
//    Info obj = new Info("Nour" , "8888", "8888");

//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
    public static Map<String, Info> users = new HashMap<>();

//    public Login(Map<String, Info> users) {
//            this.users = users;
//            this.username = "";
//            this.password = "";
//    }




    @Override
    public void Data() {
        System.out.println(" Enter your username \n");
        Scanner input = new Scanner(System.in);
         username = input.nextLine();
//        username = username.trim();

        System.out.print(" Enter your password \n");
        password = input.nextLine();
//        password = password.trim();
        validData();
    }

    @Override
    public void validData() {
        Info info = new Info("BasmalaNaeem", "1234");
        users.put("BasmalaNaeem", info);
        if (users.containsKey(username)) {
            Info userInfo = users.get(username);
            if (userInfo.getPassword().equals(password)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        } else {
            System.out.println("Invalid username. Please try again.");
        }
    }
}
