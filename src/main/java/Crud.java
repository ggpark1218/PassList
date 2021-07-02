import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Crud {

    BufferedReader br;
    public void readData(ArrayList<Person> list) {

        if( list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        System.out.println("ID   Name  Temp  Hour  Min  AbroadVisit  RegDate");
        System.out.println("==========================================");
        for (Person p: list) {
            System.out.println(p.toString());
        }
    }

    public Person createData(ArrayList<Person> list) throws IOException {
        int id;
        String name;
        double temp;
        int hour;
        int min;
        String abroad_visit ="";
        String regDate;

        br = new BufferedReader(new InputStreamReader(System.in));
        id = list.size();

        System.out.println("이름 (ex. 박규경):");
        name = br.readLine();

        System.out.println("체온 (ex. 36.5):");
        temp = Double.parseDouble(br.readLine());

        System.out.println("방문 시간(시 ex. 13):");
        hour = Integer.parseInt(br.readLine());

        System.out.println("방문 시간(분 ex. 00):");
        min = Integer.parseInt(br.readLine());

        System.out.println("이주 내 해외 방문 여부(y/n):");
        String yn = br.readLine();
        if (yn.equals("y") || yn.equals("n")) {
            abroad_visit = abroad_visit.concat(yn);
        } else {
            System.out.println("잘못 입력하셨습니다.");
        }

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        regDate = date.format(formatter);

        Person p = new Person(id, name, temp, hour, min, abroad_visit, regDate);
        System.out.println("추가 완료");
        
        return p;

    }

    public void updateData(ArrayList<Person> list){

        if( list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        try {

            System.out.println("수정할 항목의 ID를 입력하세요.(ex. 1)");
            br = new BufferedReader(new InputStreamReader(System.in));

            int id = Integer.parseInt(br.readLine());
            if(Main.valid(list, id)){
                System.out.println("이름 (ex. 박규경):");
                list.get(id).setName(br.readLine());
                System.out.println("체온 (ex. 36.5):");
                list.get(id).setTemp(Double.parseDouble(br.readLine()));
                System.out.println("방문 시간(시 ex. 13):");
                list.get(id).setHour(Integer.parseInt(br.readLine()));
                System.out.println("방문 시간(분 ex. 00):");
                list.get(id).setMin(Integer.parseInt(br.readLine()));
                System.out.println("이주 내 해외 방문 여부(y/n):");
                String yn = br.readLine();
                if(yn.equals("y")||yn.equals("n")) {
                    list.get(id).setAbroad_visit(yn);
                }else {
                    System.out.println("잘못 입력하셨습니다.");
                }

                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String regDate = date.format(formatter);
                list.get(id).setRegDate(regDate);
                System.out.println("수정 완료.");

            }else{
                updateData(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(ArrayList<Person> list){
        if(list.size()==0) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        try{
            System.out.println("삭제할 Id를 입력해주세요.");
            br = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(br.readLine());
            if(Main.valid(list, id)) {
                list.remove(id);
                for (int i = 0; i < list.size(); i++)
                    list.get(i).setId(i);
                System.out.println("삭제 완료.");
            }else {
                deleteData(list);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
