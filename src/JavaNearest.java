import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class JavaNearest {
    public static void main(String[] args) {
        ReadFile readFileTest = new ReadFile("lib/experiment1/test", "data_wide.csv");
        List<Observation> testObservations = readFileTest.getObservations();
        ReadFile readFileTrain = new ReadFile("lib/experiment1/train", "data_wide.csv");
        List<Observation> trainObservations = readFileTrain.getObservations();

        AtomicReference<Double> distanceError = new AtomicReference<>((double) 0);

        testObservations.forEach(testObservation -> {

            Map<Double, Observation> distances = new TreeMap<>();

            trainObservations.forEach(trainObservation -> {
                double localD = trainObservation.calculateEuclideanDistance(testObservation);
                distances.put(localD, trainObservation);
            });

            Map.Entry<Double, Observation> key = distances.entrySet().iterator().next();

            distanceError.set(distanceError.get() + Math.sqrt(Math.pow(distances.get(key.getKey()).getRealX() - testObservation.getRealX(), 2) + Math.pow(distances.get(key.getKey()).getRealY() - testObservation.getRealY(), 2)));

        });
        System.out.println(distanceError.get() / testObservations.size());

    }
}