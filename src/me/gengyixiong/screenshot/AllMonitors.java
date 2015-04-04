package me.gengyixiong.screenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Gengyixiong on 4/4/2015.
 */
public class AllMonitors {
    public void createScreenshot(String myDir){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();

        Rectangle allScreenBounds = new Rectangle();
        for (GraphicsDevice screen : screens){
            Rectangle screenBounds = screen.getDefaultConfiguration().getBounds();
            allScreenBounds.width += screenBounds.width;
            allScreenBounds.height = Math.max(allScreenBounds.height, screenBounds.height);
        }
        try {
            BufferedImage capture = new Robot().createScreenCapture(allScreenBounds);
            try {
                ImageIO.write(capture, "bmp", new File(myDir));
            }catch (IOException e){}
        }catch (AWTException e){}
    }
}
