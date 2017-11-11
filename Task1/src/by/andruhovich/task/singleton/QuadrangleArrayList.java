package by.andruhovich.task.singleton;

import by.andruhovich.task.entity.Quadrangle;

import java.util.ArrayList;

public final class QuadrangleArrayList {
    private static QuadrangleArrayList instance;
    private ArrayList<Quadrangle> quadrangleArrayList = new ArrayList<>();

    private QuadrangleArrayList() {}

    public static QuadrangleArrayList getInstance() {
        if (instance == null) {
            instance = new QuadrangleArrayList();
        }
        return instance;
    }

    public void addQuadrangle(Quadrangle quadrangle) {
        quadrangleArrayList.add(quadrangle);
    }

    public Quadrangle getQuadrangle(long id) {
        for (Quadrangle quadrangle : quadrangleArrayList)
            if (quadrangle.getId() == id) return quadrangle;

        return null;
    }

    public void removeQuadrangle(long id) {
        for (Quadrangle quadrangle : quadrangleArrayList)
            if (quadrangle.getId() == id) {
                quadrangleArrayList.remove(id);
                return;
            }
    }

    public int getSize() {
        return quadrangleArrayList.size();
    }

    boolean isEmpty() {
        return quadrangleArrayList.isEmpty();
    }
}
