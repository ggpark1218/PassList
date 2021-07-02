import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Person> list;

        Menu m = new Menu();
        Crud crud = new Crud();
        Search search = new Search();
        FileIO fileIO = new FileIO();

        list = fileIO.readFile();

        System.out.println("-----시작-----");

        while(true) {
            try {
                String choose = m.printMenu();
                switch(choose){
                    case "1":
                        crud.readData(list);
                        break;

                    case "2":
                        list.add(crud.createData(list));
                        System.out.println("추가 완료!");
                        break;

                    case "3":
                        crud.readData(list);
                        crud.updateData(list);
                        System.out.println("수정 완료!");
                        break;

                    case "4":
                        crud.readData(list);
                        crud.deleteData(list);
                        System.out.println("삭제 완료!");
                        break;

                    case "5":
                        search.searchBy(list, "name");
                        break;

                    case "6":
                        search.searchBy(list, "Hour");
                        break;

                    case "7":
                        fileIO.saveFile(list);
                        System.out.println("파일에 저장되었습니다.");
                        break;

                    case "0":
                        System.out.println("종료");
                        return;

                    default:
                        System.out.println("잘못된 메뉴 선택");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean valid(ArrayList<Person> list, int num) {
        // 배열 범위
        if (list.size() <= num || num == -1) {
            System.out.println("없는 번호 입니다.");
            return false;
        }
        return true;
    }
}