import java.util.List;

public class Observation {

    private final String date;
    private final int beaconId;
    private final double realX;
    private final double realY;
    private final List<Double> signalStrength;

    public Observation(String date, int beaconId, double realX, double realY, List<Double> signalStrength) {
        this.date = date;
        this.beaconId = beaconId;
        this.realX = realX;
        this.realY = realY;
        this.signalStrength = signalStrength;
    }


    public double calculateEuclideanDistance(Observation other) {
        double distance = 0;

        for (int i = 0; i < this.getSignalStrength().size(); i++) {

            distance += Math.pow(this.getSignalStrength().get(i) - other.getSignalStrength().get(i), 2);

        }
        return Math.sqrt(distance);

    }

    public int getBeaconId() {
        return beaconId;
    }

    public double getRealX() {
        return realX;
    }

    public double getRealY() {
        return realY;
    }

    public List<Double> getSignalStrength() {
        return signalStrength;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "date='" + date + '\'' +
                ", beaconId=" + beaconId +
                ", realX=" + realX +
                ", realY=" + realY +
                ", signalStrength=" + signalStrength +
                '}';
    }
}