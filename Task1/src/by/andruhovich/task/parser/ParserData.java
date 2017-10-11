package by.andruhovich.task.parser;

import by.andruhovich.task.validation.ValidationData;

import java.util.ArrayList;

public class ParserData {
    ArrayList<double[]> convertListOfStringArrayToListOfDoubleArray(ArrayList<String> data) throws RuntimeException {
        ArrayList<double[]> result = new ArrayList<>();
        ValidationData validationData = new ValidationData();
        int numberOfUnfixedString = -1;
        StringBuffer temp = new StringBuffer();
        String[] parseData = null;

        for (int i = 0; i < data.size(); i++) {
            parseData = parseString(data.get(i), " ");
            if (validationData.isRightString(data.get(i)) && parseData.length >= 8) {
                result.add(convertStringArrayToDoubleArray(parseData));
            }
            else {
                if (parseData.length < 8) {

                }
                else if (numberOfUnfixedString != i) {
                    numberOfUnfixedString = i;
                    temp.append(deleteUncorrectSymbols(data.get(i)));
                    data.remove(i);
                    data.add(i, temp.toString());
                    i --;
                }
            }
        }
        if (validationData.isListEmpty(result)) throw new RuntimeException();

        return result;
    }

    private String deleteUncorrectSymbols(String data) {
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
