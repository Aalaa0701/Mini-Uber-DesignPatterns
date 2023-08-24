import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PremiumRidesFile implements FileHandlingForRidesRead, FileHandlingForRidesWrite {
    private static PremiumRidesFile instance = new PremiumRidesFile();
    private PremiumRidesFile(){};

    public static PremiumRidesFile getInstance() {
        return instance;
    }

    @Override
    public void readRides(ArrayList rides) {
        try{
            File premiumRidesText = new File("src/PremiumRides.txt");
            Scanner premiumRidesScan = new Scanner(premiumRidesText);
            while(premiumRidesScan.hasNextLine()){
                String info = premiumRidesScan.nextLine();
                String driverName;
                float driverRate;
                String[] line = info.split(" ");
                driverName = line[0];
                driverRate = Float.parseFloat(line[1]);
                PremiumRide temp = new PremiumRide(driverName,driverRate);
                rides.add(temp);
            }
            premiumRidesScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }

    @Override
    public void write(ArrayList rides) {
        File premiumRidesTxtFile = new File("src/PremiumRides.txt");
        try{
            PrintWriter premiumRidesWriter = new PrintWriter(new FileWriter(premiumRidesTxtFile));
            for(int i =0;i<rides.size();i++){
                PremiumRide temp = (PremiumRide)rides.get(i);
                String line = temp.getDriver().getDriverName()+" "+temp.getDriver().getDriverRate();
                premiumRidesWriter.println(line);
            }

            premiumRidesWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }
}
