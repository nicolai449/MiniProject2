import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class ReadFile {

    private final String filename;
    private final File filePath;
    private final List<File> files;

    public ReadFile(String path, String filename) {
        this.filename = filename;
        this.filePath = new File(path);
        this.files = Arrays.asList(filePath.listFiles());
    }


    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private List<String> getContents() {
        List<String> contents = new ArrayList<>();

        files.forEach(file -> {
            if (file.toPath().toString().endsWith(filename)) {
                try {
                    contents.addAll(Files.readAllLines(file.toPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return contents;
    }

    public Map<Integer, List<Double>> getObservations() {
        //List<Observation> observations = new ArrayList<>();
        Map<Integer, List<Double>> observations = new HashMap<>();
        getContents().forEach(s -> {
            String[] p = s.split(",");
            if (isNumeric(p[1])) {
                List<Double> doubleholder2 = new ArrayList<>();
                if (!observations.containsKey(Integer.valueOf(p[1]))) {

                    doubleholder2.addAll(Arrays.asList(Double.valueOf(p[3]), Double.valueOf(p[4]), Double.valueOf(p[5])));
                    observations.put(Integer.valueOf(p[1]), doubleholder2);
                    //observations.put(Integer.valueOf(p[1]), Arrays.asList(Double.valueOf(p[3]), Double.valueOf(p[4]), Double.valueOf(p[5])));
                } else {

                    observations.get(Integer.valueOf(p[1])).add(Double.valueOf(p[3]));
                    observations.get(Integer.valueOf(p[1])).add(Double.valueOf(p[4]));
                    observations.get(Integer.valueOf(p[1])).add(Double.valueOf(p[5]));
                }
                //String date, int beaconId, int edgenodeId, double rssi, double realX, double realY
                //observations.add(new Observation(String.valueOf(p[0]), Integer.valueOf(p[1]), Integer.valueOf(p[2]), Double.valueOf(p[3]), Double.valueOf(p[4]), Double.valueOf(p[5])));

            }
        });

        return observations;
    }
}
