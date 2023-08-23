import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class ReadFromFiles implements FileHandlingForUsersRead, FileHandlingForSupportRead {

    public ReadFromFiles(HashMap Users){
        this.readUsers(Users);

    }
    public ReadFromFiles(Queue support){
        this.readSupport(support);
    }
    public ReadFromFiles(HashMap Users, ArrayList NormalRides,ArrayList PremiumRides,
                         ArrayList BusRides,ArrayList MotorBikeRides, Queue Support) {
        this.readUsers(Users);
        this.readSupport(Support);
        this.ReadAllRides(NormalRides, PremiumRides, BusRides, MotorBikeRides);
    }

    @Override
    public void readUsers(HashMap Users) {
        UserFile.getInstance().readUsers(Users);
    }

   public void ReadAllRides(ArrayList NormalRides,ArrayList PremiumRides,ArrayList BusRides,ArrayList MotorBikeRides){
       NormalRidesFile.getInstance().readRides(NormalRides);
        PremiumRidesFile.getInstance().readRides(PremiumRides);
        BusRidesFile.getInstance().readRides(BusRides);
        MotorBikeRidesFile.getInstance().readRides(MotorBikeRides);
   }

    @Override
    public void readSupport(Queue Support) {
        SupportTicketsFile.getInstance().readSupport(Support);
    }
}
