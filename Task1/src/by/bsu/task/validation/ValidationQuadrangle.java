package by.bsu.task.validation;

import by.bsu.task.action.ActionQuadrangle;
import by.bsu.task.entity.Point;
import by.bsu.task.entity.Quadrangle;

public class ValidationQuadrangle {

    public boolean isQuadrangle(Quadrangle quadrangle) {
        return (!isPointsLieOnLine(quadrangle.getFirstPoint(), quadrangle.getSecondPoint(), quadrangle.getThirdPoint())) &&
                (!isPointsLieOnLine(quadrangle.getSecondPoint(), quadrangle.getThirdPoint(), quadrangle.getForthPoint())) &&
                (!isPointsLieOnLine(quadrangle.getThirdPoint(), quadrangle.getForthPoint(), quadrangle.getFirstPoint())) &&
                (!isPointsLieOnLine(quadrangle.getForthPoint(), quadrangle.getFirstPoint(), quadrangle.getSecondPoint()));
    }

    private boolean isPointsLieOnLine(Point firstPoint, Point secondPoint, Point thirdPoint) {
        double Tol = 1e-5; // точность
        //(x_3 - x_1) / (x_2 - x_1) - (y_3 - y_1) / (y_2 - y_1)
        double result = (thirdPoint.getX() - firstPoint.getX()) / (secondPoint.getX() - firstPoint.getX()) -
                (thirdPoint.getY() - firstPoint.getY()) / (secondPoint.getY() - firstPoint.getY());
        return Math.abs(result) <= Tol || Double.isNaN(result);
    }

    public boolean isSquare(Quadrangle quadrangle) {
        double firstSide = Math.sqrt(Math.pow(quadrangle.getSecondPoint().getX() - quadrangle.getFirstPoint().getX(), 2) +
                Math.pow(quadrangle.getSecondPoint().getY() - quadrangle.getFirstPoint().getY(), 2));
        double secondSide = Math.sqrt(Math.pow(quadrangle.getThirdPoint().getX() - quadrangle.getSecondPoint().getX(), 2) +
                Math.pow(quadrangle.getThirdPoint().getY() - quadrangle.getSecondPoint().getY(), 2));
        double thirdSide = Math.sqrt(Math.pow(quadrangle.getForthPoint().getX() - quadrangle.getThirdPoint().getX(), 2) +
                Math.pow(quadrangle.getForthPoint().getY() - quadrangle.getThirdPoint().getY(), 2));
        double forthSide = Math.sqrt(Math.pow(quadrangle.getFirstPoint().getX() - quadrangle.getForthPoint().getX(), 2) +
                Math.pow(quadrangle.getFirstPoint().getY() - quadrangle.getForthPoint().getY(), 2));

        return firstSide == secondSide && thirdSide == forthSide && firstSide == thirdSide;
    }
}