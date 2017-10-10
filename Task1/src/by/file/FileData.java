package by.file;

import by.bsu.task.exception.FileNotExistException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileData {
    //private String fileName = "data/data.txt";

    public ArrayList<String> readData(String fileName) throws FileNotExistException{
        ArrayList<String> dataList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.useLocale(new Locale("en", "en"));

            while (scanner.hasNext()) {
                dataList.add(scanner.nextLine());
            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            throw new FileNotExistException("File " + fileName + " not found");
        }
        return dataList;
    }

}
