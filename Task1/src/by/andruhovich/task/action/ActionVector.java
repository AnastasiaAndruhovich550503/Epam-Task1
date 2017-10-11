package by.andruhovich.task.action;

import by.andruhovich.task.entity.Point;

import java.util.ArrayList;

public class ActionVector {
    public double[] findDirectingVector(Point firstPoint, Point secondPoint) {
        double[] vector = new double[2];
        vector[0] = secondPoint.getX() - firstPoint.getX();
        vector[1] = secondPoint.getY() - firstPoint.getY();

        return vector;
    }

    public ArrayList<double[]> findDirectingVectors(ArrayList<Point> pointList) {
        ArrayList<double[]> vectorList = new ArrayList<>();
        int i;

        for (i = 0; i < pointList.size() - 1; i++) {
            vectorList.add(findDirectingVector(pointList.get(i), pointList.get(i + 1)));
        }
        vectorList.add(findDirectingVector(pointList.get(i), pointList.get(0)));

        return vectorList;
    }

    public double findVectorCrossProduct(double[] firstVector, double[] secondVector) {
        return firstVector[0] * secondVector[1] - firstVector[1] * secondVector[0];
    }

    public double[] findListVectorCrossProduct(ArrayList<double[]> vectorList) {
        double[] crossProductList = new double[vectorList.size()];
        int i;

        for (i = 0; i < vectorList.size() - 1; i++) {
            crossProductList[i] = findVectorCrossProduct(vectorList.get(i), vectorList.get(i + 1));
        }
        crossProductList[i] = findVectorCrossProduct(vectorList.get(i), vectorList.get(0));

        return crossProductList;
    }
}
