import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class BusRidesFile implements FileHandlingForRidesRead, FileHandlingForRidesWrite {
    private static BusRidesFile instance = new BusRidesFile();
    private BusRidesFile(){};

    public static BusRidesFile getInstance() {
        return instance;
    }

    @Override
    public void write(Vector rides) {
        File busRidesTxtFile = new File("src/BusRides.txt");
        try{
            PrintWriter busRidesWriter = new PrintWriter(new FileWriter(busRidesTxtFile));
            for(int i =0;i<rides.size();i++){
                Bus temp = (Bus)rides.get(i);
                String line = temp.getDriverName()+" "+temp.getDriverRate()+" "+temp.getPassengerCount();
                busRidesWriter.println(line);
            }

            busRidesWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }

    @Override
    public void readRides(Vector rides) {
        try{
            File busesText = new File("src/BusRides.txt");
            Scanner busesScan = new Scanner(busesText);
            while(busesScan.hasNextLine()){
                String info = busesScan.nextLine();
                System.out.println(info);
                String driverName;
                float driverRate;
                int passengerCount;
                String[] line = info.split(" ");
                driverName = line[0];
                driverRate = Float.parseFloat(line[1]);
                passengerCount = Integer.parseInt(line[2]);
                Bus temp = new Bus(driverName,driverRate);
                temp.setPassengerCount(passengerCount);
                rides.add(temp);
            }
            busesScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }
}
