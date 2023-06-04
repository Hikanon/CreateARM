package com.createarm.util;

import java.util.Collection;

public class ParceData {

    public static Object[][] parseDataArray(Collection<?> data, Collection<String> fields) {
        Object[][] result = new Object[data.size()][fields.size()];

        int row = 0;
        for (Object object : data) {
            String[] parts = object.toString().split("\\|");
            int column = 0;
            for (String field : fields) {
                for (String part : parts) {
                    String[] keyValue = part.split("=");
                    if (field.equals(keyValue[0])) {
                        result[row][column] = keyValue[1];
                        break;
                    }
                }
                column++;
            }
            row++;
        }
        return result;
    }

}
