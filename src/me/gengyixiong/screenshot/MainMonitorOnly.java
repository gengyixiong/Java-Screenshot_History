package me.gengyixiong.screenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Gengyixiong on 4/4/2015.
 */
public class MainMonitorOnly {
    public void createScreenshot(String myDir){
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        try{
            BufferedImage capture = new Robot().createScreenCapture(screenRect);
            try{
                ImageIO.write(capture, "bmp", new File(myDir));
            }catch (IOException e){}
        }catch (AWTException e){}
    }
}
