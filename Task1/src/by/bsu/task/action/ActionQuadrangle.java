package by.bsu.task.action;

import by.bsu.task.entity.Quadrangle;

public class ActionQuadrangle {
    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private double forthSide;

    private void calculateSides(Quadrangle quadrangle) {
        firstSide = Math.sqrt(Math.pow(quadrangle.getSecondPoint().getX() - quadrangle.getFirstPoint().getX(), 2) +
                Math.pow(quadrangle.getSecondPoint().getY() - quadrangle.getFirstPoint().getY(), 2));
        secondSide = Math.sqrt(Math.pow(quadrangle.getThirdPoint().getX() - quadrangle.getSecondPoint().getX(), 2) +
                Math.pow(quadrangle.getThirdPoint().getY() - quadrangle.getSecondPoint().getY(), 2));
        thirdSide = Math.sqrt(Math.pow(quadrangle.getForthPoint().getX() - quadrangle.getThirdPoint().getX(), 2) +
                Math.pow(quadrangle.getForthPoint().getY() - quadrangle.getThirdPoint().getY(), 2));
        forthSide = Math.sqrt(Math.pow(quadrangle.getFirstPoint().getX() - quadrangle.getForthPoint().getX(), 2) +
                Math.pow(quadrangle.getFirstPoint().getY() - quadrangle.getForthPoint().getY(), 2));
    }

    public double calculatePerimeter(Quadrangle quadrangle) {
        calculateSides(quadrangle);
        return  firstSide + secondSide + thirdSide + forthSide;
    }

    public double calculateSquare(Quadrangle quadrangle) {
        calculateSides(quadrangle);
        double halfPerimeter = calculatePerimeter(quadrangle) / 2;

        return Math.sqrt((halfPerimeter - firstSide) * (halfPerimeter - secondSide) *
                (halfPerimeter - thirdSide) * (halfPerimeter - forthSide));

    }
}
