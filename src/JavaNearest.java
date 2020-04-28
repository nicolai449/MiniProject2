import java.util.List;

public class JavaNearest {
    public static void main(String[] args) {
        ReadFile readFileTest = new ReadFile("lib/experiment1/test", "data_wide.csv");
        List<Observation> testObservations = readFileTest.getObservations();
        ReadFile readFileTrain = new ReadFile("lib/experiment1/train", "data_wide.csv");
        List<Observation> trainObservations = readFileTest.getObservations();




        /*

        Map<Integer, Double> closestObservation = new HashMap<>();

        for (Map.Entry<Integer, List<Double>> e : testObservations.entrySet()) {
            Integer integer = e.getKey();
            List<Double> doubles = e.getValue();

            double distance = 0;

            //Here be dragons, plz refactor
            for (Map.Entry<Integer, List<Double>> entry : trainObservations.entrySet()) {

                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (entry.getValue().size() == doubles.size()) {
                        if (i % 3 == 2) {
                            distance = Math.pow(doubles.get(i) - entry.getValue().get(i), 2);
                        }
                    } else if (entry.getValue().size() > doubles.size()) {
                        if (i > doubles.size()) {
                            if (i % 3 == 2) {
                                distance = Math.pow(entry.getValue().get(i), 2);
                            }
                        } else {
                            if (i % 3 == 2) {
                                distance = Math.pow(doubles.get(i) - entry.getValue().get(i), 2);
                            }
                        }
                    } else if (entry.getValue().size() < doubles.size()) {
                        if (i < entry.getValue().size()) {
                            if (i % 3 == 2) {
                                distance = Math.pow(doubles.get(i), 2);
                            }
                        } else {
                            if (i % 3 == 2) {
                                distance = Math.pow(doubles.get(i) - entry.getValue().get(i), 2);
                            }
                        }
                    }
                }
            }
            distance = Math.sqrt(distance);


            closestObservation.put(integer, distance);

        }
        System.out.println(closestObservation);


         */
        /*

        Map<Integer, Double> closestObservation = new HashMap<>();

        for (Map.Entry<Integer, List<Double>> e : testObservations.entrySet()) {
            Integer integer = e.getKey();
            List<Double> doubles = e.getValue();

            double distance = 0;

            //Here be dragons, plz refactor
            for (Map.Entry<Integer, List<Double>> entry : trainObservations.entrySet()) {

                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (entry.getValue().size() == doubles.size()) {
                        if (i % 3 == 2) {
                            distance = Math.pow(doubles.get(i) - entry.getValue().get(i), 2);
                        }
                    } else if (entry.getValue().size() > doubles.size()) {
                        if (i > doubles.size()) {
                            if (i % 3 == 2) {
                                distance = Math.pow(entry.getValue().get(i), 2);
                            }
                        } else {
                            if (i % 3 == 2) {
                                distance = Math.pow(doubles.get(i) - entry.getValue().get(i), 2);
                            }
                        }
                    } else if (entry.getValue().size() < doubles.size()) {
                        if (i < entry.getValue().size()) {
                            if (i % 3 == 2) {
                                distance = Math.pow(doubles.get(i), 2);
                            }
                        } else {
                            if (i % 3 == 2) {
                                distance = Math.pow(doubles.get(i) - entry.getValue().get(i), 2);
                            }
                        }
                    }
                }
            }
            distance = Math.sqrt(distance);


            if (closestObservation.containsKey(integer) && closestObservation.get(integer) < distance) {
                closestObservation.replace(integer, distance);
            } else if (!closestObservation.containsKey(integer)) {
                closestObservation.put(integer, distance);
            }
        }
        System.out.println(closestObservation);


         */


    }
}