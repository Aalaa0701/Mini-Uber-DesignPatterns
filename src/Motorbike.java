import java.util.Scanner;
import java.util.Vector;
public class Motorbike extends RideInfo implements Ride{
    Vector<Motorbike> motorbikesAvailable;
    Vector<Motorbike> motorbikesUnavailable;

    public Motorbike(Vector<Motorbike> motorbikesAvailable, Vector<Motorbike> motorbikesUnavailable) {
        this.motorbikesAvailable = motorbikesAvailable;
        this.motorbikesUnavailable = motorbikesUnavailable;
    }

    public Motorbike(String driverName, float rateOfDriver) {
        super(driverName, rateOfDriver);
    }

    public void requestRide() {
        //making rides



        // view the available rides and asking the user to choose one of them
        System.out.println("Choose one of available rides : ");
        for (int i=0;i<motorbikesAvailable.size();i++){
            System.out.println(i+1 + " Name: " + motorbikesAvailable.get(i).driverName + " Rate: " + motorbikesAvailable.get(i).rateOfDriver);
        }
        Scanner scanner = new Scanner(System.in);
        int numOfRide = scanner.nextInt();
        // move the chosen ride from available to unavailable
        motorbikesUnavailable.add(motorbikesAvailable.elementAt(numOfRide-1));
        motorbikesAvailable.removeElementAt(numOfRide-1);
    }





    @Override
    public double calculateFare(double distance) {
        double BASE_FARE = 2.0;
        double RATE_PER_KM = 0.15;
        double fare = BASE_FARE + (RATE_PER_KM * distance);
        System.out.println("Your fare is "+fare +"$");
        return fare;
    }
}
