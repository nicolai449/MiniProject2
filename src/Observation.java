import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Observation {
    private Map<Integer, Integer> feature;
    private String label;

    public Observation(){
        feature = new HashMap<>();
    }

    /**
     * Adds the feature and value to the map of features
     * @param feature
     * @param value
     */
    public void addToFeature(int feature, int value){
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
    public Integer getFeature(int feature) {
        return this.feature.get(feature);
    }

    public Set<Integer> getFeatures(){
        return feature.keySet();
    }
}