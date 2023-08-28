public class RideFactory {
    Ride createRide(String rideType,String driverName,float rate) {
        return switch (rideType) {
            case "Normal" -> new NormalRide(driverName, rate);
            case "Premium" -> new PremiumRide(driverName, rate);
            case "Bus" -> new Bus(driverName, rate);
            case "Motorbike" -> new Motorbike(driverName, rate);
            default -> throw new IllegalArgumentException("Unknown ride type: " + rideType);
        };
    }
}
