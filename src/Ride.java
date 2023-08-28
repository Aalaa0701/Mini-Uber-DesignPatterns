public interface Ride {
    void requestRide();
    double calculateFare(double distance);
    RideFactory ride=new RideFactory();
}
