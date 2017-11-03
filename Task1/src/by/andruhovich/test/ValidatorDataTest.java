package by.andruhovich.test;

import by.andruhovich.task.validator.ValidatorData;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ValidatorDataTest {
    private ValidatorData validatorData;

    @BeforeSuite
    public void fieldInitialization() {
        validatorData = new ValidatorData();
    }

    @Test
    public void firstTestValidationData() {
        Assert.assertTrue(validatorData.isRightString("1.2 3.2 -5.2 -4.234 43.6 -65.0 2.4 8.9"));
    }

    @Test
    public void secondTestValidationData() {
        Assert.assertFalse(validatorData.isRightString("1.2 fgv3.2 -5.2 -4.234dfrg 43.6 -65.0 2.4 8.9"));
    }

    @Test
    public void thirdTestValidationData() {
        Assert.assertFalse(validatorData.isRightString("1.2 3.2 -5.2.34 -4.23 2.4 8.9"));
    }

    @Test
    public void forthTestValidationData() {
        Assert.assertFalse(validatorData.isRightString(""));
    }

    @AfterSuite
    public void clearAll() {
        validatorData = null;
    }
}
