import java.util.Set;

public class Distance {
    public double calculateEuclideanDistance(Observation a, Observation b) {
        double squaredDistance = 0;

        Set<Integer> aFeaturSet = a.getFeatures();
        for (Integer integer : aFeaturSet) {
            if (b.getFeature(integer.intValue()) != null) {
                squaredDistance += Math.pow(a.getFeature(integer.intValue()) - b.getFeature(integer.intValue()), 2);
            } else {
                squaredDistance += Math.pow(a.getFeature(integer.intValue()), 2);
            }
        }
        Set<Integer> bFeatureSet = b.getFeatures();
        for (Integer integer : bFeatureSet) {
            if (a.getFeature(integer.intValue()) == null) {
                squaredDistance += Math.pow(b.getFeature(integer.intValue()), 2);
            }
        }

        return Math.sqrt(squaredDistance);
    }

    
}