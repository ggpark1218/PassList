import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

public class FileIO {

    private final String filepath;
    private final String filename;

    public FileIO() {
        this.filepath = Paths.get(".").toAbsolutePath().toString();
        this.filename = filepath + "/data.txt";
    }

    void saveFile(ArrayList<Person> list) throws IOException {

        PrintWriter pw = new PrintWriter(new FileWriter(filename));

        for(Person p:list){
            pw.write(p.getId() + " / " + p.getName()+" / "+p.getTemp()+" / "+p.getHour()+" / "+p.getMin()+" / "+p.getAbroad_visit() +" / "+p.getRegDate() + "\n");
        }
        pw.close();

    }

    public ArrayList<Person> readFile(){
        ArrayList<Person> list = new ArrayList<>();

        try{
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            while((line=bufferedReader.readLine())!=null){
                StringTokenizer st = new StringTokenizer(line, "/");

                int id = Integer.parseInt(st.nextToken().trim());
                String name = st.nextToken().trim();
                double temp = Double.parseDouble(st.nextToken().trim());
                int hour = Integer.parseInt(st.nextToken().trim());
                int min = Integer.parseInt(st.nextToken().trim());
                String abroad_visit = st.nextToken().trim();
                String regDate = st.nextToken().trim();
                list.add(new Person(id, name, temp, hour, min, abroad_visit, regDate));
            }
            bufferedReader.close();

        }catch (FileNotFoundException e) {
            System.out.println("data.txt 파일이 존재하지 않습니다.");
        } catch (IOException e) {
            System.out.println(e);
        }

    return list;
    }

}
