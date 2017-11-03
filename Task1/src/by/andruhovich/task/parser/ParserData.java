package by.andruhovich.task.parser;

import java.util.ArrayList;

public class ParserData {

    public ArrayList<String> parseString(String data, String delimiter) {
        if (data == null || delimiter == null) {
            throw new IllegalArgumentException();
        }

        ArrayList<String> dataList = new ArrayList<>();
        String[] parseString = data.split(delimiter);
        for (int i = 0; i < parseString.length; i++) {
            dataList.add(parseString[i]);
        }
        return dataList;
    }
}
