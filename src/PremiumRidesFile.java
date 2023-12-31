import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class PremiumRidesFile implements FileHandlingForRead, FileHandlingForWrite {
    private static PremiumRidesFile instance = new PremiumRidesFile();
    private PremiumRidesFile(){};

    public static PremiumRidesFile getInstance() {
        return instance;
    }

    @Override
    public void read(Vector rides) {
        try{
            File premiumRidesText = new File("src/PremiumRides.txt");
            Scanner premiumRidesScan = new Scanner(premiumRidesText);
            while(premiumRidesScan.hasNextLine()){
                String info = premiumRidesScan.nextLine();
                String driverName;
                float driverRate;
                String[] line = info.split(" ");
                if(line.length>1){
                    driverName = line[0];
                    driverRate = Float.parseFloat(line[1]);
                    PremiumRide temp = new PremiumRide(driverName,driverRate);
                    rides.add(temp);
                }

            }
            premiumRidesScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }

    @Override
    public void write(Vector rides) {
        File premiumRidesTxtFile = new File("src/PremiumRides.txt");
        try{
            PrintWriter premiumRidesWriter = new PrintWriter(new FileWriter(premiumRidesTxtFile));
            for(int i =0;i<rides.size();i++){
                PremiumRide temp = (PremiumRide)rides.get(i);
                String line = temp.getDriverName()+" "+temp.getRateOfDriver();
                premiumRidesWriter.println(line);
            }

            premiumRidesWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }
}
