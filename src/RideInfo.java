import java.util.Scanner;

public class RideInfo {
    String driverName;
    float rateOfDriver;

    public RideInfo(){};
    public RideInfo(String driverName, float rateOfDriver) {
        this.driverName = driverName;
        this.rateOfDriver = rateOfDriver;
    }
    public void chooseLocation(){
        String destination;
        String currentLocation;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Where are you now?");
            System.out.println("""
                Cairo
                Alex
                Giza
                Aswan""");
            currentLocation = scanner.next();
            currentLocation=currentLocation.toLowerCase();
            if(currentLocation.equals("cairo") || currentLocation.equals("giza") || currentLocation.equals("alex") || currentLocation.equals("aswan")){
                break;
            }
            else{
                System.out.println("Please type a valid current location!");
            }
        }while (true);


        do {
            System.out.println("Choose your destination");
            System.out.println("""
                    Cairo
                    Alex
                    Giza
                    Aswan""");
            destination = scanner.next();
            destination = destination.toLowerCase();
            if (currentLocation.equals(destination)) {
                System.out.println("Sorry! you can't choose the same location please try again");
            }
            else if(destination.equals("cairo") || destination.equals("giza") || destination.equals("alex") || destination.equals("aswan")){
               break;
            }
            else{
                System.out.println("Please type a valid destination!");
            }
        }while (true);

    }

    public String getDriverName() {
        return driverName;
    }

    public float getRateOfDriver() {
        return rateOfDriver;
    }
}
