public class RideFactory {
    Ride createRide(String rideType, String driverName, float driverRate) {
        if (rideType.equals("Normal")) {
            return new NormalRide(driverName,driverRate);
        } else if (rideType.equals("Premium")) {
            return new PremiumRide(driverName,driverRate);
        } else if (rideType.equals("Bus")) {
            return new Bus(driverName,driverRate);
        } else if (rideType.equals("Motorbike")) {
            return new Motorbike(driverName,driverRate);
        }else
            throw new IllegalArgumentException("Unknown ride type: " + rideType);
    }
}
