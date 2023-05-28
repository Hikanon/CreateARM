package com.createarm.view;

import com.createarm.controller.TableEditorController;
import com.createarm.util.DatabaseUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Collection;

public class TableEditor extends JFrame {

    private final TableEditorController tableEditorController;

    public TableEditor(String tableName, TableEditorController tableEditorController) {
        this.tableEditorController = tableEditorController;

        this.setTitle("Редактор таблицы %s".formatted(tableName));
        int width = 600, height = 600;
        this.setSize(width, height);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);

        JpaRepository<?, Integer> mainRepository = tableEditorController.getJpaRepositoryByTableName(tableName);

        Collection<?> data = mainRepository.findAll();
        Collection<String> fields = tableEditorController.getAllTableFields(tableName);

        TableModel tableModel = new DefaultTableModel(DatabaseUtils.parseDataToTwoDimensionalArray(data, fields), fields.toArray());
        JComboBox<String> combo = new JComboBox<>();
        JTable table = new JTable(tableModel);

        int iter = 0;
        for (String field : fields) {
            if (field.contains("id_")) {
                table.getColumn(field).setCellEditor(new DefaultCellEditor(combo));
            }
        }

        this.add(new JScrollPane(table));
        this.setVisible(true);
    }

}
