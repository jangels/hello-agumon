package org.smallfire.java.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ImageIoTry
 * Created by liuzhenhua on 2017/10/19.
 */
public class ImageIoTry {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\e5f7a08681cb1bcc8a7b60951feccc98_r.jpg");
        BufferedImage bufferedImage = ImageIO.read(file);
        System.out.println(bufferedImage.getWidth());
        System.out.println(bufferedImage.getHeight());

    }
}
