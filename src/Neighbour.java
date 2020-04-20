
public class Neighbour implements Comparable<Neighbour>{
    private double distance;
    private String label;

    public Neighbour(double distance, String label){
        this.distance = distance;
        this.label = label;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

     /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int compareTo(Neighbour o) {
        return Double.compare(this.distance, o.getDistance());
    }

    @Override
    public String toString() {
        String outputString = "Distance: " + getDistance() + ", class label: " + getLabel();
        return outputString;
    }

}