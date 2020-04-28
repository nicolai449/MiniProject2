import java.util.List;
import java.util.Map;

public class JavaNearest {
    public static void main(String[] args) {
        ReadFile readFileTest = new ReadFile("lib/experiment1/test", "data.csv");
        //List<Observation> testObservations = readFileTest.getObservations();
        Map<Integer, List<Double>> testObservations = readFileTest.getObservations();
        //ReadFile readFileTrain = new ReadFile("lib/experiment1/train", "data.csv");
        //List<Observation> trainObservations = readFileTest.getObservations();


        testObservations.forEach((integer, doubles) -> {

            System.out.println(integer + " " + doubles);


        });

            /*

            testObservations.forEach(contester -> {

                if (observation.getBeaconId() == contester.getBeaconId()){

                    System.out.println(contester.getBeaconId());

                }

            });

             */


        //System.out.println(radioMap.toString());




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

    /*
    public Map generateRadiomap() {
        ReadFile readFileTest = new ReadFile("lib/experiment1/train", "data.csv");
        List<Observation> observations = readFileTest.getObservations();

        Map<Observation, List<Observation>> radioMap = new HashMap<>();

        observations.forEach(observation -> {

            List<Observation> signalStrengthList = new ArrayList<>();

            observations.forEach(contester -> {



            });


        });

        return new HashMap();
       // return observations;
    }

     */
}

/*
1. abc ændres til beaconid




 */