package by.andruhovich.task.reader;

import by.andruhovich.task.validation.ValidationFileName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFileData {
    private String defaultFilename = "D:\\учебники\\курсы Java\\лаба 1\\Epam-Task1\\Task1\\data";
    private static final Logger LOGGER = LogManager.getLogger();

    public ArrayList<String> readData(String filename, Locale locale) {
        ArrayList<String> dataList = new ArrayList<>();
        ValidationFileName validationFileName = new ValidationFileName();
        Scanner scanner = null;

        if (!validationFileName.isRightFilename(filename)) {
            LOGGER.printf(Level.WARN, "File " + filename + " has wrong extension. Filename will be replaced " +
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
            LOGGER.printf(Level.FATAL, "File " + filename + "not found.");
            throw new RuntimeException();
        } catch (NoSuchElementException e) {
            LOGGER.printf(Level.FATAL, "File " + filename + "is empty.");
            throw new RuntimeException();
        }finally {
            scanner.close();
        }
        return dataList;
    }

}
