package by.andruhovich.task.validation;

import by.andruhovich.task.action.ActionQuadrangle;
import by.andruhovich.task.action.ActionVector;
import by.andruhovich.task.entity.Point;
import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.math.DefineSign;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ValidationQuadrangle {

    private static final Logger LOGGER = LogManager.getLogger(ValidationQuadrangle.class);

    public boolean isQuadrangle(Quadrangle quadrangle) {
        boolean result = (!isPointsLieOnLine(quadrangle.getFirstPoint(), quadrangle.getSecondPoint(), quadrangle.getThirdPoint())) &&
                (!isPointsLieOnLine(quadrangle.getSecondPoint(), quadrangle.getThirdPoint(), quadrangle.getForthPoint())) &&
                (!isPointsLieOnLine(quadrangle.getThirdPoint(), quadrangle.getForthPoint(), quadrangle.getFirstPoint())) &&
                (!isPointsLieOnLine(quadrangle.getForthPoint(), quadrangle.getFirstPoint(), quadrangle.getSecondPoint()));
        LOGGER.printf(Level.INFO, "The shape is quadrangle: " + result);
        return result;
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
        boolean result = sides[0] == sides[1] && sides[2] == sides[3] && sides[0] == sides[2];

        LOGGER.printf(Level.INFO, "The quadrangle is square: " + result);
        return result;
    }

    public boolean isConvex(Quadrangle quadrangle) {
        ActionVector actionVector = new ActionVector();
        double[] crossProduct = new double[4];

        crossProduct = actionVector.findListVectorCrossProduct(actionVector.findDirectingVectors(quadrangle.getPointList()));
        boolean result = DefineSign.defineSign(crossProduct[0]) == DefineSign.defineSign(crossProduct[1]) &&
                DefineSign.defineSign(crossProduct[2]) == DefineSign.defineSign(crossProduct[3]) &&
                DefineSign.defineSign(crossProduct[0]) == DefineSign.defineSign(crossProduct[2]);

        LOGGER.printf(Level.INFO, "The quadrangle is convex: " + result);

        return result;
    }

}