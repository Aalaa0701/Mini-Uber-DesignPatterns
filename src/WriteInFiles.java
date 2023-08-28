import java.util.*;

public class WriteInFiles implements FileHandlingForUsersWrite, FileHandlingForSupportWrite{


    public WriteInFiles(Map users, Vector normalRides,Vector premiumRides,
                        Vector busRides,Vector motorBikeRides, Queue support,
                        Vector normalRidesTaken,Vector premiumRidesTaken, Vector motorBikeRidesTaken,Vector busesFull) {
       this.write(users);
       this.write(support);
       this.WriteAllRides(normalRides, premiumRides, busRides, motorBikeRides, normalRidesTaken, premiumRidesTaken,
               motorBikeRidesTaken,busesFull);
    }

    @Override
    public void write(Map Users) {
        UserFile.getInstance().write(Users);
    }
    public void WriteAllRides(Vector normalRides, Vector premiumRides, Vector busRides, Vector motorBikeRides,
                              Vector NormalRidesTaken, Vector PremiumRidesTaken,
                              Vector MotorBikeRidesTaken, Vector busesFull){
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
