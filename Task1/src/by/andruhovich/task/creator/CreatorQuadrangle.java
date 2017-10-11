package by.andruhovich.task.creator;

import by.andruhovich.task.entity.Point;
import by.andruhovich.task.entity.Quadrangle;

import java.util.ArrayList;

public class CreatorQuadrangle {
    public Quadrangle createQuadrangle(double[] data) {
        Point firstPoint = new Point(data[0], data[1]);
        Point secondPoint = new Point(data[2], data[3]);
        Point thirdPoint = new Point(data[4], data[5]);
        Point forthPoint = new Point(data[6],data[7]);

        Quadrangle quadrangle = new Quadrangle(firstPoint, secondPoint ,thirdPoint, forthPoint);
        return quadrangle;
    }

    public ArrayList<Quadrangle> createListOfQuadrangle(ArrayList<double[]> listData) {
        ArrayList<Quadrangle> listQuadrangle = new ArrayList<>();

        for (int i = 0; i < listData.size(); i++) {
            listQuadrangle.add(createQuadrangle(listData.get(i)));
        }

        return listQuadrangle;
    }
}
