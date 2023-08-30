
import java.util.*;

import java.util.Map;


public class Main {
    public static void main(String[] args) {
        //variables
        boolean loginOrRegistrationSuccess = false;
        boolean requestRideSuccess = false;
        double fare = 0;
        Scanner input = new Scanner(System.in);
        String userLogged = "";


        //data structures
        Map<String, User> users = new HashMap<>();
        Vector<RideTicket> rideTickets = new Vector<>();
        Vector<PaymentTicket> paymentTickets = new Vector<>();
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

        // manage Unavailable Rides
        Timer timer = new Timer();
        RideCompleted rideCompleted = new RideCompleted(normalRidesTaken,premiumRidesTaken,motorbikesTaken,busesFull,buses);
        timer.schedule(rideCompleted, 1000, 200000);

        //system flow
       while (true){
           System.out.println("press 1 for Register or 2 for login or 3 if you forgot your password or your account is hacked " +
                   "or 4 if you are an agent");
           int choice = input.nextInt();
           if(choice == 1){
               Register register = new Register(users);
               register.Data();
               if(register.registrationSuccess){
                   loginOrRegistrationSuccess = true;
                   userLogged = register.getUserInfo().getUserName();
               }
               break;
           }
           else if(choice == 2){
                Login login = new Login(users);
                login.Data();
               loginOrRegistrationSuccess = true;
               userLogged = login.getUsername();
               break;
           }
           else if(choice == 3){
               AccountTicket accountTicket = new AccountTicket(users);
               accountTicket.request();
           }
           else if(choice == 4){
               do {
                   String username, password;
                   Scanner newScanner = new Scanner(System.in);
                   System.out.print("Username: \n");
                   username = newScanner.nextLine();
                   System.out.print("Password: \n");
                   password = newScanner.nextLine();
                   if(username .equals("agent") && password.equals("myPassword")){
                       Agent agent = new Agent("agent",users,rideTickets,paymentTickets);
                       agent.viewTickets();
                       agent.acceptTicket();
                       agent.notifyObserver();
                       agent.closeTicket();
                       break;
                   }
                   else{
                       System.out.println("Not a valid username or password!");
                   }

               }while(true);

           }


       }
       if(loginOrRegistrationSuccess){
           users.get(userLogged).update();
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
               do {
                   System.out.println("press 1 for ride ticket or 2 for payment ticket");
                   int choiceForTicket = input.nextInt();
                   if(choiceForTicket == 1){
                       RideTicket rideTicket = new RideTicket("Ride",rideTickets);
                       rideTicket.setTicketMaker(userLogged);
                       rideTicket.request();
                       break;
                   }
                   else if(choiceForTicket == 2){
                       PaymentTicket paymentTicket = new PaymentTicket("Payment",paymentTickets);
                       paymentTicket.setTicketMaker(userLogged);
                       paymentTicket.request();
                       break;
                   }
                   else{
                       System.out.println("please enter a valid choice");
                   }
               }while(true);
           }
       }
       if(requestRideSuccess){
           Payment payment = new Payment();
           payment.handlePayment(fare);

       }

        WriteInFiles writeInFiles = new WriteInFiles(users,normalRides,premiumRides,buses,motorbikes,
                rideTickets,paymentTickets,normalRidesTaken,premiumRidesTaken,motorbikesTaken,busesFull);


        System.exit(0);


    }
}
