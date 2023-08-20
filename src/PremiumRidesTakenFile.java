import java.util.ArrayList;

public class PremiumRidesTakenFile implements FileHandlingForRidesWrite{
    private static PremiumRidesTakenFile instance;
    private PremiumRidesTakenFile(){};

    public static PremiumRidesTakenFile getInstance() {
        if(instance == null){
            instance = new PremiumRidesTakenFile();
        }
        return instance;
    }

    @Override
    public void write(ArrayList Rides) {

    }
}
