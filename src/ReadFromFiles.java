import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class ReadFromFiles implements FileHandlingForUsersRead, FileHandlingForSupportRead {
    UserFile userFile = new UserFile();
    NormalRidesFile normalRidesFile = new NormalRidesFile();
    PremiumRidesFile premiumRidesFile = new PremiumRidesFile();
    BusRidesFile busRidesFile = new BusRidesFile();
    MotorBikeRidesFile motorBikeRidesFile = new MotorBikeRidesFile();
    SupportTicketsFile supportTicketsFile = new SupportTicketsFile();

    public ReadFromFiles(HashMap Users){
        this.readUsers(Users);

    }
    public ReadFromFiles(HashMap Users, ArrayList NormalRides,ArrayList PremiumRides,
                         ArrayList BusRides,ArrayList MotorBikeRides, Queue Support) {
        this.readUsers(Users);
        this.ReadSupport(Support);
        this.ReadAllRides(NormalRides, PremiumRides, BusRides, MotorBikeRides);
    }

    @Override
    public void readUsers(HashMap Users) {
        userFile.readUsers(Users);
    }

   public void ReadAllRides(ArrayList NormalRides,ArrayList PremiumRides,ArrayList BusRides,ArrayList MotorBikeRides){
        normalRidesFile.ReadRides(NormalRides);
        premiumRidesFile.ReadRides(PremiumRides);
        busRidesFile.ReadRides(BusRides);
        motorBikeRidesFile.ReadRides(MotorBikeRides);
   }

    @Override
    public void ReadSupport(Queue Support) {
        supportTicketsFile.ReadSupport(Support);
    }
}
