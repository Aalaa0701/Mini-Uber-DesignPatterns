import java.util.Scanner;
import java.util.Vector;

public class NormalRide extends RideInfo implements Ride{
    Vector<NormalRide> normalRidesAvailable;
    Vector<NormalRide> normalRidesUnavailable;

    public NormalRide(Vector<NormalRide> normalRidesAvailable, Vector<NormalRide> normalRidesUnavailable) {
        this.normalRidesAvailable = normalRidesAvailable;
        this.normalRidesUnavailable = normalRidesUnavailable;
    }

    public NormalRide(String driverName, float rateOfDriver) {
        super(driverName, rateOfDriver);
    }

    public void requestRide() {

        //making rides

        normalRidesAvailable.add((NormalRide)ride.createRide("Normal","Ahmed",3f));
        normalRidesAvailable.add((NormalRide)ride.createRide("Normal","Ali",3.5f));
        normalRidesAvailable.add((NormalRide)ride.createRide("Normal","Mohamed",2f));
        normalRidesAvailable.add((NormalRide)ride.createRide("Normal","Wael",4f));
        normalRidesAvailable.add((NormalRide)ride.createRide("Normal","Mostafa",4.9f));
        normalRidesAvailable.add((NormalRide)ride.createRide("Normal","Hany",2.5f));
        normalRidesAvailable.add((NormalRide)ride.createRide("Normal","Emad",5f));
        normalRidesAvailable.add((NormalRide)ride.createRide("Normal","Omar",4.1f));

        // view the available rides and asking the user to choose one of them
        System.out.println("Choose one of available rides : ");
        for (int i=0;i<normalRidesAvailable.size();i++){
            System.out.println(i+1 + " Name: " + normalRidesAvailable.get(i).driverName + " Rate: " + normalRidesAvailable.get(i).rateOfDriver);
        }
        Scanner scanner = new Scanner(System.in);
        int numOfRide = scanner.nextInt();

        // move the chosen ride from available to unavailable
        normalRidesUnavailable.add(normalRidesAvailable.elementAt(numOfRide-1));
        normalRidesAvailable.removeElementAt(numOfRide-1);
    }

    public double calculateFare(double distance) {
        double BASE_FARE = 2.0;
        double RATE_PER_KM = 0.1;
        double fare = BASE_FARE + (RATE_PER_KM * distance);
        System.out.println("Your fare is "+ fare +"$");
        return fare;
    }

}
