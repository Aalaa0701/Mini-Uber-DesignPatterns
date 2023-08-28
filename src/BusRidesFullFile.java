import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class BusRidesFullFile implements FileHandlingForRidesRead, FileHandlingForRidesWrite{
    private static BusRidesFullFile instance;
    private BusRidesFullFile(){};

    public static BusRidesFullFile getInstance() {
        if(instance == null){
            instance = new BusRidesFullFile();
        }
        return instance;
    }

    @Override
    public void readRides(Vector rides) {
        try{
            File busesFullText = new File("src/BusRidesTaken.txt");
            Scanner busesFullScan = new Scanner(busesFullText);
            while(busesFullScan.hasNextLine()){
                String info = busesFullScan.nextLine();
                String driverName;
                float driverRate;
                int passengerCount;
                String[] line = info.split(" ");
                if(line.length>1){
                    driverName = line[0];
                    driverRate = Float.parseFloat(line[1]);
                    passengerCount = Integer.parseInt(line[2]);
                    Bus temp = new Bus(driverName,driverRate);
                    temp.setPassengerCount(passengerCount);
                    rides.add(temp);
                }

            }
            busesFullScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }

    @Override
    public void write(Vector rides) {
        File busRidesFullTxtFile = new File("src/BusRidesTaken.txt");
        try{
            PrintWriter busRidesFullWriter = new PrintWriter(new FileWriter(busRidesFullTxtFile));
            for(int i =0;i<rides.size();i++){
                Bus temp = (Bus)rides.get(i);
                String line = temp.getDriverName()+" "+temp.getRateOfDriver()+" "+temp.getPassengerCount();
                busRidesFullWriter.println(line);
            }

            busRidesFullWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }
}
