import java.util.TimerTask;
import java.util.Vector;

public class RideCompleted extends TimerTask {

    Vector<NormalRide> normalRidesTaken = new Vector<>();
    Vector<PremiumRide> premiumRidesTaken = new Vector<>();
    Vector<Motorbike> motorbikesTaken = new Vector<>();
    Vector<Bus> busesTaken = new Vector<>();
    Vector<Bus> buses = new Vector<>();

    public RideCompleted(Vector<NormalRide> normalRidesTaken, Vector<PremiumRide> premiumRidesTaken,
                         Vector<Motorbike> motorbikesTaken, Vector<Bus> busesTaken, Vector<Bus> buses) {
        this.normalRidesTaken = normalRidesTaken;
        this.premiumRidesTaken = premiumRidesTaken;
        this.motorbikesTaken = motorbikesTaken;
        this.busesTaken = busesTaken;
        this.buses = buses;
    }

    @Override
    public void run() {
        if(normalRidesTaken.size() > 0){
            normalRidesTaken.remove(0);
        }
        if(premiumRidesTaken.size() > 0){
            premiumRidesTaken.remove(0);
        }
        if(motorbikesTaken.size() > 0){
            motorbikesTaken.remove(0);
        }
        if(buses.size() > 0){
            for(int i = 0;i<buses.size();i++){
                buses.get(i).exitPassenger();
            }
        }
        if(busesTaken.size() > 0){
            busesTaken.get(0).exitPassenger();
            buses.add(busesTaken.remove(0));
        }

    }
}
