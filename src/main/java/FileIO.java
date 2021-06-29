import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

public class FileIO {

    String filepath;
    String filename;

    public FileIO() {
        this.filepath = Paths.get(".").toAbsolutePath().toString();
        this.filename = "data.txt";
    }

    void saveFile(ArrayList<Person> list) throws IOException {

        PrintWriter pw = new PrintWriter(new FileWriter(filename));

        pw.write("이름/체온/방문시/분/해외방문여부/기록일자");
        for(Person p:list){
            pw.write(p.getName()+"/"+p.getTemp()+"/"+p.getHour()+"/"+p.getMin()+"/"+p.getAbroad_visit());
        }
        pw.close();
    }

    public ArrayList<Person> loadFile(){
        ArrayList<Person> list = new ArrayList<>();
        try{
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int i=0;
            String line="";
            while((line=bufferedReader.readLine())!=null){
                StringTokenizer st = new StringTokenizer(line, "/");

                String name = st.nextToken().trim();
                double temp = Double.parseDouble(st.nextToken().trim());
                int hour = Integer.parseInt(st.nextToken().trim());
                int min = Integer.parseInt(st.nextToken().trim());
                String abroad_visit = st.nextToken().trim();
                String regDate = st.nextToken().trim();
                list.add(new Person(i, name, temp, hour, min, abroad_visit, regDate));
                i++;
            }
            bufferedReader.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    return list;
    }

}
