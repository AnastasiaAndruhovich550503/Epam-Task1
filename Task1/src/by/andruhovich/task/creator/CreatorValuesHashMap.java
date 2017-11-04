package by.andruhovich.task.creator;

import by.andruhovich.task.action.ActionQuadrangle;
import by.andruhovich.task.entity.Quadrangle;

import java.util.HashMap;

public class CreatorValuesHashMap {

    public HashMap<Integer, double[]> createValuesHashMap(HashMap<Integer, Quadrangle> quadrangleHashMap) {
        if (quadrangleHashMap == null) {
            throw new IllegalArgumentException();
        }

        HashMap<Integer, double[]> valuesHashMap = new HashMap<>();
        ActionQuadrangle actionQuadrangle = new ActionQuadrangle();

        for (int i = 0; i < quadrangleHashMap.size(); i++) {
            double[] values = new double[2];
            values[0] = actionQuadrangle.calculatePerimeter(quadrangleHashMap.get(i));
            values[1] = actionQuadrangle.calculateSquare(quadrangleHashMap.get(i));
            valuesHashMap.put(i, values);
        }

        return valuesHashMap;
    }
}