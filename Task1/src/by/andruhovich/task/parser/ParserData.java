package by.andruhovich.task.parser;

import by.andruhovich.task.validation.ValidationData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ParserData {

    private static final Logger LOGGER = LogManager.getLogger(ParserData.class);

    ArrayList<double[]> convertListOfStringArrayToListOfDoubleArray(ArrayList<String> dataList) throws NullPointerException {
        ArrayList<double[]> result = new ArrayList<>();
        ValidationData validationData = new ValidationData();
        int numberOfUnfixedString = -1;
        StringBuffer temp = new StringBuffer();
        String[] parseData = null;

        for (int i = 0; i < dataList.size(); i++) {
            parseData = parseString(dataList.get(i), " ");
            if (validationData.isRightString(dataList.get(i)) && parseData.length >= 8) {
                result.add(convertStringArrayToDoubleArray(parseData));
            }
            else {
                if (parseData.length < 8) {
                    LOGGER.printf(Level.WARN, "Not enough arguments in line number " + i);
                }
                else if (numberOfUnfixedString != i) {
                    numberOfUnfixedString = i;
                    temp.append(deleteUnCorrectSymbols(dataList.get(i)));
                    dataList.remove(i);
                    dataList.add(i, temp.toString());
                    i --;
                    LOGGER.printf(Level.INFO, "Attempt to correct the line number " + i);
                }
                else {
                    LOGGER.printf(Level.WARN, "Attempt to correct the line number " + i + "wasn't succeeded");
                }
            }
        }
        if (result.isEmpty()) {
            LOGGER.printf(Level.FATAL, "There are no correct lines in file");
            throw new NullPointerException();
        }

        return result;
    }

    private String deleteUnCorrectSymbols(String data) {
        return data.replaceAll("[^\\d.]", "");
    }

    public static String[] parseString(String data, String devider) {
        return data.split(devider);
    }
    public double[] convertStringArrayToDoubleArray (String[] data) {
        double[] result = new double[8];

        for(int i = 0; i < 8; i++) {
            result[i] = Double.parseDouble(data[i]);
        }

        return result;
    }
}
