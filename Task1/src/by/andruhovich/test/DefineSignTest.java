package by.andruhovich.test;

import by.andruhovich.task.math.DefineSign;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Double.NaN;

public class DefineSignTest {
    @Test
    public void firstTestDefineSign() {
        Assert.assertEquals(DefineSign.defineSign(3), 1);
    }

    @Test
    public void secondTestDefineSign() {
        Assert.assertEquals(DefineSign.defineSign(-2), -1);
    }

    @Test
    public void thirdTestDefineSign() {
        Assert.assertEquals(DefineSign.defineSign(0), 0);
    }

    @Test
    public void forthTestDefineSign() {
        Assert.assertEquals(DefineSign.defineSign(NaN), -2);
    }
}
