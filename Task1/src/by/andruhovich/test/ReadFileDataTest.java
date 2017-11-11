package by.andruhovich.test;

import by.andruhovich.task.reader.ReadFileData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;

public class ReadFileDataTest {
    private String filename;
    private ReadFileData readFileData;
    private Locale locale;
    private static final Logger LOGGER = LogManager.getLogger(by.andruhovich.task.reader.ReadFileData.class);
    private ArrayList<String> dataIn;

    @BeforeSuite
    public void intialization() {
        readFileData = new ReadFileData();
        locale = new Locale("en", "en");
        filename = "dataTest.txt";

        FileWriter fileWriter = null;
        File file = new File(filename);

        dataIn = new ArrayList<>();
        dataIn.add("12 34 2 -5 4.6 7 -54   6");
        dataIn.add("12 34 2 -5dsfg 4.6 7 -54 6");
        dataIn.add("12 34 2,7");
        dataIn.add(" 12 34 2ert -5 4.6 7 -54 6");

        try {
           fileWriter = new FileWriter(file);
           fileWriter.write("12 34 2 -5 4.6 7 -54   6\n");
           fileWriter.write("12 34 2 -5dsfg 4.6 7 -54 6\n");
           fileWriter.write("12 34 2,7\n ");
           fileWriter.write("12 34 2ert -5 4.6 7 -54 6\n");

        } catch (IOException e) {
            LOGGER.log(Level.FATAL, e.getMessage());
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                LOGGER.log(Level.FATAL, e.getMessage());
            }
        }
    }

    @BeforeGroups("Negative")
    public void negativeInitialization() {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
           LOGGER.log(Level.FATAL, e.getMessage());
        }
    }

    @Test
    public void firstTestReadFileData() {
        Assert.assertEquals(readFileData.readData(filename, locale), dataIn);
    }

    @Test (groups =  "Negative", expectedExceptions = RuntimeException.class)
    public void negativeTestReadFileData() {
        readFileData.readData(filename, locale);
    }

    @AfterSuite
    public void clearAll() {
        dataIn = null;
    }
}
