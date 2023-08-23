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
        //add user
        User user1 = new User("person1","12345");
        Users.put(user1.getUserName(), user1);
        //write into files
        WriteInFiles writeInFiles = new WriteInFiles(Users);



    }
}