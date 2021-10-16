import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите путь к копируемой папке");

            try {
            String sourcePath = scanner.nextLine() ;
            System.out.println("Введите путь к месту назначения копирования");
            String destPath = scanner.nextLine();
            File dest = new File(destPath);
            if(!dest.exists()) {
                FileUtils.copyFolder(sourcePath, destPath);
            } else System.out.println("Файл или папка с таким именем уже существует");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

}
