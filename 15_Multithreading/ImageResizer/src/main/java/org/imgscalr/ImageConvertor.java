package org.imgscalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.imgscalr.Scalr.OP_BRIGHTER;

public class ImageConvertor implements Runnable {

    private File[] files;
    private String dstFolder;
    private int newWidth;
    private long start;

    public ImageConvertor(File[] files, String dstFolder, int newWidth, long start) {
        this.files = files;
        this.dstFolder = dstFolder;
        this.newWidth = newWidth;
        this.start = start;
    }

    @Override
    public void run() {

        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }


                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );

                BufferedImage newSizeImage = Scalr.resize(image, newWidth, newHeight,  OP_BRIGHTER);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newSizeImage, "png", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Время после начала потока: " + (System.currentTimeMillis() - start));

    }
}
