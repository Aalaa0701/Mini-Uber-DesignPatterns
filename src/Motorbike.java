public class Motorbike implements Ride{
    private final double BASE_FARE = 2.0;
    private final double RATE_PER_KM = 0.15;



    public void requestRide() {
        // Implementation for requesting a normal ride
    }

    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (RATE_PER_KM * distance);
    }
}