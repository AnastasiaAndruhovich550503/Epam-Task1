package by.andruhovich.task.singleton;

import by.andruhovich.task.entity.Quadrangle;

import java.util.HashMap;

public final class QuadrangleSingleton {
    private static QuadrangleSingleton instance = null;
    private HashMap <Integer, Quadrangle> quadrangleHashMap = new HashMap<>();

    private QuadrangleSingleton(HashMap<Integer, Quadrangle> quadrangleHashMap) {
        this.quadrangleHashMap = quadrangleHashMap;
    }

    public HashMap<Integer, Quadrangle> getQuadrangleHashMap(HashMap<Integer, Quadrangle> quadrangleHashMap) {
        if (instance == null) {
            instance = new QuadrangleSingleton(quadrangleHashMap);
        }
        return quadrangleHashMap;
    }

    public static QuadrangleSingleton getInstance() {
        return instance;
    }
}
