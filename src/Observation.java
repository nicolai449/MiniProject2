import java.util.Objects;

public class Observation {
    private final String date;
    private final int beaconId;
    private final int edgenodeId;
    private final double rssi;
    private final double realX;
    private final double realY;

    public Observation(String date, int beaconId, int edgenodeId, double rssi, double realX, double realY) {
        this.date = date;
        this.beaconId = beaconId;
        this.edgenodeId = edgenodeId;
        this.rssi = rssi;
        this.realX = realX;
        this.realY = realY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Observation that = (Observation) o;
        return beaconId == that.beaconId &&
                edgenodeId == that.edgenodeId &&
                Double.compare(that.rssi, rssi) == 0 &&
                Double.compare(that.realX, realX) == 0 &&
                Double.compare(that.realY, realY) == 0 &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, beaconId, edgenodeId, rssi, realX, realY);
    }

    public double calculateEuclideanDistance(Observation other) {
        return Math.sqrt(Math.pow(this.realX - other.realX, 2) + Math.pow(this.realX - other.realY, 2));
    }


}