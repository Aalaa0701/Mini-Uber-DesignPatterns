import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class WriteInFiles implements FileHandlingForUsersWrite, FileHandlingForSupportWrite{
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
        UserFile.getInstance().Write(Users);
    }
    public void WriteAllRides(ArrayList NormalRides, ArrayList PremiumRides, ArrayList BusRides, ArrayList MotorBikeRides,
                              ArrayList NormalRidesTaken,ArrayList PremiumRidesTaken, ArrayList MotorBikeRidesTaken){
        NormalRidesFile.getInstance().Write(NormalRides);
        PremiumRidesFile.getInstance().Write(PremiumRides);
        BusRidesFile.getInstance().Write(BusRides);
        MotorBikeRidesFile.getInstance().Write(MotorBikeRides);
        NormalRidesTakenFile.getInstance().Write(NormalRidesTaken);
        PremiumRidesTakenFile.getInstance().Write(PremiumRidesTaken);
        MotorBikesTakenFile.getInstance().Write(MotorBikeRidesTaken);
    }

    @Override
    public void Write(Queue Support) {
        SupportTicketsFile.getInstance().Write(Support);
    }
}
