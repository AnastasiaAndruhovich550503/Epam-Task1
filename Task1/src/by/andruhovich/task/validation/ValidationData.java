package by.andruhovich.task.validation;

import by.andruhovich.task.parser.ParserData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ValidationData {

    private static final Logger LOGGER = LogManager.getLogger(ValidationData.class);

    public boolean isRightString(String data) {
        if (data.isEmpty()) return false;

        String[] parseData = ParserData.parseString(data, " ");
        try {
            for (int i = 0; i < parseData.length; i++) {
                Double.parseDouble(parseData[i]);
            }
        } catch (NumberFormatException e) {
            LOGGER.printf(Level.WARN, "Found wrong string " + data);
            return false;
        }
        return true;
    }
}
