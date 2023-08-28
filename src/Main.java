
import java.util.*;

import java.util.Map;


public class Main {
    public static void main(String[] args) {
        //variables
        boolean loginOrRegistrationSuccess = false;

        //data structures
        Map<String, User> users = new HashMap<>();
        Queue<SupportTicket> tickets = new LinkedList<>();
        Vector<NormalRide> normalRides = new Vector<>();
        Vector<NormalRide> normalRidesTaken = new Vector<>();
        Vector<PremiumRide> premiumRides = new Vector<>();
        Vector<PremiumRide> premiumRidesTaken = new Vector<>();
        Vector<Motorbike> motorbikes = new Vector<>();
        Vector<Motorbike> motorbikesTaken = new Vector<>();
        Vector<Bus> buses = new Vector<>();
        Vector<Bus> busesFull = new Vector<>();

        //Read From Files
        ReadFromFiles readFromFiles2 = new ReadFromFiles(users,normalRides,premiumRides,buses,motorbikes,
                normalRidesTaken,premiumRidesTaken,busesFull,motorbikesTaken,tickets);

        //system flow
       while (true){
           System.out.println("press 1 for Register or 2 for login");
           Scanner input = new Scanner(System.in);
           int choice = input.nextInt();
           if(choice == 1){
               Register register = new Register(users);
               register.Data();
               loginOrRegistrationSuccess = true;
               break;
           }
           else if(choice == 2){
                Login login = new Login(users);
                login.Data();
               loginOrRegistrationSuccess = true;
               break;
           }

       }
       if(loginOrRegistrationSuccess){

       }


    WriteInFiles writeInFiles = new WriteInFiles(users);




    }
}
