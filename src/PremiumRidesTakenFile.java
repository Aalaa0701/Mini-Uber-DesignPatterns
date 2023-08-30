import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class PremiumRidesTakenFile implements FileHandlingForWrite, FileHandlingForRead {
    private static PremiumRidesTakenFile instance;
    private PremiumRidesTakenFile(){};

    public static PremiumRidesTakenFile getInstance() {
        if(instance == null){
            instance = new PremiumRidesTakenFile();
        }
        return instance;
    }

    @Override
    public void write(Vector rides) {
        File premiumRidesTakenTxtFile = new File("src/PremiumRidesTaken.txt");
        try{
            PrintWriter premiumRidesTakenWriter = new PrintWriter(new FileWriter(premiumRidesTakenTxtFile));
            for(int i =0;i<rides.size();i++){
                PremiumRide temp = (PremiumRide)rides.get(i);
                String line = temp.getDriverName()+" "+temp.getRateOfDriver();
                premiumRidesTakenWriter.println(line);
            }

            premiumRidesTakenWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }

    @Override
    public void read(Vector rides) {
        try{
            File premiumRidesTakenText = new File("src/PremiumRidesTaken.txt");
            Scanner premiumRidesTakenScan = new Scanner(premiumRidesTakenText);
            while(premiumRidesTakenScan.hasNextLine()){
                String info = premiumRidesTakenScan.nextLine();
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
            premiumRidesTakenScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }
}
