package me.gengyixiong.util;

import me.gengyixiong.screenshot.AllMonitors;
import me.gengyixiong.screenshot.MainMonitorOnly;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Gengyixiong on 4/4/2015.
 */
public class ScreenshotTimerTask extends TimerTask{
    int timeInterval;
    int allOrMainMonitor;
    Timer timer = new Timer();

    public void setAllOrMainMonitor(int allOrMainMonitor) {
        this.allOrMainMonitor = allOrMainMonitor;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    @Override
    public void run() {
        if (allOrMainMonitor == 0) {
            new MainMonitorOnly().createScreenshot(new FileName().createFileName());
        }else {
            new AllMonitors().createScreenshot(new FileName().createFileName());
        }
    }

    public void startScreenShot(){
        timer.schedule(new ScreenshotTimerTask(), 0, timeInterval);
    }

    public void stopScreenShot(){
        timer.cancel();
        timer.purge();
    }
}
