import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<Observation> getObservations() {
        List<Observation> observations = new ArrayList<>();
        getContents().forEach(s -> {
            String[] p = s.split(",");
            if (isNumeric(p[2])) {
                List<Double> doubleholder2 = new ArrayList<>();


                for (int i = 4; i < p.length; i++) {
                    try {
                        doubleholder2.add(Double.valueOf(p[i]));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(p[0]);
                    }

                }
                observations.add(new Observation(p[0], Integer.valueOf(p[1]), Double.valueOf(p[2]), Double.valueOf(p[3]), doubleholder2));
            }
        });
        return observations;
    }


}