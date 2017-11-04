package by.andruhovich.test;

import by.andruhovich.task.entity.Point;
import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.validator.ValidatorQuadrangle;
import by.andruhovich.task.validator.point.ValidatorPoint;
import org.testng.Assert;
import org.testng.annotations.*;

public class ValidatorQuadrangleTest {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point forthPoint;
    private Quadrangle quadrangle;

    private ValidatorQuadrangle validatorQuadrangle;
    private ValidatorPoint validatorPoint;

    @BeforeSuite
    public void fieldsInitialization() {
        validatorPoint = new ValidatorPoint();
        validatorQuadrangle = new ValidatorQuadrangle();
    }

    @BeforeGroups("Test1")
    public void firstInitialization() {
        firstPoint = new Point(1, 1);
        secondPoint = new Point(2, 2);
        thirdPoint = new Point(3, 3);
        forthPoint = new Point(2.5, 6);

        quadrangle = new Quadrangle(firstPoint, secondPoint, thirdPoint, forthPoint);
    }

    @BeforeGroups("Test2")
    public void secondInitialization() {
        firstPoint = new Point(1.5, 1);
        secondPoint = new Point(1.5, 3);
        thirdPoint = new Point(2.5, 1.6);
        forthPoint = new Point(3.6, 1);

        quadrangle = new Quadrangle(firstPoint, secondPoint, thirdPoint, forthPoint);
    }

    @BeforeGroups("Test3")
    public void thirdInitialization() {
        firstPoint = new Point(1.5, 1);
        secondPoint = new Point(1.5, 3);
        thirdPoint = new Point(4.5, 3);
        forthPoint = new Point(4.5, 1);

        quadrangle = new Quadrangle(firstPoint, secondPoint, thirdPoint, forthPoint);
    }

    @Test(groups = "Test1")
    public void firstTestIsPointsLieOnLine() {
        Assert.assertFalse(validatorPoint.isPointsLieOnLine(secondPoint, thirdPoint, forthPoint));
    }

    @Test(groups = "Test1")
    public void firstTestIsQuadrangle() {
        Assert.assertFalse(validatorQuadrangle.isQuadrangle(quadrangle));
    }

    @Test(groups = "Test2")
    public void secondTestIsQuadrangle() {
        Assert.assertTrue(validatorQuadrangle.isQuadrangle(quadrangle));
    }

    @Test(groups = "Test1")
    public void firstTestIsConvex() {
        Assert.assertFalse(validatorQuadrangle.isConvex(quadrangle));
    }

    @Test(groups = "Test3")
    public void secondTestIsConvex() {
        Assert.assertTrue(validatorQuadrangle.isConvex(quadrangle));
    }

    @Test(groups = "Test3")
    public void firstTestIsSquare() {
        Assert.assertTrue(validatorQuadrangle.isConvex(quadrangle));
    }

    @Test(groups = "Test2")
    public void secondTestIsSquare() {
        Assert.assertFalse(validatorQuadrangle.isConvex(quadrangle));
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestIsPointLieOnLine() {
        validatorPoint.isPointsLieOnLine(null, null, null);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestIsConvex() {
        validatorQuadrangle.isConvex(null);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestIsQuadrangle() {
        validatorQuadrangle.isQuadrangle(null);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestIsSquare() {
        validatorQuadrangle.isSquare(null);
    }

    @AfterGroups({"Test1", "Test2", "Test3"})
    public void clearQuadrangle() {
        quadrangle = null;
    }

    @AfterSuite
    public void clearAll() {
        forthPoint = null;
        secondPoint = null;
        thirdPoint = null;
        forthPoint = null;

        validatorQuadrangle = null;
    }
}
