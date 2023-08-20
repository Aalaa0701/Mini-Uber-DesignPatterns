import java.util.ArrayList;

public class NormalRidesTakenFile implements FileHandlingForRidesWrite {
    private static NormalRidesTakenFile instance;
    private NormalRidesTakenFile(){};

    public static NormalRidesTakenFile getInstance() {
        if(instance == null){
            instance = new NormalRidesTakenFile();
        }
        return instance;
    }

    @Override
    public void Write(ArrayList Rides) {

    }
}
