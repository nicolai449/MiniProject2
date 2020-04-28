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
    public String toString() {
        return "Observation{" +
                "date='" + date + '\'' +
                ", beaconId=" + beaconId +
                ", edgenodeId=" + edgenodeId +
                ", rssi=" + rssi +
                ", realX=" + realX +
                ", realY=" + realY +
                '}';
    }

    public double calculateEuclideanDistance(Observation other) {
        return Math.sqrt(Math.pow(this.realX - other.realX, 2) + Math.pow(this.realX - other.realY, 2));
    }

    public String getDate() {
        return date;
    }

    public int getBeaconId() {
        return beaconId;
    }

    public int getEdgenodeId() {
        return edgenodeId;
    }

    public double getRssi() {
        return rssi;
    }

    public double getRealX() {
        return realX;
    }

    public double getRealY() {
        return realY;
    }

}