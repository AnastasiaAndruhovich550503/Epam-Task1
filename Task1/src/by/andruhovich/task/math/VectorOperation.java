package by.andruhovich.task.math;

import by.andruhovich.task.entity.Point;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class VectorOperation {
    public double[] calculateListDirectingVector(Point firstPoint, Point secondPoint) {
        if (firstPoint == null || secondPoint == null) {
            throw new IllegalArgumentException();
        }

        double[] vector = new double[2];
        vector[0] =  new BigDecimal(secondPoint.getX() - firstPoint.getX()).setScale(9,
                RoundingMode.HALF_UP).doubleValue();
        vector[1] =  new BigDecimal(secondPoint.getY() - firstPoint.getY()).setScale(9,
                RoundingMode.HALF_UP).doubleValue();

        return vector;
    }

    public ArrayList<double[]> calculateListDirectingVector(ArrayList<Point> pointList) {
        if (pointList == null) {
            throw new IllegalArgumentException();
        }

        ArrayList<double[]> vectorList = new ArrayList<>();
        int i;

        for (i = 0; i < pointList.size() - 1; i++) {
            vectorList.add(calculateListDirectingVector(pointList.get(i), pointList.get(i + 1)));
        }
        vectorList.add(calculateListDirectingVector(pointList.get(i), pointList.get(0)));

        return vectorList;
    }

    public double calculateVectorCrossProduct(double[] firstVector, double[] secondVector) {
        if (firstVector == null || secondVector == null) {
            throw new IllegalArgumentException();
        }
        return new BigDecimal(firstVector[0] * secondVector[1] - firstVector[1] * secondVector[0]).setScale(9,
                RoundingMode.HALF_UP).doubleValue();
    }

    public double[] calculateListVectorCrossProduct(ArrayList<double[]> vectorList) {
        if (vectorList == null) {
            throw new IllegalArgumentException();
        }

        double[] crossProductList = new double[vectorList.size()];
        int i;

        for (i = 0; i < vectorList.size() - 1; i++) {
            crossProductList[i] = calculateVectorCrossProduct(vectorList.get(i), vectorList.get(i + 1));
        }
        crossProductList[i] = calculateVectorCrossProduct(vectorList.get(i), vectorList.get(0));

        return crossProductList;
    }
}
