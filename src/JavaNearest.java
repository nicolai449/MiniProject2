import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaNearest {
    public static void main(String[] args) {
        ReadFile readFileTest = new ReadFile("lib/experiment1/valid", "data.csv");
        List<Observation> observations = readFileTest.getObservations();
        //System.out.println(observations.size());

        observations.forEach(observation -> {
            observations.forEach(contester -> {


                if (observation.getRssi() == contester.getRssi())


                    if (observation.getDate().equals(contester.getDate()) && observation.getBeaconId() == contester.getBeaconId()) {
                        observations.remove(observation);

                    }


            });
        });
        System.out.println(observations.size());



        /*
        Map<Observation, Neighbour> distances = new HashMap<>();

        //For all observations
        observations.forEach(observation -> {

            //System.out.println(observation.toString());

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

         */


    }

    public Map generateRadiomap() {
        ReadFile readFileTest = new ReadFile("lib/experiment1/train", "data.csv");
        List<Observation> observations = readFileTest.getObservations();

        Map<Observation, List<Observation>> radioMap = new HashMap<>();

        observations.forEach(observation -> {

            List<Observation> signalStrengthList = new ArrayList<>();

            observations.forEach(contester -> {

                if (observation.getBeaconId())

                    double signalStrength =


            });


        });


        return observations;
    }
}

/*
1. abc ændres til beaconid




 */