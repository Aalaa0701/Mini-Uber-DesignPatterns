
import java.util.*;

import java.util.Map;


public class Main {
    public static void main(String[] args) {
        //variables
        boolean loginOrRegistrationSuccess = false;
        boolean requestRideSuccess = false;
        double fare = 0;
        Scanner input = new Scanner(System.in);

        //data structures
        Map<String, User> users = new HashMap<>();
        Queue<RideTicket> rideTickets = new LinkedList<>();
        Queue<PaymentTicket> paymentTickets = new LinkedList<>();
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
                normalRidesTaken,premiumRidesTaken,busesFull,motorbikesTaken,rideTickets,paymentTickets);

        //system flow
       while (true){
           System.out.println("press 1 for Register or 2 for login or 3 if you forgot your password or your account is hacked");
           int choice = input.nextInt();
           if(choice == 1){
               Register register = new Register(users);
               register.Data();
               if(register.registrationSuccess){
                   loginOrRegistrationSuccess = true;
               }
               break;
           }
           else if(choice == 2){
                Login login = new Login(users);
                login.Data();
               loginOrRegistrationSuccess = true;
               break;
           }
           else if(choice == 3){
               AccountTicket accountTicket = new AccountTicket(users);
               accountTicket.request();
           }


       }
       if(loginOrRegistrationSuccess){
           System.out.println("Press 1 for requesting a ride or 2 for opening a support ticket");
           int choice = input.nextInt();
           if(choice == 1){
               DistanceCalculator distanceCalculator = new DistanceCalculator();
               Motorbike motorbikeObj=new Motorbike(motorbikes,motorbikesTaken);
               NormalRide normalRideObj =new NormalRide(normalRides,normalRidesTaken);
               PremiumRide premiumRideObj=new PremiumRide(premiumRides,premiumRidesTaken);
               Bus busObj = new Bus(buses,busesFull);

               int userChoice;
               do {
                   System.out.println("Choose 1 for Normal ride or 2 for Premium ride or 3 for motor bike ride or 4 for bus ride :");
                   userChoice = input.nextInt();

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
           else if(choice == 2){
               System.out.println("press 1 for ride ticket or 2 for payment ticket");
               int choiceForTicket = input.nextInt();
               RideTicket rideTicket = new RideTicket("Ride",rideTickets);
               PaymentTicket paymentTicket = new PaymentTicket("Payment",paymentTickets);
               if(choiceForTicket == 1){
                   rideTicket.request();
               }
               else if(choiceForTicket == 2){
                   paymentTicket.request();
               }
           }
       }
       if(requestRideSuccess){
           Payment payment = new Payment();
           payment.handlePayment(fare);

       }

        WriteInFiles writeInFiles = new WriteInFiles(users,normalRides,premiumRides,buses,motorbikes,
                rideTickets,paymentTickets,normalRidesTaken,premiumRidesTaken,motorbikesTaken,busesFull);





    }
}
