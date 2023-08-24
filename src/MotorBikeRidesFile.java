import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MotorBikeRidesFile implements FileHandlingForRidesRead, FileHandlingForRidesWrite {
    private static MotorBikeRidesFile instance = new MotorBikeRidesFile();
    private MotorBikeRidesFile(){};

    public static MotorBikeRidesFile getInstance() {
        return instance;
    }

    @Override
    public void readRides(ArrayList rides) {
        try{
            File motorBikesText = new File("src/MotorBikeRides.txt");
            Scanner motorBikesScan = new Scanner(motorBikesText);
            while(motorBikesScan.hasNextLine()){
                String info = motorBikesScan.nextLine();
                String driverName;
                float driverRate;
                String[] line = info.split(" ");
                driverName = line[0];
                driverRate = Float.parseFloat(line[1]);
                Motorbike temp = new Motorbike(driverName,driverRate);
                rides.add(temp);
            }
            motorBikesScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }

    @Override
    public void write(ArrayList rides) {
        File bikeRidesTxtFile = new File("src/MotorBikeRides.txt");
        try{
            PrintWriter bikeRidesWriter = new PrintWriter(new FileWriter(bikeRidesTxtFile));
            for(int i =0;i<rides.size();i++){
                Motorbike temp = (Motorbike)rides.get(i);
                String line = temp.getDriverName()+" "+temp.getDriverRate();
                bikeRidesWriter.println(line);
            }

            bikeRidesWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }
}
