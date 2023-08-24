public class PremiumRide extends DriverInfo implements Ride{
    private final double BASE_FARE = 4.0;
    private final double RATE_PER_KM = 0.3;
    private final double PREMIUM_CHARGE = 2.0;


    public PremiumRide(String driverName, float driverRate) {
        super(driverName,driverRate);
    }

    public void requestRide() {
        // Implementation for requesting a premium ride
    }

    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (RATE_PER_KM * distance) + PREMIUM_CHARGE;
    }
}
