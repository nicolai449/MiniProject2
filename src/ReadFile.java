import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    private final String filename;
    private String path;
    private final File filePath = new File(path);

    public ReadFile(String path, String filename) {
        this.path = path;
        this.filename = filename;
    }

    private final List<File> files = Arrays.asList(filePath.listFiles());

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

    public List<Observation> getObservations() {
        List<Observation> observations = new ArrayList<>();

        getContents().forEach(s -> {
            String[] p = s.split(",");
            if (isNumeric(p[1])) {

                //String date, int beaconId, int edgenodeId, double rssi, double realX, double realY
                observations.add(new Observation(String.valueOf(p[0]), Integer.valueOf(p[1]), Integer.valueOf(p[2]), Double.valueOf(p[3]), Double.valueOf(p[4]), Double.valueOf(p[5])));
            }
        });

        return observations;
    }
}
