package by.andruhovich.task.validator;

import by.andruhovich.task.action.ActionQuadrangle;
import by.andruhovich.task.math.VectorOperation;
import by.andruhovich.task.entity.Point;
import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.math.DefineSign;
import by.andruhovich.task.validator.point.ValidatorPoint;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidatorQuadrangle {

    private static final Logger LOGGER = LogManager.getLogger(ValidatorQuadrangle.class);

    public boolean isQuadrangle(Quadrangle quadrangle) {
        if (quadrangle == null) {
            throw new IllegalArgumentException();
        }

        ValidatorPoint validatorPoint = new ValidatorPoint();

        boolean current = (validatorPoint.isPointsLieOnLine(quadrangle.getFirstPoint(), quadrangle.getSecondPoint(), quadrangle.getThirdPoint())) ||
                (validatorPoint.isPointsLieOnLine(quadrangle.getSecondPoint(), quadrangle.getThirdPoint(), quadrangle.getForthPoint())) ||
                (validatorPoint.isPointsLieOnLine(quadrangle.getThirdPoint(), quadrangle.getForthPoint(), quadrangle.getFirstPoint())) ||
                (validatorPoint.isPointsLieOnLine(quadrangle.getForthPoint(), quadrangle.getFirstPoint(), quadrangle.getSecondPoint()));
        boolean result = current ? false : true;
        LOGGER.log(Level.INFO, "The shape is quadrangle: " + result);
        return result;
    }

    public boolean isSquare(Quadrangle quadrangle) {
        if (quadrangle == null) {
            throw new IllegalArgumentException();
        }

        ActionQuadrangle actionQuadrangle = new ActionQuadrangle();
        double[] sides = actionQuadrangle.calculateSides(quadrangle);
        boolean result = sides[0] == sides[1] && sides[2] == sides[3] && sides[0] == sides[2];

        LOGGER.log(Level.INFO, "The quadrangle is square: " + result);
        return result;
    }

    public boolean isConvex(Quadrangle quadrangle) {
        if (quadrangle == null) {
            throw new IllegalArgumentException();
        }

        VectorOperation vectorOperation = new VectorOperation();
        double[] crossProduct;

        crossProduct = vectorOperation.calculateListVectorCrossProduct(vectorOperation.calculateListDirectingVector(quadrangle.getPointList()));
        boolean result = DefineSign.defineSign(crossProduct[0]) == DefineSign.defineSign(crossProduct[1]) &&
                DefineSign.defineSign(crossProduct[2]) == DefineSign.defineSign(crossProduct[3]) &&
                DefineSign.defineSign(crossProduct[0]) == DefineSign.defineSign(crossProduct[2]);

        LOGGER.log(Level.INFO, "The quadrangle is convex: " + result);

        return result;
    }

}