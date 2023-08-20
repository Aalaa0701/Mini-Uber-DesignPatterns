import java.util.ArrayList;

public class MotorBikesTakenFile implements FileHandlingForRidesWrite{
    private static MotorBikesTakenFile instance;
    private MotorBikesTakenFile(){};

    public static MotorBikesTakenFile getInstance() {
        if(instance == null){
            instance = new MotorBikesTakenFile();
        }
        return instance;
    }

    @Override
    public void Write(ArrayList Rides) {

    }

}
