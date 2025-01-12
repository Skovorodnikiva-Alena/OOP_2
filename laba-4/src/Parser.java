import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Parser {

    public List<String> parse(String path) throws IOException {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (NoSuchFileException e) {
            throw new NoSuchFileException("Файл " + path + " не найден");
        }
    }
}