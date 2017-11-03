package by.andruhovich.task.reader;

import by.andruhovich.task.validator.ValidatorFileName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ReadFileData {
    private String defaultFilename = "data.txt";
    private static final Logger LOGGER = LogManager.getLogger(ReadFileData.class);

    public ArrayList<String> readData(String filename, Locale locale) {
        ArrayList<String> dataList = new ArrayList<>();
        ValidatorFileName validatorFileName = new ValidatorFileName();
        Scanner scanner = null;

        if (!validatorFileName.isRightFilename(filename)) {
            LOGGER.log(Level.WARN, "File " + filename + " has wrong extension. Filename will be replaced " +
                    "with default name " + defaultFilename);
            filename = defaultFilename;
        }

        try {
            scanner = new Scanner(new File(filename));
            scanner.useLocale(locale);

            while (scanner.hasNext()) {
                dataList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.FATAL, "File " + filename + "not found.");
            throw new RuntimeException();
        } finally {
            scanner.close();
        }

        if (dataList.isEmpty()) {
            LOGGER.log(Level.FATAL, "File " + filename + "is empty.");
            throw new RuntimeException();
        }
        return dataList;
    }
}
