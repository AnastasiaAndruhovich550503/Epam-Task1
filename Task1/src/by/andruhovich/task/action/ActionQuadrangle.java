package by.andruhovich.task.action;

import by.andruhovich.task.entity.Quadrangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionQuadrangle {

    private static final Logger LOGGER = LogManager.getLogger(ActionQuadrangle.class);

    public double[] calculateSides(Quadrangle quadrangle) {
        double[] sides = new double[4];
        sides[0] = Math.sqrt(Math.pow(quadrangle.getSecondPoint().getX() - quadrangle.getFirstPoint().getX(), 2) +
                Math.pow(quadrangle.getSecondPoint().getY() - quadrangle.getFirstPoint().getY(), 2));
        sides[1] = Math.sqrt(Math.pow(quadrangle.getThirdPoint().getX() - quadrangle.getSecondPoint().getX(), 2) +
                Math.pow(quadrangle.getThirdPoint().getY() - quadrangle.getSecondPoint().getY(), 2));
        sides[2] = Math.sqrt(Math.pow(quadrangle.getForthPoint().getX() - quadrangle.getThirdPoint().getX(), 2) +
                Math.pow(quadrangle.getForthPoint().getY() - quadrangle.getThirdPoint().getY(), 2));
        sides[3] = Math.sqrt(Math.pow(quadrangle.getFirstPoint().getX() - quadrangle.getForthPoint().getX(), 2) +
                Math.pow(quadrangle.getFirstPoint().getY() - quadrangle.getForthPoint().getY(), 2));

        return sides;
    }

    public double calculatePerimeter(Quadrangle quadrangle) {
        double[] sides = calculateSides(quadrangle);
        double perimeter = sides[0] + sides[1] + sides[2] + sides[3];

        LOGGER.printf(Level.INFO, "The perimeter of quadrangle is " + perimeter);
        return perimeter;
    }

    public double calculateSquare(Quadrangle quadrangle) {
        double[] sides = calculateSides(quadrangle);
        double halfPerimeter = calculatePerimeter(quadrangle) / 2;
        double square = Math.sqrt((halfPerimeter - sides[0]) * (halfPerimeter - sides[1]) *
                (halfPerimeter - sides[2]) * (halfPerimeter - sides[3]));

        LOGGER.printf(Level.INFO, "The square of quadrangle is " + square);
        return square;

    }
}
