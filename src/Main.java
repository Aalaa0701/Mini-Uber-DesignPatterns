import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String,User> users = new HashMap<>();
        Queue<SupportTicket> tickets = new LinkedList<>();
        ArrayList<NormalRide> normalRides = new ArrayList<>();
        ArrayList<NormalRide> normalRidesTaken = new ArrayList<>();
        ArrayList<PremiumRide> premiumRides = new ArrayList<>();
        ArrayList<PremiumRide> premiumRidesTaken = new ArrayList<>();
        ArrayList<Motorbike> motorbikes = new ArrayList<>();
        ArrayList<Motorbike> motorbikesTaken = new ArrayList<>();
        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Bus> busesFull = new ArrayList<>();
        //Read From Files
        ReadFromFiles readFromFiles2 = new ReadFromFiles(users,normalRides,premiumRides,buses,motorbikes,
                normalRidesTaken,premiumRidesTaken,busesFull,motorbikesTaken,tickets);
        for(SupportTicket item:tickets){
            System.out.println(item.getCustomerName()+" "+item.getAgentName()+" "+item.getTicketContent());
        }
        for(int i =0;i<normalRides.size();i++){
            System.out.println(normalRides.get(i).getDriverName()+" "+normalRides.get(i).getDriverRate());
        }
        for(int i =0;i<premiumRides.size();i++){
            System.out.println(premiumRides.get(i).getDriverName()+" "+premiumRides.get(i).getDriverRate());
        }
        for(int i =0;i<motorbikes.size();i++){
            System.out.println(motorbikes.get(i).getDriverName()+" "+motorbikes.get(i).getDriverRate());
        }
        for(int i =0;i<buses.size();i++){
            System.out.println(buses.get(i).getDriverName()+" "+buses.get(i).getDriverRate()+" "+buses.get(i).getPassengerCount());
        }
        //Check if reading is successful
        for (HashMap.Entry<String, User> set :
                users.entrySet()) {

            // Printing all elements of a Map
            System.out.println(set.getKey() + " = "
                    + set.getValue().getPassword());
        }
        //add user
        User user1 = new User("person1","12345");
        users.put(user1.getUserName(), user1);
        //add ticket
        //SupportTicket supportTicket = new SupportTicket("anonymous6","Driver6","juytgrfdfghjiljhgfcvbnjytgfbnmnbvcfgj");
       // tickets.add(supportTicket);
        //add normal Ride
        RideFactory rideFactory = new RideFactory();
        //normalRides.add((NormalRide)rideFactory.createRide("Normal","Driver5",1.5f));
        //premiumRides.add((PremiumRide)rideFactory.createRide("Premium","premium",4.5f));
        //motorbikes.add((Motorbike)rideFactory.createRide("Motorbike","bike",3.5f) );
        //buses.add((Bus)rideFactory.createRide("Bus","bus",3.3f) );
        //write into files
        //WriteInFiles writeInFiles1 = new WriteInFiles(tickets);
        //WriteInFiles writeInFiles2 = new WriteInFiles(normalRides);
        WriteInFiles writeInFiles3 = new WriteInFiles(users,normalRides,premiumRides,buses,motorbikes,tickets,
                normalRidesTaken,premiumRidesTaken,motorbikesTaken,busesFull);

    }
}