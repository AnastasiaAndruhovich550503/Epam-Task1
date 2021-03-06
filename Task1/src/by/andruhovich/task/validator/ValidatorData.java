package by.andruhovich.task.validator;

import by.andruhovich.task.parser.ParserData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ValidatorData {

    private static final Logger LOGGER = LogManager.getLogger(ValidatorData.class);

    public boolean isRightString(String data) {
        if (data.isEmpty()) {
            return false;
        }

        ParserData parserData = new ParserData();

        ArrayList<String> parseData = parserData.parseString(data, " ");
        try {
            for (int i = 0; i < parseData.size(); i++) {
                Double.parseDouble(parseData.get(i));
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.ERROR, "Found wrong string " + data);
            return false;
        }
        return true;
    }
}
