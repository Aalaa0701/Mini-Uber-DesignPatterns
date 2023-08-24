public class RideFactory {
    Ride createRide(String rideType) {
        if (rideType.equals("Normal")) {
            return new NormalRide();
        } else if (rideType.equals("Premium")) {
            return new PremiumRide();
        } else if (rideType.equals("Bus")) {
            return new Bus();
        } else if (rideType.equals("Motorbike")) {
            return new Motorbike();
        }else
            throw new IllegalArgumentException("Unknown ride type: " + rideType);
    }
}
