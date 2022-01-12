import org.imgscalr.ImageConvertor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    private static int newWidth = 150;

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\79268\\Documents\\sourceFolderPic";
        String dstFolder = "C:\\Users\\79268\\Documents\\destFolderPic";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int middle = files.length / 2;
        File[] files1 = new File[middle];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageConvertor convertor1 = new ImageConvertor(files1, dstFolder, newWidth, start);
        new Thread(convertor1).start();

        File[] files2 = new File[files.length - middle];
        System.arraycopy(files, middle, files2, 0, files2.length);
        ImageConvertor convertor2 = new ImageConvertor(files2, dstFolder, newWidth, start);
        new Thread(convertor2).start();


    }
}
