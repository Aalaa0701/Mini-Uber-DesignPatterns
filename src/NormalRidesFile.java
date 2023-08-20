import java.util.ArrayList;

public class NormalRidesFile implements FileHandlingForRidesRead, FileHandlingForRidesWrite {
    private static NormalRidesFile instance = new NormalRidesFile();
    private NormalRidesFile(){};

    public static NormalRidesFile getInstance() {
        return instance;
    }

    @Override
    public void Write(ArrayList Rides) {

    }

    @Override
    public void ReadRides(ArrayList Rides) {

    }
}
