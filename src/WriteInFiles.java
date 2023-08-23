import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class WriteInFiles implements FileHandlingForUsersWrite, FileHandlingForSupportWrite{
    public WriteInFiles(HashMap Users){
        this.write(Users);
    }
    public WriteInFiles(Queue Support){
        this.write(Support);
    }
    public WriteInFiles(HashMap Users, ArrayList NormalRides,ArrayList PremiumRides,
                        ArrayList BusRides,ArrayList MotorBikeRides, Queue Support,
                        ArrayList NormalRidesTaken,ArrayList PremiumRidesTaken, ArrayList MotorBikeRidesTaken) {
       this.write(Users);
       this.write(Support);
       this.WriteAllRides(NormalRides, PremiumRides, BusRides, MotorBikeRides, NormalRidesTaken, PremiumRidesTaken, MotorBikeRidesTaken);
    }

    @Override
    public void write(HashMap Users) {
        UserFile.getInstance().write(Users);
    }
    public void WriteAllRides(ArrayList NormalRides, ArrayList PremiumRides, ArrayList BusRides, ArrayList MotorBikeRides,
                              ArrayList NormalRidesTaken,ArrayList PremiumRidesTaken, ArrayList MotorBikeRidesTaken){
        NormalRidesFile.getInstance().write(NormalRides);
        PremiumRidesFile.getInstance().write(PremiumRides);
        BusRidesFile.getInstance().write(BusRides);
        MotorBikeRidesFile.getInstance().write(MotorBikeRides);
        NormalRidesTakenFile.getInstance().write(NormalRidesTaken);
        PremiumRidesTakenFile.getInstance().write(PremiumRidesTaken);
        MotorBikesTakenFile.getInstance().write(MotorBikeRidesTaken);
    }

    @Override
    public void write(Queue Support) {
        SupportTicketsFile.getInstance().write(Support);
    }
}
