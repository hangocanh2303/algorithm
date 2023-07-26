package com.example.algorithm;

import java.awt.*;
import java.awt.geom.Point2D;

public class ClosestAlgorithm {
    static Point[] points = new Point[]{
            new Point(1, 1),
            new Point(2, 3),
            new Point(3, 8),
            new Point(4, 10)
    };

    public static void main(String[] args) {
        System.out.println("Result: " + closestPoint(points));
    }

    public static int closestPoint(Point[] points) {
        int n = points.length;
        int min = 9999;
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = distance(points[j], points[i]);
                if (distance < min) {
                    min = (int) distance;
                }
            }
        }
        return min;
    }

    public static double distance(Point point1, Point point2) {
        return Point.distance(point1.x, point1.y, point2.x, point2.y);
    }
 

}
