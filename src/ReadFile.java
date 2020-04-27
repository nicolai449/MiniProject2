import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    private final File filePath = new File("lib/experiment1/valid");
    private final List<File> files = Arrays.asList(filePath.listFiles());
    private FileReader reader;

    public List<String> getContents() {
        List<String> contents = new ArrayList<>();

        files.forEach(file -> {
            if (file.toPath().toString().contains("pos")) {
                try {
                    System.out.println("READING : " + file.toPath());
                    System.out.println(file);
                    contents.addAll(Files.readAllLines(file.toPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return contents;
    }
}
