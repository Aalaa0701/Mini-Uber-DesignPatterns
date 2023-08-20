import java.util.ArrayList;

public class BusRidesFile implements FileHandlingForRidesRead, FileHandlingForRidesWrite {
    private static BusRidesFile instance = new BusRidesFile();
    private BusRidesFile(){};

    public static BusRidesFile getInstance() {
        return instance;
    }

    @Override
    public void Write(ArrayList Rides) {

    }

    @Override
    public void ReadRides(ArrayList Rides) {

    }
}
