import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MotorBikesTakenFile implements FileHandlingForRidesWrite, FileHandlingForRidesRead{
    private static MotorBikesTakenFile instance;
    private MotorBikesTakenFile(){};

    public static MotorBikesTakenFile getInstance() {
        if(instance == null){
            instance = new MotorBikesTakenFile();
        }
        return instance;
    }

    @Override
    public void write(ArrayList rides) {
        File bikeRidesTakenTxtFile = new File("src/MotorBikeRidesTaken.txt");
        try{
            PrintWriter bikeRidesTakenWriter = new PrintWriter(new FileWriter(bikeRidesTakenTxtFile));
            for(int i =0;i<rides.size();i++){
                Motorbike temp = (Motorbike)rides.get(i);
                String line = temp.getDriver().getDriverName()+" "+temp.getDriver().getDriverRate();
                bikeRidesTakenWriter.println(line);
            }

            bikeRidesTakenWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }

    @Override
    public void readRides(ArrayList rides) {
        try{
            File motorBikesTakenText = new File("src/MotorBikeRidesTaken.txt");
            Scanner motorBikesTakenScan = new Scanner(motorBikesTakenText);
            while(motorBikesTakenScan.hasNextLine()){
                String info = motorBikesTakenScan.nextLine();
                String driverName;
                float driverRate;
                String[] line = info.split(" ");
                driverName = line[0];
                driverRate = Float.parseFloat(line[1]);
                Motorbike temp = new Motorbike(driverName,driverRate);
                rides.add(temp);
            }
            motorBikesTakenScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }
}
