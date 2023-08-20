import java.util.ArrayList;

public class NormalRidesFile implements FileHandlingForRidesRead, FileHandlingForRidesWrite {
    private static NormalRidesFile instance = new NormalRidesFile();
    private NormalRidesFile(){};

    public static NormalRidesFile getInstance() {
        return instance;
    }

    @Override
    public void write(ArrayList Rides) {

    }

    @Override
    public void readRides(ArrayList Rides) {

    }
}
