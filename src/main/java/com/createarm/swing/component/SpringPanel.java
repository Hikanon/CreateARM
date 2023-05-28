package com.createarm.swing.component;

import com.createarm.controller.DataBaseInfoController;
import com.createarm.util.TableEditorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Collection;

@Component
public class SpringPanel extends JPanel {

    private final TableEditorFactory tableEditorFactory;
    private final DataBaseInfoController dataBaseInfoController;

    @Autowired
    public SpringPanel(TableEditorFactory tableEditorFactory, DataBaseInfoController dataBaseInfoController) {
        this.tableEditorFactory = tableEditorFactory;
        this.dataBaseInfoController = dataBaseInfoController;

        this.add(new JLabel("Выберете таблицу"));

        JComboBox<String> jComboBox = new JComboBox<>();
        Collection<String> allTables = this.dataBaseInfoController.getAllTables("public");
        for (String s : allTables) {
            jComboBox.addItem(s);
        }

        this.add(jComboBox);
        JButton openTable = new JButton("Открыть таблицу");
        openTable.addActionListener((event) -> tableEditorFactory.getTableEditorInstance((String) jComboBox.getSelectedItem()).setVisible(true));
        this.add(openTable);
    }
}
