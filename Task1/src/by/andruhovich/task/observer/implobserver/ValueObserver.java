package by.andruhovich.task.observer.implobserver;

import by.andruhovich.task.action.ActionQuadrangle;
import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.observer.Observer;
import by.andruhovich.task.singleton.ValueHashMap;

public class ValueObserver implements Observer {
    private ValueHashMap valueHashMap;

    public ValueObserver() {
        valueHashMap = ValueHashMap.getInstance();
    }

    @Override
    public void update(long id, Quadrangle quadrangle) {
        if (quadrangle == null) {
            valueHashMap.removeValue(id);
            return;
        }

        ActionQuadrangle actionQuadrangle = new ActionQuadrangle();
        double[] value = new double[2];

        value[0] = actionQuadrangle.calculatePerimeter(quadrangle);
        value[1] = actionQuadrangle.calculateSquare(quadrangle);

        valueHashMap.addValue(id, value);
    }
}
