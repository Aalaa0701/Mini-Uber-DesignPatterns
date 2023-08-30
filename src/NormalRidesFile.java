import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class NormalRidesFile implements FileHandlingForRead, FileHandlingForWrite {
    private static NormalRidesFile instance = new NormalRidesFile();
    private NormalRidesFile(){};

    public static NormalRidesFile getInstance() {
        return instance;
    }

    @Override
    public void write(Vector rides) {
        File normalRidesTxtFile = new File("src/NormalRides.txt");
        try{
            PrintWriter normalRidesWriter = new PrintWriter(new FileWriter(normalRidesTxtFile));
            for(int i =0;i<rides.size();i++){
                NormalRide temp = (NormalRide)rides.get(i);
                //String line = temp.getDriver().getDriverName()+" "+temp.getDriver().getDriverRate();
                String line = temp.getDriverName()+" "+temp.getRateOfDriver();
                normalRidesWriter.println(line);
            }

            normalRidesWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }

    @Override
    public void read(Vector rides) {
        try{
            File normalRidesText = new File("src/NormalRides.txt");
            Scanner normalRidesScan = new Scanner(normalRidesText);
            while(normalRidesScan.hasNextLine()){
                String info = normalRidesScan.nextLine();
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
            normalRidesScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }


    }
}
