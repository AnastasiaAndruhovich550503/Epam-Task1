package by.andruhovich.task.observer.implobesrvable;

import by.andruhovich.task.entity.Quadrangle;
import by.andruhovich.task.observer.Observable;
import by.andruhovich.task.observer.Observer;
import by.andruhovich.task.singleton.QuadrangleArrayList;

import java.util.ArrayList;

public class QuadrangleObservable implements Observable{
    private ArrayList<Observer> observerArrayList;
    private QuadrangleArrayList quadrangleArrayList;
    private long id;
    private int operationType;

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
        for (Observer observer : observerArrayList) {
            if (operationType == -1) {
                observer.update(id, null);
            }
            else {
                observer.update(id, quadrangleArrayList.getQuadrangle(id));
            }
        }
    }

    public void addQuadrangle(Quadrangle quadrangle) {
        id = quadrangle.getId();
        operationType = 1;
        quadrangleArrayList.addQuadrangle(quadrangle);
        notifyObserver();
    }

    public void removeQuadrangle(long id) {
        id = id;
        operationType = -1;
        quadrangleArrayList.removeQuadrangle(id);
        notifyObserver();
    }
}
