package by.andruhovich.task.observer.implObserver;

import by.andruhovich.task.action.ActionQuadrangle;
import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.observer.Observer;

import java.util.HashMap;

public class ValueMap implements Observer {
    private HashMap<Integer, double[]> valuesHashMap = new HashMap<>();

    public ValueMap(HashMap<Integer, double[]> valuesHashMap) {
        this.valuesHashMap = valuesHashMap;
    }

    @Override
    public void update(Integer id, Quadrangle quadrangle) {
        if (quadrangle == null) {
            valuesHashMap.remove(id);
            return;
        }

        ActionQuadrangle actionQuadrangle = new ActionQuadrangle();
        double[] values = new double[2];

        values[0] = actionQuadrangle.calculatePerimeter(quadrangle);
        values[1] = actionQuadrangle.calculateSquare(quadrangle);

        valuesHashMap.put(id, values);
    }
}
