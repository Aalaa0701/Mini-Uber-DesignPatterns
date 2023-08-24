public class NormalRide implements Ride{
    private final double BASE_FARE = 2.0;
    private final double RATE_PER_KM = 0.1;
    DriverInfo driver;



    public NormalRide(String driverName, float driverRate) {
        driver = new DriverInfo();
        driver.setDriverName(driverName);
        driver.setDriverRate(driverRate);
    }

    public void requestRide() {

        // Implementation for requesting a normal ride
    }

    public double calculateFare(double distance) {
        return BASE_FARE + (RATE_PER_KM * distance);
    }

    public DriverInfo getDriver() {
        return driver;
    }
}
