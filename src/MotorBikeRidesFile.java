import java.util.ArrayList;

public class MotorBikeRidesFile implements FileHandlingForRidesRead, FileHandlingForRidesWrite {
    private static MotorBikeRidesFile instance = new MotorBikeRidesFile();
    private MotorBikeRidesFile(){};

    public static MotorBikeRidesFile getInstance() {
        return instance;
    }

    @Override
    public void readRides(ArrayList Rides) {

    }

    @Override
    public void write(ArrayList Rides) {

    }
}
