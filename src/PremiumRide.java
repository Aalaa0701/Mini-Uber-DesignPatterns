import java.util.Scanner;
import java.util.Vector;

public class PremiumRide extends RideInfo implements Ride{

    Vector<PremiumRide> premiumRidesAvailable;
    Vector<PremiumRide> premiumRidesUnavailable;

    public PremiumRide(Vector<PremiumRide> premiumRidesAvailable, Vector<PremiumRide> premiumRidesUnavailable) {
        this.premiumRidesAvailable = premiumRidesAvailable;
        this.premiumRidesUnavailable = premiumRidesUnavailable;
    }

    public PremiumRide(String driverName, float rateOfDriver) {
        super(driverName, rateOfDriver);
    }

    public void requestRide() {
        //making rides


        // view the available rides and asking the user to choose one of them
        System.out.println("Choose one of available rides : ");
        for (int i=0;i<premiumRidesAvailable.size();i++){
            System.out.println(i+1 + " Name: " + premiumRidesAvailable.get(i).driverName + " Rate: " + premiumRidesAvailable.get(i).rateOfDriver);
        }
        Scanner scanner = new Scanner(System.in);
        int numOfRide = scanner.nextInt();
        // move the chosen ride from available to unavailable
        premiumRidesUnavailable.add(premiumRidesAvailable.elementAt(numOfRide-1));
        premiumRidesAvailable.removeElementAt(numOfRide-1);

    }

    @Override
    public double calculateFare(double distance) {
        double BASE_FARE = 4.0;
        double RATE_PER_KM = 0.3;
        double PREMIUM_CHARGE = 2.0;
        double fare = BASE_FARE + (RATE_PER_KM * distance) + PREMIUM_CHARGE;
        System.out.println("Your fare is "+fare +"$");
        return fare;
    }
}
