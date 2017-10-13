package by.andruhovich.task.creator;

import by.andruhovich.task.entity.Point;
import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.exception.DataIsEmptyTechnicalException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CreatorQuadrangle {

    private static final Logger LOGGER = LogManager.getLogger();

    public Quadrangle createQuadrangle(double[] data) throws DataIsEmptyTechnicalException{
        if (data.length == 0) {
            throw new DataIsEmptyTechnicalException("Data is empty ");
        }

        Point firstPoint = new Point(data[0], data[1]);
        Point secondPoint = new Point(data[2], data[3]);
        Point thirdPoint = new Point(data[4], data[5]);
        Point forthPoint = new Point(data[6], data[7]);

        Quadrangle quadrangle = new Quadrangle(firstPoint, secondPoint, thirdPoint, forthPoint);
        return quadrangle;
    }

    public ArrayList<Quadrangle> createListOfQuadrangle(ArrayList<double[]> listData) {
        if (listData == null) {
            throw new IllegalArgumentException();
        }

        ArrayList<Quadrangle> listQuadrangle = new ArrayList<>();

        for (int i = 0; i < listData.size(); i++) {
            try {
                listQuadrangle.add(createQuadrangle(listData.get(i)));
            } catch (DataIsEmptyTechnicalException e) {
                LOGGER.printf(Level.WARN, e.getMessage() + i + " in list");
            }
        }

        return listQuadrangle;
    }
}
