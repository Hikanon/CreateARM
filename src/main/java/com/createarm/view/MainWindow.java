package com.createarm.view;

import com.createarm.controller.TableController;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class MainWindow extends JFrame {

    private final TableController tableController;

    public MainWindow(TableController tableController) {
        super("Main Window");
        this.tableController = tableController;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
    }
}
