package by.andruhovich.test;

import by.andruhovich.task.filter.FilterData;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FilterDataTest {
    private ArrayList<String> dataList;
    private ArrayList<String> resultDataList;

    private FilterData filterData;

    @BeforeSuite
    public void setFilter(){
        filterData = new FilterData();
    }

    @BeforeGroups("DataList")
    public void setDataList() {
        dataList = new ArrayList<>();
        resultDataList = new ArrayList<>();

        dataList.add("234. 4534fd fg");
        dataList.add(".  ");
        dataList.add("23.45 -45.3");

        resultDataList.add("234.4534");
        resultDataList.add("23.45 -45.3");
    }

    @BeforeGroups("Quantity")
    public void quantity() {
        dataList = new ArrayList<>();
        resultDataList = new ArrayList<>();

        dataList.add("234. 4534fd fg 3 5 32 -5.2 4");
        dataList.add(".  ");
        dataList.add("23.45 -45.3 3.6 4 56 23 5 3 4 dfg  54 2 35 4");

        resultDataList.add("234.4534");
        resultDataList.add("23.45 -45.3");
    }

    @Test
    public void firstTestDeleteLettersFromString() {
        Assert.assertEquals(filterData.deleteLettersFromString("123,rh  435rergf  ", "\\s"), "123,rh435rergf");
    }

    @Test
    public void secondTestDeleteLettersFromString() {
        Assert.assertEquals(filterData.deleteLettersFromString("123,rh  435rergf  ", "[\\d]"), ",rh  rergf  ");
    }

    @Test
    public void thirdTestDeleteLettersFromString() {
        Assert.assertEquals(filterData.deleteLettersFromString("-123.7,rh  435rergf  ", "[^\\d|.|-]"), "-123.7435");
    }

    @Test
    public void negativeTestDeleteLettersFromString() {
        Assert.assertEquals(filterData.deleteLettersFromString("", ""), "");
    }

    @Test(groups = "DataList")
    public void firstTestFilterDataByLetters() {
        filterData.filterDataByLetters(dataList);
        Assert.assertEquals(dataList, resultDataList);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeFilterDataByLetters() {
        filterData.filterDataByLetters(null);
    }

    @AfterGroups("DataList")
    public void clearDataList() {
        dataList.clear();
    }

}
