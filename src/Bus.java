public class Bus implements Ride{
    int passengerCount;
    private final double BASE_FARE = 1.5;
    private final double RATE_PER_KM = 0.1;
    private final double PASSENGER_CHARGE = 0.5;
    DriverInfo driver;

    public Bus(String driverName, float driverRate) {
        driver = new DriverInfo();
        driver.setDriverName(driverName);
        driver.setDriverRate(driverRate);
    }
    public DriverInfo getDriver() {
        return driver;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        if(passengerCount <= 30){
            this.passengerCount = passengerCount;
        }
    }

    @Override
   public void requestRide() {
        // Implementation for requesting a normal ride
    }

    @Override
    public double calculateFare(double distance) {
        double fare = BASE_FARE + (RATE_PER_KM * distance);
        fare += (passengerCount * PASSENGER_CHARGE);
        return fare;
    }



    public int getMaxCapacity() {
        return 30;
    }

    public void boardPassenger() {
        if (passengerCount < getMaxCapacity()){
            passengerCount++;
            System.out.println("Passenger boarded. ");
        }else
        {
            System.out.println("Unfortunately, the bus is full");
        }
    }
    public void exitPassenger(){
        if (passengerCount>0)
        {
            passengerCount--;
            System.out.println("Passenger exited. Total passenger: " +passengerCount);
        }else {
            System.out.println("No passenger on the bus.");
        }



    }
}
