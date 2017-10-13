package by.andruhovich.task.parser;

import by.andruhovich.task.exception.QuantityOfDataTechnicalException;
import by.andruhovich.task.validation.ValidationData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Filter {
    private static final Logger LOGGER = LogManager.getLogger();

    public void filterDataByLetters(ArrayList<String> dataList) {
        if (dataList == null) {
            throw new IllegalArgumentException();
        }

        ValidationData validationData = new ValidationData();
        int numberOfUnfixedString = -1;
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < dataList.size(); i++) {
            if (!validationData.isRightString(dataList.get(i))) {
                if (numberOfUnfixedString != i) {
                    numberOfUnfixedString = i;
                    buffer.append(deleteLettersFromString(dataList.get(i), "[^\\d.]"));
                    dataList.remove(i);
                    dataList.add(i, buffer.toString());
                    i--;
                    LOGGER.printf(Level.INFO, "Attempt to correct the line number " + i);
                } else {
                    dataList.remove(i);
                    LOGGER.printf(Level.WARN, "Attempt to correct the line number " + i + "wasn't succeeded");
                }
            }
        }
        if (dataList.isEmpty()) {
            LOGGER.printf(Level.FATAL, "There are no correct lines in file");
            throw new RuntimeException();
        }
    }

    public void filterDataByNumberQuantity(ArrayList<String> dataList, int numberQuantity, String delimiter) throws QuantityOfDataTechnicalException {
        if (dataList == null || delimiter == null) {
            throw new IllegalArgumentException();
        }
        if (numberQuantity <= 0) {
            throw new QuantityOfDataTechnicalException("Quantity of data cannot be <=0 ", numberQuantity);
        }

        ArrayList<String> parseData = new ArrayList<>();
        ParserData parserData = new ParserData();

        for (int i = 0; i < dataList.size(); i++) {
            parseData = parserData.parseString(dataList.get(i), delimiter);
            if (parseData.size() < numberQuantity) {
                dataList.remove(i);
                LOGGER.printf(Level.WARN, "Not enough arguments in line number " + i);
            }
        }

        if (dataList.isEmpty()) {
            LOGGER.printf(Level.FATAL, "There are no correct lines in file");
            throw new RuntimeException();
        }
    }

    public String deleteLettersFromString(String data, String letters) {
        return data.replaceAll(letters, "");
    }
}
