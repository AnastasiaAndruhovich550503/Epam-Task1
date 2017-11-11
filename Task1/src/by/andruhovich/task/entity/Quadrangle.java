package by.andruhovich.task.entity;

import java.util.ArrayList;

public class Quadrangle {
    private long id;
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point forthPoint;

    public Quadrangle(long id, Point firstPoint, Point secondPoint, Point thirdPoint, Point forthPoint) {
        this.id = id;
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.forthPoint = forthPoint;
    }

    public Quadrangle(Quadrangle quadrangle) {
        this.id = quadrangle.getId();
        this.firstPoint = quadrangle.getFirstPoint();
        this.secondPoint = quadrangle.getSecondPoint();
        this.thirdPoint = quadrangle.getThirdPoint();
        this.forthPoint = quadrangle.getForthPoint();
    }

    public long getId() {
        return id;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public Point getForthPoint() {
        return forthPoint;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    public void setForthPoint(Point forthPoint) {
        this.forthPoint = forthPoint;
    }

    public ArrayList<Point> getPointList() {
        ArrayList<Point> pointList = new ArrayList<>();

        pointList.add(firstPoint);
        pointList.add(secondPoint);
        pointList.add(thirdPoint);
        pointList.add(forthPoint);

        return pointList;
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "id=" + id +
                ", firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                ", forthPoint=" + forthPoint +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quadrangle)) return false;

        Quadrangle that = (Quadrangle) o;

        if (getId() != that.getId()) return false;
        if (!getFirstPoint().equals(that.getFirstPoint())) return false;
        if (!getSecondPoint().equals(that.getSecondPoint())) return false;
        if (!getThirdPoint().equals(that.getThirdPoint())) return false;
        return getForthPoint().equals(that.getForthPoint());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getFirstPoint().hashCode();
        result = 31 * result + getSecondPoint().hashCode();
        result = 31 * result + getThirdPoint().hashCode();
        result = 31 * result + getForthPoint().hashCode();
        return result;
    }
}
