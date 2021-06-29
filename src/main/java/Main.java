import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        CRUD crud = new CRUD();
        System.out.println("시작!");
        boolean check = true;

        while (check){
            try {
                crud.printMenu();
                BufferedReader sbr = new BufferedReader(new InputStreamReader(System.in));
                String input = sbr.readLine();
                check = crud.choice(input);

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}