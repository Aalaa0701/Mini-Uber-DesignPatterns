import java.util.ArrayList;

public class PremiumRidesFile implements FileHandlingForRidesRead, FileHandlingForRidesWrite {
    private static PremiumRidesFile instance = new PremiumRidesFile();
    private PremiumRidesFile(){};

    public static PremiumRidesFile getInstance() {
        return instance;
    }

    @Override
    public void readRides(ArrayList Rides) {

    }

    @Override
    public void write(ArrayList Rides) {

    }
}
