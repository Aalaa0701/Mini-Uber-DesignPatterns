import java.util.HashMap;
import java.util.Map;

public class DistanceCalculator {
    Map<String, Map<String, Double>> distances = new HashMap<>();
    String currentLocation;
    String destination;

    public DistanceCalculator() {
        setDistances();
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    void setDistances(){
        distances.put("cairo", new HashMap<>());
        distances.get("cairo").put("alex", 80.0);
        distances.get("cairo").put("giza", 50.0);
        distances.get("cairo").put("aswan", 150.0);


        distances.put("alex", new HashMap<>());
        distances.get("alex").put("cairo", 80.0);
        distances.get("alex").put("giza", 90.0);
        distances.get("alex").put("aswan", 200.0);



        distances.put("aswan", new HashMap<>());
        distances.get("aswan").put("alex", 200.0);
        distances.get("aswan").put("giza", 170.0);
        distances.get("aswan").put("cairo", 150.0);
        // Similarly, add distances for other cities

        distances.put("giza", new HashMap<>());
        distances.get("giza").put("alex", 90.0);
        distances.get("giza").put("aswan", 170.0);
        distances.get("giza").put("cairo", 50.0);


    }
    double getDistance(){
        double distance = distances.get(currentLocation).get(destination);
        System.out.println(distance);
        return distance;
    }




}
