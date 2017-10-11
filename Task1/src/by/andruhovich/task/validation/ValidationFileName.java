package by.andruhovich.task.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidationFileName {
    private static final Logger LOGGER = LogManager.getLogger(ValidationFileName.class);

    public boolean isRightFilename(String filename) {
        String extension = new String();
        try {
            extension = filename.substring(filename.length() - 5, filename.length());
        }
        catch (IndexOutOfBoundsException e) {
            LOGGER.printf(Level.WARN, "Filename " + filename + " has no extension");
            return false;
        }
        return extension.compareTo(".txt") == 0;
    }
}
