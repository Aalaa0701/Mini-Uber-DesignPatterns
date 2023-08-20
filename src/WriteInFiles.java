import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class WriteInFiles implements FileHandlingForUsersWrite, FileHandlingForSupportWrite{
    UserFile userFile = new UserFile();
    NormalRidesFile normalRidesFile = new NormalRidesFile();
    NormalRidesTakenFile normalRidesTakenFile = new NormalRidesTakenFile();
    PremiumRidesFile premiumRidesFile = new PremiumRidesFile();
    PremiumRidesTakenFile premiumRidesTakenFile = new PremiumRidesTakenFile();
    BusRidesFile busRidesFile = new BusRidesFile();
    MotorBikeRidesFile motorBikeRidesFile = new MotorBikeRidesFile();
    MotorBikesTakenFile motorBikesTakenFile = new MotorBikesTakenFile();
    SupportTicketsFile supportTicketsFile = new SupportTicketsFile();

    public WriteInFiles(HashMap Users){
        this.Write(Users);
    }
    public WriteInFiles(HashMap Users, ArrayList NormalRides,ArrayList PremiumRides,
                        ArrayList BusRides,ArrayList MotorBikeRides, Queue Support,
                        ArrayList NormalRidesTaken,ArrayList PremiumRidesTaken, ArrayList MotorBikeRidesTaken) {
       this.Write(Users);
       this.Write(Support);
       this.WriteAllRides(NormalRides, PremiumRides, BusRides, MotorBikeRides, NormalRidesTaken, PremiumRidesTaken, MotorBikeRidesTaken);
    }

    @Override
    public void Write(HashMap Users) {
        userFile.Write(Users);
    }
    public void WriteAllRides(ArrayList NormalRides, ArrayList PremiumRides, ArrayList BusRides, ArrayList MotorBikeRides,
                              ArrayList NormalRidesTaken,ArrayList PremiumRidesTaken, ArrayList MotorBikeRidesTaken){
        normalRidesFile.Write(NormalRides);
        premiumRidesFile.Write(PremiumRides);
        busRidesFile.Write(BusRides);
        motorBikeRidesFile.Write(MotorBikeRides);
        normalRidesTakenFile.Write(NormalRidesTaken);
        premiumRidesFile.Write(PremiumRidesTaken);
        motorBikeRidesFile.Write(MotorBikeRidesTaken);
    }

    @Override
    public void Write(Queue Support) {
        supportTicketsFile.Write(Support);
    }
}
