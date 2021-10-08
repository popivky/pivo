import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final long ONE_KB = 1024;
    private static final long ONE_MB = (long) Math.pow(1024,2);
    private static final long ONE_GB = (long) Math.pow(1024,3);
    private static final long ONE_TB = (long) Math.pow(1024,4);

    public static void main(String[] args) {

        try {
            while (true) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Введите путь к папке:");
                String input = scanner.nextLine();
                File file = new File(input);
                if (!file.isDirectory() && !file.isFile()){
                    System.out.println("Папка либо файл не найден");
                    continue;
                }

                if (input.equals("0")) {
                    break;
                }
                long size;
                size = FileUtils.calculateFolderSize(input);

                if (size < ONE_KB) {
                    System.out.println("Размер папки: " + input + " составляет: " + size + " байт");

                }
                if (size >= ONE_KB && size < ONE_MB) {

                    double scale = Math.pow(10, 2);
                    double convertSize = Math.floor(((double) size / ONE_KB) * scale) / scale;
                    System.out.println("Размер папки: " + input + " составляет: " + convertSize + " KB");
                }
                if (size >= ONE_MB && size < ONE_GB) {

                    double scale = Math.pow(10, 2);
                    double convertSize = Math.floor(((double) size / ONE_MB) * scale) / scale;
                    System.out.println("Размер папки: " + input + " составляет: " + convertSize + " MB");
                }
                if (size >= ONE_GB && size < ONE_TB) {

                    double scale = Math.pow(10, 2);
                    double convertSize = Math.floor(((double) size / ONE_GB) * scale) / scale;
                    System.out.println("Размер папки: " + input + " составляет: " + convertSize + " GB");
                }
                if (size >= ONE_TB) {

                    double scale = Math.pow(10, 2);
                    double convertSize = Math.floor(((double) size / ONE_TB) * scale) / scale;
                    System.out.println("Размер папки: " + input + " составляет: " + convertSize + " TB");
                }
              //  System.out.println(size + " байт");

            }
        } catch (Exception exception){
        exception.printStackTrace();
        }


    }

}