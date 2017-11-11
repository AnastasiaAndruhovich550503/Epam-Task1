package by.andruhovich.task.creator;

import by.andruhovich.task.entity.Point;
import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.exception.DataIsEmptyTechnicalException;
import by.andruhovich.task.validator.ValidatorQuadrangle;

public class CreatorQuadrangle {

    public Quadrangle createQuadrangle(long id, double[] data) throws DataIsEmptyTechnicalException{
        if (data.length == 0) {
            throw new DataIsEmptyTechnicalException("Data is empty ");
        }

        ValidatorQuadrangle validatorQuadrangle = new ValidatorQuadrangle();

        Point firstPoint = new Point(data[0], data[1]);
        Point secondPoint = new Point(data[2], data[3]);
        Point thirdPoint = new Point(data[4], data[5]);
        Point forthPoint = new Point(data[6], data[7]);

        Quadrangle quadrangle = new Quadrangle(id, firstPoint, secondPoint, thirdPoint, forthPoint);

        if (validatorQuadrangle.isQuadrangle(quadrangle)) return quadrangle;
        else return null;
    }


}
