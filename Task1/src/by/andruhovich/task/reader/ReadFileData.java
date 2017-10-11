package by.andruhovich.task.reader;

import by.andruhovich.task.validation.ValidationFileName;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ReadFileData {
    private String defaultFilename = "D:\\учебники\\курсы Java\\лаба 1\\Epam-Task1\\Task1\\data";

    public ArrayList<String> readData(String filename, Locale locale) throws FileNotFoundException{
        ArrayList<String> dataList = new ArrayList<>();
        ValidationFileName validationFileName = new ValidationFileName();
        Scanner scanner = null;

        if (!validationFileName.isRightFilename(filename)) filename = defaultFilename;

        try {
            scanner = new Scanner(new File(filename));
            scanner.useLocale(locale);

            while (scanner.hasNext()) {
                dataList.add(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + filename + "not found.");
        }
        finally {
            scanner.close();
        }
        return dataList;
    }

}
