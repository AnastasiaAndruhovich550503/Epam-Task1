package by.andruhovich.task.parser;

import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.exception.QuantityOfDataTechnicalException;
import by.andruhovich.task.validation.ValidationData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParserData {

    private static final Logger LOGGER = LogManager.getLogger();

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

    ArrayList<double[]> parseListOfStringArrayToListOfDoubleArray(ArrayList<String> dataList) {
        if (dataList == null) {
            throw new IllegalArgumentException();
        }

        ArrayList<double[]> result = new ArrayList<>();
        ArrayList<String> parseString;
        Filter filter = new Filter();

        filter.filterDataByLetters(dataList);
        try {
            filter.filterDataByNumberQuantity(dataList, 8, "\\s");
        } catch (QuantityOfDataTechnicalException e){
            LOGGER.printf(Level.ERROR, e.getMessage());
            return null;
        }

        for (int i = 0; i < dataList.size(); i++) {
            parseString = parseString(dataList.get(i), "\\s");
            result.add(parseStringArrayToDoubleArray(parseString));
        }

        return result;
    }

    public double[] parseStringArrayToDoubleArray(ArrayList<String> dataList) {
        if (dataList == null) {
            throw new IllegalArgumentException();
        }

        double[] result = new double[8];

        for (int i = 0; i < 8; i++) {
            result[i] = Double.parseDouble(dataList.get(i));
        }
        return result;
    }
}
