import java.util.*;

public class WriteInFiles implements FileHandlingForUsersWrite{


    public WriteInFiles(Map users, Vector normalRides,Vector premiumRides,
                        Vector busRides,Vector motorBikeRides, Queue rideTickets, Queue paymentTickets,
                        Vector normalRidesTaken,Vector premiumRidesTaken, Vector motorBikeRidesTaken,Vector busesFull) {
       this.write(users);
       this.write(rideTickets, paymentTickets);
       this.WriteAllRides(normalRides, premiumRides, busRides, motorBikeRides, normalRidesTaken, premiumRidesTaken,
               motorBikeRidesTaken,busesFull);
    }

    @Override
    public void write(Map Users) {
        UserFile.getInstance().write(Users);
    }
    public void WriteAllRides(Vector normalRides, Vector premiumRides, Vector busRides, Vector motorBikeRides,
                              Vector NormalRidesTaken, Vector PremiumRidesTaken,
                              Vector MotorBikeRidesTaken, Vector busesFull){
        NormalRidesFile.getInstance().write(normalRides);
        PremiumRidesFile.getInstance().write(premiumRides);
        BusRidesFile.getInstance().write(busRides);
        MotorBikeRidesFile.getInstance().write(motorBikeRides);
        NormalRidesTakenFile.getInstance().write(NormalRidesTaken);
        PremiumRidesTakenFile.getInstance().write(PremiumRidesTaken);
        MotorBikesTakenFile.getInstance().write(MotorBikeRidesTaken);
        BusRidesFullFile.getInstance().write(busesFull);
    }


    public void write(Queue rideTickets, Queue paymentTickets) {
        RideTicketsFile.getInstance().write(rideTickets);
        PaymentTicketsFile.getInstance().write(paymentTickets);
    }
}
