import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    BufferedReader br;

    public String printMenu() throws IOException {
        System.out.println("---방문 기록 명부---");
        System.out.println("1. 조회");
        System.out.println("2. 추가");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 이름 검색");
        System.out.println("6. 방문시간 검색");
        System.out.println("7. 파일 저장하기");
        System.out.println("0. 종료");
        System.out.println("----------");
        System.out.println("번호를 입력해주세요");

        br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

}
