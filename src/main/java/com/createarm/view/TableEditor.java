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

    private final TableEditorController tableEditorController;
    private final JTable table;

    public TableEditor(String tableName, TableEditorController tableEditorController) {
        this.tableEditorController = tableEditorController;
        this.setTitle("Редактор таблицы %s".formatted(tableName));
        int width = 600, height = 600;
        this.setSize(width, height);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);

        JpaRepository<?, Integer> mainRepository = tableEditorController.getJpaRepositoryByTableName(tableName);
        Collection<String> fields = tableEditorController.getAllTableFields(tableName);

        this.table = new ImmutableTable(new DefaultTableModel(
                DatabaseUtils.parseDataToTwoDimensionalArray(
                        mainRepository.findAll(), fields), fields.toArray()));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> new TableEditorDialog(fields));
        JButton editButton = new JButton("Edit");
        editButton.setVisible(false);

        JToolBar toolBar = new JToolBar();
        toolBar.add(addButton);
        toolBar.add(editButton);
        this.add(toolBar, BorderLayout.PAGE_START);
        this.add(new JScrollPane(table));
        this.setVisible(true);
    }


    static class ImmutableTable extends JTable {

        public ImmutableTable(TableModel dm) {
            super(dm);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    class TableEditorDialog extends JDialog {

        public TableEditorDialog(Collection<String> fields) {
            this.setLayout(new GridLayout(fields.size() + 1, 2, 15, 20));
            this.setResizable(false);
            for (String field : fields) {
                this.add(new JLabel(field));
                if (field.contains("id_")) {
                    JComboBox<Integer> combo = new JComboBox<>(new Vector<>(
                            tableEditorController
                                    .getJpaRepositoryByTableName(field.substring(3))
                                    .findAll()
                                    .stream()
                                    .map(BaseEntity::getId)
                                    .toList()
                    ));
                    this.add(combo);
                } else {
                    this.add(new JTextField(field));
                }
            }
            JButton addButton = new JButton("Add");
            addButton.addActionListener(e -> {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{11, 2});
                this.dispose();
            });
            this.add(addButton, BorderLayout.NORTH);
            this.pack();
            this.setVisible(true);
        }
    }
}
