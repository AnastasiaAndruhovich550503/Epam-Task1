package by.andruhovich.task.observer;

import by.andruhovich.task.entity.Quadrangle;

public interface Observer {
    public void update(Integer id, Quadrangle quadrangle);
}
