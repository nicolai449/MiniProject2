import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    private final File filePath = new File("lib/experiment1/valid");
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
            if (file.toPath().toString().contains("data.csv")) {
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
            if (isNumeric(p[0])) {
                observations.add(new Observation(Double.valueOf(p[1]), Double.valueOf(p[4]), Double.valueOf(p[5]), Double.valueOf(p[6])));
            }
        });

        return observations;
    }
}
