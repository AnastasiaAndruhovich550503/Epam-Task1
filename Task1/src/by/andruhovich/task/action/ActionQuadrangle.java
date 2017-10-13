package by.andruhovich.task.action;

import by.andruhovich.task.entity.Quadrangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionQuadrangle {

    private static final Logger LOGGER = LogManager.getLogger();

    public double[] calculateSides(Quadrangle quadrangle) {
        if (quadrangle == null) {
            throw new IllegalArgumentException();
        }

        double[] sides = new double[4];
        sides[0] = Math.hypot(quadrangle.getSecondPoint().getX() - quadrangle.getFirstPoint().getX(),
                quadrangle.getSecondPoint().getY() - quadrangle.getFirstPoint().getY());
        sides[1] = Math.hypot(quadrangle.getThirdPoint().getX() - quadrangle.getSecondPoint().getX(),
                quadrangle.getThirdPoint().getY() - quadrangle.getSecondPoint().getY());
        sides[2] = Math.hypot(quadrangle.getForthPoint().getX() - quadrangle.getThirdPoint().getX(),
                quadrangle.getForthPoint().getY() - quadrangle.getThirdPoint().getY());
        sides[3] = Math.hypot(quadrangle.getFirstPoint().getX() - quadrangle.getForthPoint().getX(),
                quadrangle.getFirstPoint().getY() - quadrangle.getForthPoint().getY());

        return sides;
    }

    public double calculatePerimeter(Quadrangle quadrangle) {
        if (quadrangle == null) {
            throw new IllegalArgumentException();
        }

        double[] sides = calculateSides(quadrangle);
        double perimeter = sides[0] + sides[1] + sides[2] + sides[3];

        LOGGER.printf(Level.INFO, "The perimeter of quadrangle is " + perimeter);
        return perimeter;
    }

    public double calculateSquare(Quadrangle quadrangle) {
        if (quadrangle == null) {
            throw new IllegalArgumentException();
        }

        double[] sides = calculateSides(quadrangle);
        double halfPerimeter = calculatePerimeter(quadrangle) / 2;
        double square = Math.sqrt((halfPerimeter - sides[0]) * (halfPerimeter - sides[1]) *
                (halfPerimeter - sides[2]) * (halfPerimeter - sides[3]));

        LOGGER.printf(Level.INFO, "The square of quadrangle is " + square);
        return square;

    }
}
