
public class Neighbour {
    private final double distance;
    private final Observation label;

    public Neighbour(Observation label, double distance) {
        this.distance = distance;
        this.label = label;
    }

    @Override
    public String toString() {
        return label + " distance=" + distance;
    }

    public double getDistance() {
        return distance;
    }

    public Observation getLabel() {
        return label;
    }

}