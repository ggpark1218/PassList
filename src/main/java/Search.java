import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Search {
    BufferedReader br;

    public void searchBy(List<Person> list, String keyword) throws IOException {

        if(keyword.equals("name")){
            System.out.println("검색할 이름 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            String name = br.readLine();

            System.out.println("ID   Name  Temp  Hour  Min  AbroadVisit  RegDate");
            System.out.println("==========================================");

            for( Person p : list ){
                if( p.getName().equals(name) ){
                    System.out.println(p.toString());
                }
            }
        }else if(keyword.equals("Hour")){
            System.out.println("검색할 방문시간 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            int hour = Integer.parseInt(br.readLine());

            System.out.println("ID   Name  Temp  Hour  Min  AbroadVisit  RegDate");
            System.out.println("==========================================");

            for( Person p : list ){
                if( p.getHour()== hour ){
                    System.out.println(p.toString());
                }
            }
        }
    }
}
