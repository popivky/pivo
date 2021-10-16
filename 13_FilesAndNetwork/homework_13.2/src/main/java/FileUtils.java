import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory

        Path ctrlc = Paths.get(sourceDirectory);
        Path ctrlv = Paths.get(destinationDirectory);






        File sourceFolder = new File(sourceDirectory);
        File[] filesSource = sourceFolder.listFiles();
        assert filesSource != null;
        try {
            for (File links : filesSource) {
                Path sourcePath = links.toPath();
                File dest = new File(destinationDirectory + "\\" + links.getName());
                Path destPath = dest.toPath();

                Files.copy(sourcePath, destPath);
                if (links.isDirectory()) {

                    copyFolder(links.getAbsolutePath(), dest.getAbsolutePath());
                }


            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
