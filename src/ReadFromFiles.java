import java.util.*;

public class ReadFromFiles implements FileHandlingForUsersRead, FileHandlingForSupportRead {


    public ReadFromFiles(Map<String, User> Users, Vector normalRides, Vector premiumRides, Vector busRides, Vector motorBikeRides,
                         Vector normalRidesTaken, Vector premiumRidesTaken, Vector busRidesFull,
                         Vector motorBikesTaken, Queue Support) {
        this.readUsers(Users);
        this.readSupport(Support);
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
        NormalRidesFile.getInstance().readRides(normalRides);
        PremiumRidesFile.getInstance().readRides(premiumRides);
        BusRidesFile.getInstance().readRides(busRides);
        MotorBikeRidesFile.getInstance().readRides(motorBikeRides);
        NormalRidesTakenFile.getInstance().readRides(normalRidesTaken);
        PremiumRidesTakenFile.getInstance().readRides(premiumRidesTaken);
        BusRidesFullFile.getInstance().readRides(busRidesFull);
        MotorBikesTakenFile.getInstance().readRides(motorBikesTaken);

   }

    @Override
    public void readSupport(Queue Support) {
        SupportTicketsFile.getInstance().readSupport(Support);
    }
}
