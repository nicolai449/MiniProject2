import java.util.List;

public class Observation {


    private final int beaconId;
    private final double realX;
    private final double realY;
    private final List<Double> signalStrength;


    public Observation(int beaconId, double realX, double realY, List<Double> signalStrength) {
        this.beaconId = beaconId;
        this.realX = realX;
        this.realY = realY;
        this.signalStrength = signalStrength;
    }

    public double calculateEuclideanDistance(Observation other) {
        return Math.sqrt(Math.pow(this.realX - other.realX, 2) + Math.pow(this.realX - other.realY, 2));
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
                "beaconId=" + beaconId +
                ", realX=" + realX +
                ", realY=" + realY +
                ", signalStrength=" + signalStrength +
                '}';
    }
}