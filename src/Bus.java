import java.util.Scanner;
import java.util.Vector;

public class Bus extends RideInfo implements Ride{
    int passengerCount;
    Vector<Bus> busesAvailable;
    Vector<Bus>busesUnavailable;

    public Bus(String driverName, float rateOfDriver) {
        super(driverName, rateOfDriver);
    }
    public Bus(Vector busesAvailable, Vector busesUnavailable){
        this.busesAvailable=busesAvailable;
        this.busesUnavailable=busesUnavailable;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
   public void requestRide() {
        //checking if the bus is fully booked and move the ride from available to unavailable
        for(int i=0;i<busesAvailable.size();i++){
            if(busesAvailable.get(i).passengerCount == getMaxCapacity()){
                busesUnavailable.add(busesAvailable.elementAt(i));
                busesAvailable.removeElementAt(i);
            }
        }
        // view the available rides and asking the user to choose one of them
        for (int i=0;i<busesAvailable.size();i++){
            System.out.println(i+1 + " Name: " + busesAvailable.get(i).driverName + " Rate: " + busesAvailable.get(i).rateOfDriver);
        }
        Scanner scanner = new Scanner(System.in);
        int numOfRide = scanner.nextInt();
        busesAvailable.elementAt(numOfRide-1).passengerCount++;
        System.out.println("Passenger boarded successfully.");
    }


    public double calculateFare(double distance) {
        double RATE_PER_KM = 0.1;
        double BASE_FARE = 1.5;
        double fare = BASE_FARE + (RATE_PER_KM * distance);
        double PASSENGER_CHARGE = 0.5;
        fare += (passengerCount * PASSENGER_CHARGE);
        System.out.println("Your fare is "+fare +"$");
        return fare;
    }



    public int getMaxCapacity() {
        return 30;
    }


    public void exitPassenger(){
        if (passengerCount>0)
        {
            passengerCount--;
        }
    }
}