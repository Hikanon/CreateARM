package com.createarm.util;

import com.createarm.controller.TableEditorController;
import com.createarm.view.TableEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableEditorFactory {

    private final TableEditorController tableEditorController;

    @Autowired
    public TableEditorFactory(TableEditorController tableEditorController) {
        this.tableEditorController = tableEditorController;
    }

    public TableEditor getTableEditorInstance(String tableName) {
        return new TableEditor(tableName, tableEditorController);
    }

}
