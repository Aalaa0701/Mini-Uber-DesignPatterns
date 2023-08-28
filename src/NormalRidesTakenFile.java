import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class NormalRidesTakenFile implements FileHandlingForRidesWrite, FileHandlingForRidesRead {
    private static NormalRidesTakenFile instance;
    private NormalRidesTakenFile(){};

    public static NormalRidesTakenFile getInstance() {
        if(instance == null){
            instance = new NormalRidesTakenFile();
        }
        return instance;
    }

    @Override
    public void write(Vector rides) {
        File normalRidesTakenTxtFile = new File("src/NormalRidesTaken.txt");
        try{
            PrintWriter normalRidesTakenWriter = new PrintWriter(new FileWriter(normalRidesTakenTxtFile));
            for(int i =0;i<rides.size();i++){
                NormalRide temp = (NormalRide)rides.get(i);
                //String line = temp.getDriver().getDriverName()+" "+temp.getDriver().getDriverRate();
                String line = temp.getDriverName()+" "+temp.getRateOfDriver();
                normalRidesTakenWriter.println(line);
            }

            normalRidesTakenWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }

    @Override
    public void readRides(Vector rides) {
        try{
            File normalRidesTakenText = new File("src/NormalRidesTaken.txt");
            Scanner normalRidesTakenScan = new Scanner(normalRidesTakenText);
            while(normalRidesTakenScan.hasNextLine()){
                String info = normalRidesTakenScan.nextLine();
                String driverName;
                float driverRate;
                String[] line = info.split(" ");
                if(line.length>1){
                    driverName = line[0];
                    driverRate = Float.parseFloat(line[1]);
                    NormalRide temp = new NormalRide(driverName,driverRate);
                    rides.add(temp);
                }

            }
            normalRidesTakenScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }
}
