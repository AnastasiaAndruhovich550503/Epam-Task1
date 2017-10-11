package by.andruhovich.task.validation;

import by.andruhovich.task.parser.ParserData;

import java.util.ArrayList;

public class ValidationData {
    public boolean isRightString(String data) {
        if (data.isEmpty()) return false;

        String[] parseData = ParserData.parseString(data, " ");
        try {
            for(int i = 0; i < parseData.length; i++) {
                Double.parseDouble(parseData[i]);
            }
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isListEmpty(ArrayList<double[]> listData) {
        return listData.isEmpty();
    }
}
