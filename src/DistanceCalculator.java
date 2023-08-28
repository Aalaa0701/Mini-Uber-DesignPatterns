import java.util.HashMap;
import java.util.Map;

public class DistanceCalculator {
    public static void main(String[] args) {
        Map<String, Map<String, Double>> distances = new HashMap<>();

        // Add distances to the HashMap
        distances.put("Cairo", new HashMap<>());
        distances.get("Cairo").put("Alex", 80.0);
        distances.get("Cairo").put("Giza", 50.0);
        distances.get("Cairo").put("Aswan", 150.0);


        distances.put("Alex", new HashMap<>());
        distances.get("Alex").put("Cairo", 80.0);
        distances.get("Alex").put("Giza", 90.0);
        distances.get("Alex").put("Aswan", 200.0);



        distances.put("Aswan", new HashMap<>());
        distances.get("Aswan").put("Alex", 200.0);
        distances.get("Aswan").put("Giza", 170.0);
        distances.get("Aswan").put("Cairo", 150.0);
        // Similarly, add distances for other cities

        distances.put("Giza", new HashMap<>());
        distances.get("Giza").put("Alex", 90.0);
        distances.get("Giza").put("Aswan", 170.0);
        distances.get("Giza").put("Cairo", 50.0);

    }


}
