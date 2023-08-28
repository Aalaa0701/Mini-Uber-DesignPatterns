import java.util.Scanner;
import java.util.Vector;
public class Motorbike extends rideInfo implements Ride{

    public Motorbike(String driverName, float rateOfDriver) {
        super(driverName, rateOfDriver);
    }

    public void requestRide() {
        //making rides
        Vector<Motorbike> motorbikesAvailable= new Vector<>();
        Vector<Motorbike> motorbikesUnavailable= new Vector<>();
        motorbikesAvailable.add((Motorbike) ride.createRide("Motorbike","Ahmed",3f));
        motorbikesAvailable.add((Motorbike) ride.createRide("Motorbike","Ali",3.5f));
        motorbikesAvailable.add((Motorbike) ride.createRide("Motorbike","Mohamed",2f));
        motorbikesAvailable.add((Motorbike) ride.createRide("Motorbike","Wael",4f));
        motorbikesAvailable.add((Motorbike) ride.createRide("Motorbike","Mostafa",4.9f));
        motorbikesAvailable.add((Motorbike) ride.createRide("Motorbike","Hany",2.5f));
        motorbikesAvailable.add((Motorbike) ride.createRide("Motorbike","Emad",5f));
        motorbikesAvailable.add((Motorbike) ride.createRide("Motorbike","Omar",2.9f));

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
        return BASE_FARE + (RATE_PER_KM * distance);
    }
}
