import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login implements InputData,  Validation{
    private String username;
    private String password;

    public static Map<String, User> users = new HashMap<>();

    @Override
    public void Data() {
        System.out.println(" Enter your username \n");
        Scanner input = new Scanner(System.in);
         username = input.nextLine();

        System.out.print(" Enter your password \n");
        password = input.nextLine();

        validData();
    }

    @Override
    public void validData() {
        User info = new User("BasmalaNaeem", "1234");
        users.put("BasmalaNaeem", info);
        if (users.containsKey(username)) {
            User userInfo = users.get(username);
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
