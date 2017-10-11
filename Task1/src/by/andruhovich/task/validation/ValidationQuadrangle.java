package by.andruhovich.task.validation;

import by.andruhovich.task.action.ActionQuadrangle;
import by.andruhovich.task.action.ActionVector;
import by.andruhovich.task.entity.Point;
import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.math.DefineSign;

import java.util.ArrayList;

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
        ActionQuadrangle actionQuadrangle = new ActionQuadrangle();
        double[] sides = actionQuadrangle.calculateSides(quadrangle);

        return sides[0] == sides[1] && sides[2] == sides[3] && sides[0] == sides[2];
    }

    public boolean isConvex(Quadrangle quadrangle) {
        ActionVector actionVector = new ActionVector();
        double[] crossProduct = new double[4];

        crossProduct = actionVector.findListVectorCrossProduct(actionVector.findDirectingVectors(quadrangle.getPointList()));

        return DefineSign.defineSign(crossProduct[0]) == DefineSign.defineSign(crossProduct[1]) &&
                DefineSign.defineSign(crossProduct[2]) == DefineSign.defineSign(crossProduct[3]) &&
                DefineSign.defineSign(crossProduct[0]) == DefineSign.defineSign(crossProduct[2]);
    }

}