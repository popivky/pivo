import java.io.File;
import java.util.Arrays;

public class FileUtils {

    public static long calculateFolderSize(String path) {


            File folder = new File(path);


            if (folder.isFile()) {
                return folder.length();
            }
            long size = 0;

            File[] list = folder.listFiles();
           try {
               for (File file : list) {

                   size += calculateFolderSize(file.getAbsolutePath());
               }
           } catch (Exception exception) {
               exception.printStackTrace();
           }

        return size;

    }

    }




