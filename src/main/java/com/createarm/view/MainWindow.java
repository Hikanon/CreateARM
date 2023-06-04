package com.createarm.view;

import com.createarm.configuration.AppConfig;
import com.createarm.swing.component.SpringPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
final public class MainWindow extends JFrame {

    @Autowired
    public MainWindow(final SpringPanel springPanel) {
        super("Выбор таблицы");
        this.setIconImage(AppConfig.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width / 2 - 100, screenSize.height / 2 - 100);
        this.getContentPane().add(springPanel);
        this.pack();
        this.setVisible(true);

    }
}
