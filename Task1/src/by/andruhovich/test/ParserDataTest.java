package by.andruhovich.test;

import by.andruhovich.task.parser.ParserData;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ParserDataTest {
    private ParserData parserData = new ParserData();
    private ArrayList<String> result;

    @BeforeSuite
    public void setParserData() {
        parserData = new ParserData();
    }

    @BeforeGroups("ParseString")
    public void setResult() {
        result = new ArrayList<>();

        result.add("123");
        result.add("43");
        result.add("2");
    }

    @Test(groups = "ParseString")
    public void firstTestParseString() {
        Assert.assertEquals(parserData.parseString("123 43 2", " "), result);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativetestParseString() {
        parserData.parseString(null, "34");
    }

    @AfterSuite
    public void clearAll() {
        parserData = null;
        result = null;
    }
}
