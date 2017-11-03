package by.andruhovich.task.action;

import by.andruhovich.task.entity.Quadrangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ActionQuadrangle {

    private static final Logger LOGGER = LogManager.getLogger(ActionQuadrangle.class);

    public double[] calculateSides(Quadrangle quadrangle) {
        if (quadrangle == null) {
            throw new IllegalArgumentException();
        }

        double[] sides = new double[4];
        sides[0] = new BigDecimal(Math.hypot(quadrangle.getSecondPoint().getX() - quadrangle.getFirstPoint().getX(),
                quadrangle.getSecondPoint().getY() - quadrangle.getFirstPoint().getY())).setScale(9,
                RoundingMode.DOWN).doubleValue();
        sides[1] = new BigDecimal(Math.hypot(quadrangle.getThirdPoint().getX() - quadrangle.getSecondPoint().getX(),
                quadrangle.getThirdPoint().getY() - quadrangle.getSecondPoint().getY())).setScale(9,
                RoundingMode.DOWN).doubleValue();
        sides[2] = new BigDecimal(Math.hypot(quadrangle.getForthPoint().getX() - quadrangle.getThirdPoint().getX(),
                quadrangle.getForthPoint().getY() - quadrangle.getThirdPoint().getY())).setScale(9,
                RoundingMode.DOWN).doubleValue();
        sides[3] = new BigDecimal(Math.hypot(quadrangle.getFirstPoint().getX() - quadrangle.getForthPoint().getX(),
                quadrangle.getFirstPoint().getY() - quadrangle.getForthPoint().getY())).setScale(9,
                RoundingMode.DOWN).doubleValue();

        return sides;
    }

    public double calculatePerimeter(Quadrangle quadrangle) {
        if (quadrangle == null) {
            throw new IllegalArgumentException();
        }

        double[] sides = calculateSides(quadrangle);
        double perimeter =  new BigDecimal(sides[0] + sides[1] + sides[2] + sides[3]).setScale(8,
                RoundingMode.DOWN).doubleValue();

        LOGGER.log(Level.INFO, "The perimeter of quadrangle is " + perimeter);
        return perimeter;
    }

    public double calculateSquare(Quadrangle quadrangle) {
        if (quadrangle == null) {
            throw new IllegalArgumentException();
        }

        //S = 0.5 * |(x1 - x2)(y1 + y2) + (x2 - x3)*(y2 + y3) + (x3 - x4)(y3 + y4) + (x4 - x1)(y4 + y1)|
        double square = new BigDecimal(0.5 * Math.abs((quadrangle.getFirstPoint().getX() - quadrangle.getSecondPoint().getX()) *
                (quadrangle.getFirstPoint().getY() + quadrangle.getSecondPoint().getY()) +
                        (quadrangle.getSecondPoint().getX() - quadrangle.getThirdPoint().getX()) *
                (quadrangle.getSecondPoint().getY() + quadrangle.getThirdPoint().getY()) +
                        (quadrangle.getThirdPoint().getX() - quadrangle.getForthPoint().getX()) *
                (quadrangle.getThirdPoint().getY() + quadrangle.getForthPoint().getY()) +
                        (quadrangle.getForthPoint().getX() - quadrangle.getFirstPoint().getX()) *
                (quadrangle.getForthPoint().getY() + quadrangle.getFirstPoint().getY()))).setScale(8,
                RoundingMode.DOWN).doubleValue();

        LOGGER.log(Level.INFO, "The square of quadrangle is " + square);
        return square;
    }
}
