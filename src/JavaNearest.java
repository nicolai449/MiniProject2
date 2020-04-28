import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class JavaNearest {
    public static void main(String[] args) {
        ReadFile readFileTest = new ReadFile("lib/experiment1/test", "data_wide.csv");
        List<Observation> testObservations = readFileTest.getObservations();
        ReadFile readFileTrain = new ReadFile("lib/experiment1/train", "data_wide.csv");
        List<Observation> trainObservations = readFileTest.getObservations();

        AtomicReference<Double> averageErrorX = new AtomicReference<>((double) 0);
        AtomicReference<Double> averageErrorY = new AtomicReference<>((double) 0);

        testObservations.forEach(testObservation -> {

            Map<Double, Observation> distances = new TreeMap<>();

            trainObservations.forEach(trainObservation -> {
                double localD = trainObservation.calculateEuclideanDistance(testObservation);
                if (localD != 0.0) {
                    distances.put(localD, trainObservation);
                }
            });
            Map.Entry<Double, Observation> key = distances.entrySet().iterator().next();

            /*
            System.out.println();
            System.out.println();
            System.out.println(distances.get(key.getKey()).getRealX());
            System.out.println(distances.get(key.getKey()).getRealY());
            System.out.println(testObservation.getRealX());
            System.out.println(testObservation.getRealY());
            System.out.println();
            System.out.println();

             */

            averageErrorX.set(averageErrorX.get() + distances.get(key.getKey()).getRealX());
            averageErrorY.set(averageErrorY.get() + distances.get(key.getKey()).getRealY());


        });
        System.out.println(averageErrorX.get() / testObservations.size());
        System.out.println(averageErrorY.get() / testObservations.size());


    }
}