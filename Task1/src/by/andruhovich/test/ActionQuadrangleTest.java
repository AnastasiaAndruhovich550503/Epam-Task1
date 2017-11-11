package by.andruhovich.test;

import by.andruhovich.task.action.ActionQuadrangle;
import by.andruhovich.task.entity.Point;
import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.exception.DataIsEmptyTechnicalException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ActionQuadrangleTest {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point forthPoint;
    private Quadrangle quadrangle;

    private double[] expectedQuadrangleSides;
    private double expectedQuadranglePerimeter;
    private double expectedQuadrangleSquare;

    private ActionQuadrangle actionQuadrangle;

    @BeforeSuite
    public void fieldsInitialization() {
       actionQuadrangle = new ActionQuadrangle();
       expectedQuadrangleSides = new double[4];
    }

    @BeforeGroups("firstTest")
    public void firstInitialization() {
        firstPoint = new Point(1, 1);
        secondPoint = new Point(2, 2);
        thirdPoint = new Point(3, 2);
        forthPoint = new Point(4, 1);

        quadrangle = new Quadrangle(0, firstPoint, secondPoint, thirdPoint, forthPoint);

        expectedQuadrangleSides[0] = 1.414213562;
        expectedQuadrangleSides[1] = 1;
        expectedQuadrangleSides[2] = 1.414213562;
        expectedQuadrangleSides[3] = 3;

        expectedQuadranglePerimeter = 6.82842712;
        expectedQuadrangleSquare = 2;
    }

    @BeforeGroups("secondTest")
    public void secondInitialization() {
        firstPoint = new Point(1.5, 1);
        secondPoint = new Point(1.5, 3);
        thirdPoint = new Point(2.5, 1.6);
        forthPoint = new Point(3.6, 1);

        quadrangle = new Quadrangle(0, firstPoint, secondPoint, thirdPoint, forthPoint);

        expectedQuadrangleSides[0] = 2;
        expectedQuadrangleSides[1] = 1.720465053;
        expectedQuadrangleSides[2] = 1.252996408;
        expectedQuadrangleSides[3] = 2.1;

        expectedQuadranglePerimeter = 7.07346146;
        expectedQuadrangleSquare = 1.62999999;
    }

    @Test(groups = "firstTest")
    public void firstTestCalculateSides() {
        Assert.assertEquals(actionQuadrangle.calculateSides(quadrangle)[0], expectedQuadrangleSides[0], 0.00001);
    }

    @Test(groups = "secondTest")
    public void secondTestCalculateSides() {
        Assert.assertEquals(actionQuadrangle.calculateSides(quadrangle)[2], expectedQuadrangleSides[2], 0.000001);
    }

    @Test(groups = "firstTest")
    public void firstTestCalculatePerimeter() {
        Assert.assertEquals(actionQuadrangle.calculatePerimeter(quadrangle), expectedQuadranglePerimeter, 0.000001);
    }

    @Test(groups = "secondTest")
    public void secondTestCalculatePerimeter() {
        Assert.assertEquals(actionQuadrangle.calculatePerimeter(quadrangle), expectedQuadranglePerimeter, 0.000001);
    }

    @Test(groups = "firstTest")
    public void firstTestCalculateSquare() {
        Assert.assertEquals(actionQuadrangle.calculateSquare(quadrangle), expectedQuadrangleSquare, 0.000001);
    }

    @Test(groups = "secondTest")
    public void secondTestCalculateSquare() {
        Assert.assertEquals(actionQuadrangle.calculateSquare(quadrangle), expectedQuadrangleSquare, 0.000001);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestCalculatesSides() {
        actionQuadrangle.calculateSides(quadrangle);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestCalculatesPerimeter() {
        actionQuadrangle.calculateSides(quadrangle);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestCalculatesSquare() {
        actionQuadrangle.calculateSides(quadrangle);
    }

    @AfterGroups({"firstTest", "secondTest"})
    public void clearQuadrangle() {
        quadrangle = null;
    }

    @AfterSuite
    public void clearAll() {
        firstPoint = null;
        secondPoint = null;
        thirdPoint = null;
        forthPoint = null;
        actionQuadrangle = null;

        expectedQuadrangleSides = null;
    }
}
