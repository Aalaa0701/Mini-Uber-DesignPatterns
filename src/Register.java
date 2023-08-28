import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Register implements InputData, Validation{

    private User userInfo;
    private String confirmPassword;
    boolean registrationSuccess = false;

    Map<String,User> userMap;
    public Register(Map userMap) {
        userInfo = new User("", "");
        this.userMap = userMap;
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
        String username = userInfo.getUserName();
        String password = userInfo.getPassword();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Please try again.");
        } else if (userMap.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            userMap.put(username,userInfo);
            System.out.println("Registration successful!");
            registrationSuccess = true;
        }
    }

    public boolean isRegistrationSuccess() {
        return registrationSuccess;
    }
}
