package by.andruhovich.test;

import by.andruhovich.task.entity.Point;
import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.observer.implobesrvable.QuadrangleObservable;
import by.andruhovich.task.observer.implobserver.ValueObserver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ObserverTest {
    private QuadrangleObservable quadrangleObservable;
    private ValueObserver valueObserver;

    private double expectedQuadranglePerimeter;
    private double expectedQuadrangleSquare;

    @BeforeSuite
    public void fieldsInitialization() {
        quadrangleObservable = new QuadrangleObservable();
        valueObserver = new ValueObserver();
    }

    @BeforeGroups("firstTest")
    public void firstInitialization() {
        Point firstPoint = new Point(1.5, 1);
        Point secondPoint = new Point(1.5, 3);
        Point thirdPoint = new Point(2.5, 1.6);
        Point forthPoint = new Point(3.6, 1);

        Quadrangle quadrangle = new Quadrangle(0, firstPoint, secondPoint, thirdPoint, forthPoint);

        expectedQuadranglePerimeter = 7.07346146;
        expectedQuadrangleSquare = 1.62999999;

        quadrangleObservable.registerObserver(valueObserver);
        quadrangleObservable.addQuadrangle(quadrangle);
    }

    @BeforeGroups("secondTest")
    public void secondInitialization() {
        Point firstPoint = new Point(1, 1);
        Point secondPoint = new Point(2, 2);
        Point thirdPoint = new Point(3, 2);
        Point forthPoint = new Point(4, 1);

        Quadrangle quadrangle = new Quadrangle(0, firstPoint, secondPoint, thirdPoint, forthPoint);

        quadrangleObservable.registerObserver(valueObserver);
        quadrangleObservable.addQuadrangle(quadrangle);
        quadrangleObservable.removeQuadrangle(0);
    }

    @Test(groups = "firstTest")
    public void testComparePerimeter() {
        Assert.assertEquals(valueObserver.getValue(0)[0], expectedQuadranglePerimeter, 0.00001);
    }

    @Test(groups = "firstTest")
    public void testCompareSquare() {
        Assert.assertEquals(valueObserver.getValue(0)[1], expectedQuadrangleSquare, 0.00001);
    }

    @Test(groups = "secondTest")
    public void testNegativeValue() {
        Assert.assertEquals(valueObserver.getValue(0), null);
    }

    @AfterSuite()
    public void clearAll() {
        quadrangleObservable = null;
        valueObserver = null;
    }

}
