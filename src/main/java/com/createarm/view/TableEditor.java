package com.createarm.view;

import com.createarm.configuration.AppConfig;
import com.createarm.controller.TableEditorController;
import com.createarm.util.ParceData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

final public class TableEditor extends JFrame {

    private final TableEditorController tableEditorController;
    private final JTable table;
    private final String tableName;

    public TableEditor(String tableName, TableEditorController tableEditorController) {
        this.tableName = tableName;
        this.setIconImage(AppConfig.getImage());
        this.tableEditorController = tableEditorController;
        this.setTitle("Редактор таблицы %s".formatted(this.tableName));
        int width = 600, height = 600;
        this.setSize(width, height);

        Collection<String> fields = tableEditorController.getAllTableFields(tableName);
        this.table = new JTable(new DefaultTableModel(
                ParceData.parseDataArray(
                        tableEditorController.getAllByTableName(tableName), fields), fields.toArray())) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel selectedLabel = new JLabel("Выбрано:");
        JLabel currentSelectionLabel = new JLabel("");
        currentSelectionLabel.setAutoscrolls(true);
        bottomPanel.add(selectedLabel);
        bottomPanel.add(currentSelectionLabel);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        JButton addButton = new JButton("Добавить");
        addButton.addActionListener(e -> new AddEditRowDialog(fields, this, true, true));

        JButton editButton = new JButton("Редактировать");
        editButton.setVisible(false);
        editButton.addActionListener(e -> new AddEditRowDialog(fields, this, true, false));

        JButton deleteButton = new JButton("Удалить");
        deleteButton.setVisible(false);
        deleteButton.addActionListener(e -> new DeleteDialog(this, true));

        table.getSelectionModel().addListSelectionListener(e -> {
            String result = "id: ";
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                table.getSelectionModel().setSelectionInterval(selectedRow, selectedRow);
                result += table.getModel().getValueAt(selectedRow, 0);
                currentSelectionLabel.setText(result);
                editButton.setVisible(true);
                deleteButton.setVisible(true);
            }
        });
        JToolBar toolBar = new JToolBar();
        toolBar.add(addButton);
        toolBar.add(editButton);
        toolBar.add(deleteButton);

        mainPanel.add(toolBar, BorderLayout.PAGE_START);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        this.getContentPane().add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    final class AddEditRowDialog extends JDialog {

        public AddEditRowDialog(Collection<String> fields, Frame owner, boolean modal, boolean addRow) {
            super(owner, modal);
            this.setIconImage(AppConfig.getImage());
            this.setResizable(false);
            this.setTitle("Создание новой строки");
            this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridLayout(fields.size(), 2, 15, 30));

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(screenSize.width / 2 - 100, screenSize.height / 2 - 100);

            Map<String, JComponent> components = new HashMap<>();
            int selectedRow = table.getSelectedRow();
            for (String field : fields) {
                mainPanel.add(new JLabel(field));
                int fieldId = table.getColumnModel().getColumnIndex(field);
                if (field.contains("id_")) {
                    JComboBox<Integer> combo = new JComboBox<>(new Vector<>(
                            tableEditorController.getAllTableId(field.substring(3))
                    ));
                    if (!addRow) {
                        combo.getModel().setSelectedItem(table.getValueAt(selectedRow, fieldId));
                    }
                    components.put(field, combo);
                    mainPanel.add(combo);
                } else {
                    JTextField textField = new JTextField(field);
                    components.put(field, textField);
                    if (!addRow) {
                        textField.setText(String.valueOf(table.getValueAt(selectedRow, fieldId)));
                    }
                    mainPanel.add(textField);
                }
            }
            JToolBar toolBar = new JToolBar();
            JButton addButton = new JButton("Сохранить");
            addButton.addActionListener(e -> {
                Object[] newRow = new Object[fields.size()];
                int iter = 0;
                for (String field : fields) {
                    JComponent component = components.get(field);
                    if (component instanceof JTextField) {
                        newRow[iter] = ((JTextField) component).getText();
                    }
                    if (component instanceof JComboBox) {
                        newRow[iter] = ((JComboBox<?>) component).getSelectedItem();
                    }
                    iter++;
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                if (!addRow) {
                    model.removeRow(selectedRow);
                    model.insertRow(selectedRow, newRow);
                } else {
                    model.addRow(newRow);
                }
                tableEditorController.saveEntity(tableName, newRow, fields);
                this.dispose();
            });
            toolBar.add(addButton);
            this.add(toolBar, BorderLayout.PAGE_START);
            this.getContentPane().add(mainPanel, BorderLayout.CENTER);
            this.pack();
            this.setVisible(true);
        }
    }

    final class DeleteDialog extends JDialog {

        public DeleteDialog(Frame owner, boolean modal) {
            super(owner, modal);
            this.setIconImage(AppConfig.getImage());
            this.setTitle("Удаление строки");
            this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            this.setResizable(false);

            JPanel mainPanel = new JPanel(new BorderLayout());
            JLabel infoLabel = new JLabel("Вы уверены что хотите удалить выбранную строку?");
            JButton okButton = new JButton("Удалить");
            JButton cancelButton = new JButton("Отмена");

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(okButton);
            buttonPanel.add(cancelButton);

            mainPanel.add(infoLabel, BorderLayout.CENTER);
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);

            cancelButton.addActionListener(e -> this.dispose());
            okButton.addActionListener(e -> {
                int selectedRow = table.getSelectedRow();
                int id = table.getColumnModel().getColumnIndex("id");
                int value = Integer.parseInt(table.getValueAt(selectedRow, id).toString());
                tableEditorController.deleteEntity(tableName, value);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);
                this.dispose();
            });
            this.getContentPane().add(mainPanel);

            Dimension mainPanelSize = mainPanel.getSize();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(screenSize.width / 2 - mainPanelSize.width / 2, screenSize.height / 2 - mainPanelSize.height / 2);

            this.pack();
            this.setVisible(true);
        }

    }
}
