package com.createarm.view;

import com.createarm.controller.TableEditorController;
import com.createarm.model.BaseEntity;
import com.createarm.util.DatabaseUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Collection;
import java.util.Vector;

public class TableEditor extends JFrame {

    public TableEditor(String tableName, TableEditorController tableEditorController) {

        this.setTitle("Редактор таблицы %s".formatted(tableName));
        int width = 600, height = 600;
        this.setSize(width, height);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);

        JpaRepository<?, Integer> mainRepository = tableEditorController.getJpaRepositoryByTableName(tableName);

        Collection<?> data = mainRepository.findAll();
        Collection<String> fields = tableEditorController.getAllTableFields(tableName);

        TableModel tableModel = new DefaultTableModel(DatabaseUtils.parseDataToTwoDimensionalArray(data, fields), fields.toArray());

        JTable table = new JTable(tableModel);

        for (String field : fields) {
            if (field.contains("id_")) {
                Collection<Integer> id = tableEditorController.getJpaRepositoryByTableName(field.substring(3)).findAll().stream()
                        .map(BaseEntity::getId).toList();
                JComboBox<Integer> combo = new JComboBox<>(new Vector<>(id));
                table.getColumn(field).setCellEditor(new DefaultCellEditor(combo));
            }
        }

        this.add(new JScrollPane(table));
        this.setVisible(true);
    }

}
