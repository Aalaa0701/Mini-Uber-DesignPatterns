import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login implements InputData,  Validation{
    private String username;
    private String password;
    boolean userFound = false;

    Map<String,User> users;

   // public static Map<String, User> users = new HashMap<>();


    public Login(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public void data() {
        do {
            System.out.print("Enter your username \n");
            Scanner input = new Scanner(System.in);
            username = input.nextLine();

            System.out.print("Enter your password \n");
            password = input.nextLine();

            validData();
        }while(!userFound);

    }

    @Override
    public void validData() {
        if (users.containsKey(username)) {
            User userInfo = users.get(username);
            if (userInfo.getPassword().equals(password)) {
                System.out.println("Login successful!");
                userFound = true;
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        } else {
            System.out.println("Invalid username. Please try again.");
        }
    }

    public String getUsername() {
        return username;
    }

}
