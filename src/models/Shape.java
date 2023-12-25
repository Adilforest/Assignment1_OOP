package models;

import java.util.LinkedList;
import java.util.List;

public class Shape {
    private final List<Point> points = new LinkedList<>();

    public void addPoint(Point newPoint) {
        points.add(newPoint);
    }

    public double getPerimeter() {
        int count = points.size();
        double perimeter = 0;
        for (int i = 0; i < count; i++)
            perimeter += points.get(i).getDistanceTo(points.get((i + 1) % count));
        return perimeter;
    }

    public double getAverageSide() {
        int count = points.size();
        if (count <= 1) return 0;
        if (count == 2) return getPerimeter();
        return getPerimeter() / count;
    }

    public double getLongestSide() {
        double mx = 0;
        int size = points.size();
        for (int i = 0; i < size; i++)
            mx = Math.max(points.get(i).getDistanceTo(points.get((i + 1) % size)), mx);
        return mx;
    }
}