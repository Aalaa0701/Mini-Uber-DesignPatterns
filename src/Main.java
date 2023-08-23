import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        HashMap<String,User> Users = new HashMap<>();
        Queue<SupportTicket> tickets = new LinkedList<>();
        //Read From Files
        ReadFromFiles readFromFiles = new ReadFromFiles(Users);
        ReadFromFiles readFromFiles1 = new ReadFromFiles(tickets);
        for(SupportTicket item:tickets){
            System.out.println(item.getCustomerName()+" "+item.getAgentName()+" "+item.getTicketContent());
        }
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
        //add ticket
        SupportTicket supportTicket = new SupportTicket("anonymous6","Driver6","juytgrfdfghjiljhgfcvbnjytgfbnmnbvcfgj");
        tickets.add(supportTicket);
        //write into files
        WriteInFiles writeInFiles = new WriteInFiles(Users);
        WriteInFiles writeInFiles1 = new WriteInFiles(tickets);

    }
}