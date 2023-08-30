import java.util.*;

public class ReadFromFiles implements FileHandlingForUsersRead {


    public ReadFromFiles(Map<String, User> Users, Vector normalRides, Vector premiumRides, Vector busRides, Vector motorBikeRides,
                         Vector normalRidesTaken, Vector premiumRidesTaken, Vector busRidesFull,
                         Vector motorBikesTaken, Vector rideTickets, Vector paymentTickets) {
        this.readUsers(Users);
        this.readSupport(rideTickets, paymentTickets);
        this.ReadAllRides(normalRides, premiumRides, busRides, motorBikeRides,
                normalRidesTaken,premiumRidesTaken,busRidesFull,motorBikesTaken);
    }

    @Override
    public void readUsers(Map<String, User> Users) {
        UserFile.getInstance().readUsers(Users);
    }

   public void ReadAllRides(Vector normalRides, Vector premiumRides, Vector busRides, Vector motorBikeRides,
                            Vector normalRidesTaken, Vector premiumRidesTaken, Vector busRidesFull,
                            Vector motorBikesTaken){
        NormalRidesFile.getInstance().read(normalRides);
        PremiumRidesFile.getInstance().read(premiumRides);
        BusRidesFile.getInstance().read(busRides);
        MotorBikeRidesFile.getInstance().read(motorBikeRides);
        NormalRidesTakenFile.getInstance().read(normalRidesTaken);
        PremiumRidesTakenFile.getInstance().read(premiumRidesTaken);
        BusRidesFullFile.getInstance().read(busRidesFull);
        MotorBikesTakenFile.getInstance().read(motorBikesTaken);

   }


    public void readSupport(Vector rideTickets, Vector paymentTickets) {
        RideTicketsFile.getInstance().read(rideTickets);
        PaymentTicketsFile.getInstance().read(paymentTickets);

    }
}
