import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class ReadFromFiles implements FileHandlingForUsersRead, FileHandlingForSupportRead {


    public ReadFromFiles(HashMap Users, ArrayList NormalRides,ArrayList PremiumRides,
                         ArrayList BusRides,ArrayList MotorBikeRides,ArrayList normalRidesTaken,
                         ArrayList premiumRidesTaken, ArrayList busRidesFull, ArrayList motorBikesTaken,Queue Support) {
        this.readUsers(Users);
        this.readSupport(Support);
        this.ReadAllRides(NormalRides, PremiumRides, BusRides, MotorBikeRides,
                normalRidesTaken,premiumRidesTaken,busRidesFull,motorBikesTaken);
    }

    @Override
    public void readUsers(HashMap Users) {
        UserFile.getInstance().readUsers(Users);
    }

   public void ReadAllRides(ArrayList normalRides,ArrayList premiumRides,ArrayList busRides,ArrayList motorBikeRides,
                            ArrayList normalRidesTaken, ArrayList premiumRidesTaken, ArrayList busRidesFull,
                            ArrayList motorBikesTaken){
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
