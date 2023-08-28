
import java.util.*;

import java.util.Map;


public class Main {
    public static void main(String[] args) {
        //variables
        boolean loginOrRegistrationSuccess = false;
        boolean requestRideSuccess = false;
        double fare = 0;

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

           DistanceCalculator distanceCalculator = new DistanceCalculator();
           Motorbike motorbikeObj=new Motorbike(motorbikes,motorbikesTaken);
           NormalRide normalRideObj =new NormalRide(normalRides,normalRidesTaken);
           PremiumRide premiumRideObj=new PremiumRide(premiumRides,premiumRidesTaken);
           Bus busObj = new Bus(buses,busesFull);
           Scanner scanner = new Scanner(System.in);
           int userChoice;
           do {
               System.out.println("Choose 1 for Normal ride or 2 for Premium ride or 3 for motor bike ride or 4 for bus ride :");
               userChoice = scanner.nextInt();

               if (userChoice == 1) {
                   normalRideObj.requestRide();
                   normalRideObj.chooseLocation();
                   distanceCalculator.setCurrentLocation(normalRideObj.getCurrentLocation());
                   distanceCalculator.setDestination(normalRideObj.getDestination());
                   requestRideSuccess = true;
                   fare = normalRideObj.calculateFare(distanceCalculator.getDistance());

               } else if (userChoice == 2) {
                   premiumRideObj.requestRide();
                   premiumRideObj.chooseLocation();
                   distanceCalculator.setCurrentLocation(premiumRideObj.getCurrentLocation());
                   distanceCalculator.setDestination(premiumRideObj.getDestination());
                   requestRideSuccess = true;
                   fare = premiumRideObj.calculateFare(distanceCalculator.getDistance());


               } else if (userChoice == 3) {
                   motorbikeObj.requestRide();
                   motorbikeObj.chooseLocation();
                   distanceCalculator.setCurrentLocation(motorbikeObj.getCurrentLocation());
                   distanceCalculator.setDestination(motorbikeObj.getDestination());
                   requestRideSuccess = true;
                   fare = motorbikeObj.calculateFare(distanceCalculator.getDistance());

               } else if (userChoice == 4) {
                   busObj.requestRide();
                   busObj.chooseLocation();
                   distanceCalculator.setCurrentLocation(busObj.getCurrentLocation());
                   distanceCalculator.setDestination(busObj.getDestination());
                   requestRideSuccess = true;
                   fare = busObj.calculateFare(distanceCalculator.getDistance());

               } else {
                   System.out.println("Invalid choice please try again!");
               }
           }while (userChoice > 4 || userChoice <1);


       }
       if(requestRideSuccess){
           Payment payment = new Payment();
           payment.handlePayment(fare);

       }

        WriteInFiles writeInFiles = new WriteInFiles(users,normalRides,premiumRides,buses,motorbikes,
                tickets,normalRidesTaken,premiumRidesTaken,motorbikesTaken,busesFull);





    }
}
