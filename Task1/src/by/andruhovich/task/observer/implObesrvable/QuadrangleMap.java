package by.andruhovich.task.observer.implObesrvable;

import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.observer.Observable;
import by.andruhovich.task.observer.Observer;
import by.andruhovich.task.singleton.QuadrangleSingleton;

import java.util.ArrayList;
import java.util.HashMap;

public class QuadrangleMap implements Observable{
    private ArrayList<Observer> observerArrayList;
    private QuadrangleSingleton quadrangleSingleton;
    private int id;

    public QuadrangleMap(HashMap<Integer, Quadrangle> quadrangleHashMap) {
        observerArrayList = new ArrayList<>();
        quadrangleSingleton.getQuadrangleHashMap(quadrangleHashMap);
    }

    @Override
    public void registerObserver(Observer observer) {
        observerArrayList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerArrayList.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerArrayList)
            observer.update(id, quadrangleSingleton.getQuadrangleHashMap(null).get(id));
    }

    public void addQuadrangle(Integer id, Quadrangle quadrangle) {
        this.id = id;
        quadrangleSingleton.getQuadrangleHashMap(null).put(id, quadrangle);
        notifyObserver();
    }

    public void removeQuadrangle(Integer id) {
        this.id = id;
        quadrangleSingleton.getQuadrangleHashMap(null).remove(id);
        notifyObserver();
    }
}
