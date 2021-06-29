import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileIO {

    void saveFile(ArrayList<Person> list) throws IOException {
        String filepath = Paths.get(".").toAbsolutePath().toString();
        String filename = "data.txt";

        PrintWriter pw = new PrintWriter(new FileWriter(filename));

        pw.write("이름/체온/방문시/분/해외방문여부");
        pw.close();
    }

}
