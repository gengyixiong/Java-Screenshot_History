package me.gengyixiong.util;

import me.gengyixiong.gui.WindowsGUI;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gengyixiong on 4/4/2015.
 */
public class FileName {
    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    String rootDir;

    public String createFileName(){
        new File(rootDir + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).mkdir();
        String fileName = rootDir + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "\\" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.bmp'").format(new Date());
        return fileName;
    }
}
