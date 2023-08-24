import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class WriteInFiles implements FileHandlingForUsersWrite, FileHandlingForSupportWrite{

    public WriteInFiles(HashMap Users, ArrayList NormalRides,ArrayList PremiumRides,
                        ArrayList BusRides,ArrayList MotorBikeRides, Queue Support,
                        ArrayList NormalRidesTaken,ArrayList PremiumRidesTaken, ArrayList MotorBikeRidesTaken,ArrayList busesFull) {
       this.write(Users);
       this.write(Support);
       this.WriteAllRides(NormalRides, PremiumRides, BusRides, MotorBikeRides, NormalRidesTaken, PremiumRidesTaken, MotorBikeRidesTaken,busesFull);
    }

    @Override
    public void write(HashMap Users) {
        UserFile.getInstance().write(Users);
    }
    public void WriteAllRides(ArrayList normalRides, ArrayList premiumRides, ArrayList busRides, ArrayList motorBikeRides,
                              ArrayList NormalRidesTaken,ArrayList PremiumRidesTaken,
                              ArrayList MotorBikeRidesTaken,ArrayList busesFull){
        NormalRidesFile.getInstance().write(normalRides);
        PremiumRidesFile.getInstance().write(premiumRides);
        BusRidesFile.getInstance().write(busRides);
        MotorBikeRidesFile.getInstance().write(motorBikeRides);
        NormalRidesTakenFile.getInstance().write(NormalRidesTaken);
        PremiumRidesTakenFile.getInstance().write(PremiumRidesTaken);
        MotorBikesTakenFile.getInstance().write(MotorBikeRidesTaken);
        BusRidesFullFile.getInstance().write(busesFull);
    }

    @Override
    public void write(Queue Support) {
        SupportTicketsFile.getInstance().write(Support);
    }
}
