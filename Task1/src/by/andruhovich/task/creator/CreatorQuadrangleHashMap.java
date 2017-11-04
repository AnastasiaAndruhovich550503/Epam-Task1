package by.andruhovich.task.creator;

import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.exception.DataIsEmptyTechnicalException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class CreatorQuadrangleHashMap {
    private static final Logger LOGGER = LogManager.getLogger(CreatorQuadrangle.class);

    public HashMap<Integer, Quadrangle> createQuadrangleHashMap(ArrayList<double[]> listData) {
        if (listData == null) {
            throw new IllegalArgumentException();
        }

        CreatorQuadrangle creatorQuadrangle = new CreatorQuadrangle();
        HashMap<Integer, Quadrangle> quadrangleHashMap = new HashMap<>();

        for (int i = 0, id = 0; i < listData.size(); i++) {
            try {
                Quadrangle quadrangle = creatorQuadrangle.createQuadrangle(listData.get(i));
                if (quadrangle != null) {
                    quadrangleHashMap.put(id, quadrangle);
                    id++;
                }
                else {
                    LOGGER.log(Level.WARN, "Figure in line " + i + " in list is not a quadrangle");
                }
            } catch (DataIsEmptyTechnicalException e) {
                LOGGER.log(Level.WARN, e.getMessage() + i + " in list");
            }
        }

        return quadrangleHashMap;
    }
}
