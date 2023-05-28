package com.createarm.view;

import com.createarm.swing.component.SpringPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainWindow extends JFrame {

    @Autowired
    public MainWindow(SpringPanel springPanel) {
        super("Выбор таблицы");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 600;
        int height = 600;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(width, height);
        this.setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);
        this.add(springPanel);
        this.setVisible(true);
    }
}
