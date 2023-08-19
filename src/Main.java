import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,User> Users = new HashMap<>();
        //Read From Files
        ReadFromFiles readFromFiles = new ReadFromFiles(Users);
        //Check if reading is successful
        for (HashMap.Entry<String, User> set :
                Users.entrySet()) {

            // Printing all elements of a Map
            System.out.println(set.getKey() + " = "
                    + set.getValue().getPassword());
        }
        
    }
}