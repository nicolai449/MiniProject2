import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaNearest {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        List<Observation> observations = readFile.getObservations();

        Map<Observation, Neighbour> distances = new HashMap<>();

        //For all observations
        observations.forEach(observation -> {

            observations.forEach(observation1 -> {

                double distance = observation.calculateEuclideanDistance(observation1);

                if (distances.get(observation) == null && !observation.equals(observation1)) {
                    distances.put(observation, new Neighbour(observation1, distance));

                } else if (distance != 0.0 && distance < distances.get(observation).getDistance()) {
                    distances.replace(observation, new Neighbour(observation1, distance));
                }


            });


        });

        distances.forEach((observation, neighbour) -> {
            System.out.println(observation + " --> " + neighbour);
        });


    }
}