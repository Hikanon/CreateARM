package com.createarm.swing.component;

import com.createarm.controller.DataBaseInfoController;
import com.createarm.util.TableEditorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

@Component
public class SpringPanel extends JPanel {

    @Autowired
    public SpringPanel(TableEditorFactory tableEditorFactory, DataBaseInfoController dataBaseInfoController) {
        this.setLayout(new GridLayout(3, 1, 15, 30));
        JLabel chooseTableLabel = new JLabel("Выберете таблицу");
        chooseTableLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(chooseTableLabel, BorderLayout.CENTER);

        JComboBox<String> jComboBox = new JComboBox<>();
        Collection<String> allTables = dataBaseInfoController.getAllTables("public");
        for (String s : allTables) {
            jComboBox.addItem(s);
        }

        this.add(jComboBox);
        JButton openTable = new JButton("Открыть таблицу");
        openTable.addActionListener((event) -> tableEditorFactory.getTableEditorInstance((String) jComboBox.getSelectedItem()).setVisible(true));
        this.add(openTable);
    }
}
