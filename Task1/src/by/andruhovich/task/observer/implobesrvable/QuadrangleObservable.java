package by.andruhovich.task.observer.implobesrvable;

import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.observer.Observable;
import by.andruhovich.task.observer.Observer;
import by.andruhovich.task.singleton.QuadrangleArrayList;

import java.util.ArrayList;
import java.util.HashMap;

public class QuadrangleObservable implements Observable{
    private ArrayList<Observer> observerArrayList;
    private QuadrangleArrayList quadrangleArrayList;
    private long id;

    public QuadrangleObservable() {
        observerArrayList = new ArrayList<>();
        quadrangleArrayList = QuadrangleArrayList.getInstance();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerArrayList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerArrayList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerArrayList)
            observer.update(id, quadrangleArrayList.getQuadrangle(id));
    }

    public void addQuadrangle(Quadrangle quadrangle) {
        this.id = quadrangle.getId();
        quadrangleArrayList.addQuadrangle(quadrangle);
        notifyObserver();
    }

    public void removeQuadrangle(long id) {
        this.id = id;
        quadrangleArrayList.removeQuadrangle(id);
        notifyObserver();
    }
}
