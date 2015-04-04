package me.gengyixiong.gui;

import me.gengyixiong.util.FileName;
import me.gengyixiong.util.ScreenshotTimerTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Gengyixiong on 4/4/2015.
 */
public class WindowsGUI {

    JFrame frame = new JFrame("Auto Screenshot History");
    JButton startButton = new JButton("START");
    JButton stopButton = new JButton("STOP");
    JButton setButton = new JButton("SET");

    JRadioButton allMoniterChoice = new JRadioButton("All Moniter", true);
    JRadioButton mainMoniterOnlyChoice = new JRadioButton("Main Monitor Only", false);
    ButtonGroup allOrMainRadioButtonGroup = new ButtonGroup();
    String[] intervals = new String[]{"10 min", "20 min", "30 min"};
    JComboBox<String> timeIntervalBox = new JComboBox<>(intervals);
    JTextField rootDirTextField = new JTextField("D:\\", 25);

    public void initGUI(){
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        allOrMainRadioButtonGroup.add(allMoniterChoice);
        allOrMainRadioButtonGroup.add(mainMoniterOnlyChoice);
        topPanel.add(allMoniterChoice);
        topPanel.add(mainMoniterOnlyChoice);
        topPanel.add(timeIntervalBox);
        centerPanel.add(rootDirTextField);

        bottomPanel.add(setButton);
        bottomPanel.add(startButton);
        bottomPanel.add(stopButton);


        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FileName().setRootDir(rootDirTextField.getText());

                int comboxIndex = timeIntervalBox.getSelectedIndex();
                if (comboxIndex == 0) {
                    new ScreenshotTimerTask().setTimeInterval(60 * 10 * 1000);
                } else if (comboxIndex == 1) {
                    new ScreenshotTimerTask().setTimeInterval(2 * 60 * 10 * 1000);
                } else {
                    new ScreenshotTimerTask().setTimeInterval(3 * 60 * 10 * 1000);
                }

                if (mainMoniterOnlyChoice.isSelected()) {
                    new ScreenshotTimerTask().setAllOrMainMonitor(0);
                } else {
                    new ScreenshotTimerTask().setAllOrMainMonitor(1);
                }
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenshotTimerTask().startScreenShot();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScreenshotTimerTask().stopScreenShot();
            }
        });
    }
}
