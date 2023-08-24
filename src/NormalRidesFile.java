import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
        try{
            File normalRidesText = new File("src/NormalRides.txt");
            Scanner normalRidesScan = new Scanner(normalRidesText);
            while(normalRidesScan.hasNextLine()){
                String info = normalRidesScan.nextLine();
                String driverName;
                float driverRate;
                String[] line = normalRidesScan.nextLine().split(" ");
                driverName = line[0];
                driverRate = Float.parseFloat(info);
                System.out.println(driverName+" "+driverRate);



            }
            normalRidesScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }


    }
}
