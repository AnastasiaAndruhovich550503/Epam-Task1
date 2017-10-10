package by.bsu.task.main;

import by.bsu.task.entity.Point;
import by.bsu.task.entity.Quadrangle;
import by.bsu.task.validation.ValidationQuadrangle;

public class Main {

    public static void main(String[] args) {
        Point firstPoint = new Point(1, 2);
        Point secondPoint = new Point(3,4);
        Point thirdPoint = new Point(3,4);
        Point forthPoint = new Point(1,2);

        Quadrangle quadrangle = new Quadrangle(firstPoint, secondPoint ,thirdPoint, forthPoint);
        System.out.println(new ValidationQuadrangle().isQuadrangle(quadrangle));
    }
}
