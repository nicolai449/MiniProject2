import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Observation {
    private final Map<Double, Double> feature;
    private String label;

    public Observation(){
        feature = new HashMap<>();
    }

    /**
     * Adds the feature and value to the map of features
     *
     * @param feature
     * @param value
     */
    public void addToFeature(double feature, double value) {
        this.feature.put(feature, value);
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @return the feature
     */
    public Double getFeature(double feature) {
        return this.feature.get(feature);
    }

    public Set<Double> getFeatures() {
        return feature.keySet();
    }
}