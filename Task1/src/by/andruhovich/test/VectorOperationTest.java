package by.andruhovich.test;

import by.andruhovich.task.math.VectorOperation;
import by.andruhovich.task.entity.Point;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class VectorOperationTest {
    private Point firstPoint;
    private Point secondPoint;
    private ArrayList<Point> pointList;
    private ArrayList<double[]> vectorList;

    private VectorOperation vectorOperation;

    private double[] firstDirectingVector;
    private double[] secondDirectingVector;
    private double[] thirdDirectingVector;
    private double[] crossProductArray;

    @BeforeSuite
    public void fieldsInitialization() {
        vectorOperation = new VectorOperation();
        vectorList = new ArrayList<>();

        firstDirectingVector = new double[]{0.5, 1.8};
        secondDirectingVector = new double[]{-0.5, -1.8};
        thirdDirectingVector = new double[]{0, 0};

        vectorList.add(firstDirectingVector);
        vectorList.add(secondDirectingVector);
        vectorList.add(thirdDirectingVector);
    }

    @BeforeGroups("Vector")
    public void vectorInitialization(){
        pointList = new ArrayList<>();

        firstPoint = new Point(2, 4);
        secondPoint = new Point(2.5, 5.8);

        pointList.add(firstPoint);
        pointList.add(secondPoint);
        pointList.add(firstPoint);
    }

    @BeforeGroups("CrossProduct")
    public void crossProductInitialization(){
        thirdDirectingVector = new double[]{2, 1};
        crossProductArray = new double[3];
        crossProductArray[0] = 0;
        crossProductArray[1] = 0;
        crossProductArray[2] = 0;
    }

    @Test(groups = "Vector")
    public void firstTestCalculateDirectionVector(){
        Assert.assertEquals(vectorOperation.calculateListDirectingVector(firstPoint, secondPoint)[0], firstDirectingVector[0], 0.000001);
    }

    @Test(groups = "Vector")
    public void secondTestCalculateDirectingVector() {
        Assert.assertEquals(vectorOperation.calculateListDirectingVector(secondPoint, firstPoint)[1], secondDirectingVector[1], 0.00001);
    }

    @Test(groups = "Vector")
    public void firstTestCalculateDirectingVectorsFirstPosition() {
        Assert.assertEquals(vectorOperation.calculateListDirectingVector(pointList).get(0)[0], vectorList.get(0)[0], 0.000001);
    }

    @Test(groups = "Vector")
    public void firstTestCalculateDirectingVectorsSecondPosition() {
        Assert.assertEquals(vectorOperation.calculateListDirectingVector(pointList).get(1)[1], vectorList.get(1)[1], 0.000001);
    }

    @Test(groups = "Vector")
    public void firstTestCalculateDirectingVectorsThirdPosition() {
        Assert.assertEquals(vectorOperation.calculateListDirectingVector(pointList).get(2)[0], vectorList.get(2)[0], 0.000001);
    }

    @Test(groups = "CrossProduct")
    public void firstTestCalculateVectorCrossProduct() {
        Assert.assertEquals(vectorOperation.calculateVectorCrossProduct(firstDirectingVector, secondDirectingVector), 0.0, 0.000001);
    }

    @Test(groups = "CrossProduct")
    public void secondTestCalculateVectorCrossProduct() {
        Assert.assertEquals(vectorOperation.calculateVectorCrossProduct(firstDirectingVector, thirdDirectingVector), -3.1, 0.000001);
    }

    @Test(groups = "CrossProduct")
    public void firstTestCalculateListVectorCrossProduct() {
        Assert.assertEquals(vectorOperation.calculateListVectorCrossProduct(vectorList), crossProductArray);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestCalculateDirectingVector() {
        vectorOperation.calculateListDirectingVector(null, null);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestCalculateDirectingVectors() {
        vectorOperation.calculateListDirectingVector(null);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestCalculateVectorCrossProduct() {
        vectorOperation.calculateVectorCrossProduct(null, null);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void negativeTestCalculateListVectorCrossProduct() {
        vectorOperation.calculateListVectorCrossProduct(null);
    }

    @AfterSuite
    public void clearAll() {
        firstPoint = null;
        secondPoint = null;
        pointList = null;
        vectorList = null;

        vectorOperation = null;

        firstDirectingVector = null;
        secondDirectingVector = null;
        thirdDirectingVector = null;
        crossProductArray = null;
    }
}
