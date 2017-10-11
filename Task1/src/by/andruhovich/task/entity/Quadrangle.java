package by.andruhovich.task.entity;

import java.util.ArrayList;

public class Quadrangle {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point forthPoint;

    public Quadrangle(Point firstPoint, Point secondPoint, Point thirdPoint, Point forthPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.forthPoint = forthPoint;
    }

    public Quadrangle(Quadrangle quadrangle) {
        this.firstPoint = quadrangle.getFirstPoint();
        this.secondPoint = quadrangle.getSecondPoint();
        this.thirdPoint = quadrangle.getThirdPoint();
        this.forthPoint = quadrangle.getForthPoint();
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
    public String toString(){
        return firstPoint.toString() + " " + secondPoint.toString() + " " + thirdPoint.toString() + " " + forthPoint.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quadrangle)) return false;

        Quadrangle that = (Quadrangle) o;

        if (getFirstPoint() != null ? !getFirstPoint().equals(that.getFirstPoint()) : that.getFirstPoint() != null)
            return false;
        if (getSecondPoint() != null ? !getSecondPoint().equals(that.getSecondPoint()) : that.getSecondPoint() != null)
            return false;
        if (getThirdPoint() != null ? !getThirdPoint().equals(that.getThirdPoint()) : that.getThirdPoint() != null)
            return false;
        return getForthPoint() != null ? getForthPoint().equals(that.getForthPoint()) : that.getForthPoint() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstPoint() != null ? getFirstPoint().hashCode() : 0;
        result = 31 * result + (getSecondPoint() != null ? getSecondPoint().hashCode() : 0);
        result = 31 * result + (getThirdPoint() != null ? getThirdPoint().hashCode() : 0);
        result = 31 * result + (getForthPoint() != null ? getForthPoint().hashCode() : 0);
        return result;
    }

}
