package by.andruhovich.task.filter;

import by.andruhovich.task.exception.IllegalDataQuantityTechnicalException;
import by.andruhovich.task.parser.ParserData;
import by.andruhovich.task.validator.ValidatorData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FilterData {
    private static final Logger LOGGER = LogManager.getLogger(FilterData.class);

    public void filterDataByLetters(ArrayList<String> dataList) {
        if (dataList == null) {
            throw new IllegalArgumentException();
        }

        ValidatorData validatorData = new ValidatorData();
        int numberOfUnfixedString = -1;
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < dataList.size(); i++) {
            if (!validatorData.isRightString(dataList.get(i))) {
                if (numberOfUnfixedString != i) {
                    numberOfUnfixedString = i;
                    buffer.append(deleteLettersFromString(dataList.get(i), "[^\\d|.|-]"));
                    dataList.remove(i);
                    dataList.add(i, buffer.toString());
                    i--;
                    LOGGER.log(Level.INFO, "Attempt to correct the line number " + i);
                } else {
                    dataList.remove(i);
                    LOGGER.log(Level.WARN, "Attempt to correct the line number " + i + "wasn't succeeded");
                }
            }
        }
        if (dataList.isEmpty()) {
            LOGGER.log(Level.FATAL, "There are no correct lines in file");
            throw new RuntimeException();
        }
    }

    public void filterDataByQuantity(ArrayList<String> dataList, int dataQuantity, String delimiter) throws IllegalDataQuantityTechnicalException {
        if (dataList == null || delimiter == null) {
            throw new IllegalArgumentException();
        }
        if (dataQuantity <= 0) {
            throw new IllegalDataQuantityTechnicalException("Quantity of data cannot be <=0 ");
        }

        ArrayList<String> parseData;
        ParserData parserData = new ParserData();

        for (int i = 0; i < dataList.size(); i++) {
            parseData = parserData.parseString(dataList.get(i), delimiter);
            if (parseData.size() < dataQuantity) {
                dataList.remove(i);
                LOGGER.log(Level.WARN, "Not enough arguments in line number " + i);
            }
        }

        if (dataList.isEmpty()) {
            LOGGER.log(Level.FATAL, "There are no correct lines in file");
            throw new RuntimeException();
        }
    }

    public String deleteLettersFromString(String data, String letters) {
        return data.replaceAll(letters, "");
    }
}
