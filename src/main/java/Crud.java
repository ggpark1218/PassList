import java.io.*;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class Crud {
    BufferedReader br;
    ArrayList<Person> list;

    FileIO fileIO = new FileIO();

    //list = fileIO.readFile();

    void printMenu(){
        System.out.println("----menu----");
        System.out.println("1. 조회 ");
        System.out.println("2. 추가 ");
        System.out.println("3. 수정 ");
        System.out.println("4. 삭제 ");
        System.out.println("5. 파일 저장하기");
        System.out.println("0. 종료 ");
        System.out.println("-----------");
        System.out.println("숫자를 입력하세요 (ex. 1): ");
    }

    public boolean choice (String s) throws IOException {
        switch (s){
            case "1":
                readData();
                break;
            case "2":
                createData();
                break;
            case "3":
                updateDate();
                break;
            case "4":
                deleteData();
                break;
            case "5":
                fileIO.saveFile(list);
            case "0":
                System.out.println("Bye!");
                return false;
            default: System.out.println("잘못된 선택!");
        }
        return true;
    }

    private void readData(){
        if(this.list.size()==0) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        System.out.println("ID  Name  Temp  Hour  Min  AbroadVisit  RegDate");
        System.out.println("==================================================");
        for(Person person: this.list){
            System.out.println(person.toString());
        }

    }

    private void createData(){
        Person person = new Person();
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("이름 (ex. 박규경):");
            person.setName(br.readLine());
            System.out.println("체온 (ex. 36.5):");
            person.setTemp(Double.parseDouble(br.readLine()));
            System.out.println("방문 시간(시 ex. 13):");
            person.setHour(Integer.parseInt(br.readLine()));
            System.out.println("방문 시간(분 ex. 00):");
            person.setMin(Integer.parseInt(br.readLine()));
            System.out.println("이주 내 해외 방문 여부(y/n):");
            String yn = br.readLine();

            if(yn.equals("y")||yn.equals("n")) {
                person.setAbroad_visit(yn);
            }
            else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        person.setId(this.list.size());

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String Date = date.format(formatter);
        person.setRegDate(Date);

        this.list.add(person);
        System.out.println("추가 완료");
    }

    private void updateDate(){
        try {
            System.out.println("수정할 항목의 ID를 입력하세요.(ex. 1)");
            br = new BufferedReader(new InputStreamReader(System.in));

            int id = Integer.parseInt(br.readLine());
            if(valid(id)){
                System.out.println("이름 (ex. 박규경):");
                this.list.get(id).setName(br.readLine());
                System.out.println("체온 (ex. 36.5):");
                this.list.get(id).setTemp(Double.parseDouble(br.readLine()));
                System.out.println("방문 시간(시 ex. 13):");
                this.list.get(id).setHour(Integer.parseInt(br.readLine()));
                System.out.println("방문 시간(분 ex. 00):");
                this.list.get(id).setMin(Integer.parseInt(br.readLine()));
                System.out.println("이주 내 해외 방문 여부(y/n):");
                String yn = br.readLine();
                if(yn.equals("y")||yn.equals("n")) {
                    this.list.get(id).setAbroad_visit(yn);
                }else {
                    System.out.println("잘못 입력하셨습니다.");
                }

                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String regDate = date.format(formatter);
                this.list.get(id).setRegDate(regDate);
                System.out.println("수정 완료.");

            }else{
                updateDate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteData(){
        if(this.list.size()==0) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        try{
            System.out.println("삭제할 Id를 입력해주세요.");
            br = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(br.readLine());
            if(valid(id)) {
                this.list.remove(id);
                for (int i = 0; i < list.size(); i++)
                    this.list.get(i).setId(i);
                System.out.println("삭제 완료.");
            }else {
                deleteData();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private boolean valid(int id) {
        if (this.list.size() <= id) {
            System.out.println("없는 Id 입니다.");
            return false;
        }
        return true;
    }
}
