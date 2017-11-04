package by.andruhovich.task.validator.point;

import by.andruhovich.task.entity.Point;

public class ValidatorPoint {
    public boolean isPointsLieOnLine(Point firstPoint, Point secondPoint, Point thirdPoint) {
        if (firstPoint == null || secondPoint == null || thirdPoint == null) {
            throw  new IllegalArgumentException();
        }

        double accuracy = 1e-5; // точность
        //(x_3 - x_1) / (x_2 - x_1) - (y_3 - y_1) / (y_2 - y_1)
        double result = (thirdPoint.getX() - firstPoint.getX()) / (secondPoint.getX() - firstPoint.getX()) -
                (thirdPoint.getY() - firstPoint.getY()) / (secondPoint.getY() - firstPoint.getY());
        return Math.abs(result) <= accuracy || Double.isNaN(result);
    }
}
