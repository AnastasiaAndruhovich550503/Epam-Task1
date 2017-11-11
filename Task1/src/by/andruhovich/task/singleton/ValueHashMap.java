package by.andruhovich.task.singleton;

import java.util.HashMap;

public final class ValueHashMap {
    private static ValueHashMap instance;
    private HashMap<Long, double[]> valueHashMap = new HashMap<>();

    private ValueHashMap() {}

    public static ValueHashMap getInstance() {
        if (instance == null) {
            instance = new ValueHashMap();
        }
        return instance;
    }

    public void addValue(long id, double value[]) {
        valueHashMap.put(id, value);
    }

    public double[] getValue(long id) {
        return valueHashMap.get(id);
    }

    public void removeValue(long id) {
        valueHashMap.remove(id);
    }

    public int getSize() {
        return valueHashMap.size();
    }

    boolean isEmpty() {
        return valueHashMap.isEmpty();
    }
}
