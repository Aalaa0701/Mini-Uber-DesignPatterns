import java.util.HashMap;
import java.util.Scanner;

public class Register implements InputData, Validation{

    private User userInfo;
    private String confirmPassword;
    public Register() {
        Login.users = new HashMap<>();
        userInfo = new User("", "");
    }


    @Override
    public void Data() {
        System.out.println(" Enter your username ");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();

        System.out.print(" Enter your password ");
        String password = input.nextLine();

        System.out.print(" Enter Confirm password ");
        confirmPassword =input.nextLine();

        userInfo = new User(username, password);

        validData();
    }

    @Override
    public void validData() {
        String username = userInfo.getUsername();
        String password = userInfo.getPassword();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Please try again.");
        } else if (Login.users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            Login.users.put(username, userInfo);
            System.out.println("Registration successful!");
        }
    }
}
