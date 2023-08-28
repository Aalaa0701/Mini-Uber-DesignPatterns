import java.util.Scanner;

public class rideInfo {
    String driverName;
    float rateOfDriver;

    public rideInfo(String driverName, float rateOfDriver) {
        this.driverName = driverName;
        this.rateOfDriver = rateOfDriver;
    }
    public void chooseLocation(){
        String destination;
        String currentLocation;
        System.out.println("Where are you now?");
        System.out.println("""
                Cairo
                Alex
                Giza
                Aswan""");
        Scanner scanner = new Scanner(System.in);
        currentLocation = scanner.next();
        currentLocation=currentLocation.toLowerCase();
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
        }while (currentLocation.equals(destination));

    }
}
