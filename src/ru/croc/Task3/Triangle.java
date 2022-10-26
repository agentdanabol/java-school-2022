package ru.croc.Task3;

public class Triangle {
    static class Point {
        double x;
        double y;
    }

    public static double getArea(Point a, Point b, Point c) {
        double side1 = Math.sqrt(Math.pow((a.x - b.x),2.0)+Math.pow((a.y - b.y),2.0));
        double side2 = Math.sqrt(Math.pow((b.x - c.x),2.0)+Math.pow((b.y - c.y),2.0));
        double side3 = Math.sqrt(Math.pow((c.x - a.x),2.0)+Math.pow((c.y - a.y),2.0));
        double p = 0.5*(side1 + side2 + side3);
        double area = Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
        return area;
    }

    public static void main(String[] args) {

        Point a = new Point();
        a.x = Double.parseDouble(args[0]);
        a.y = Double.parseDouble(args[1]);

        Point b = new Point();
        b.x = Double.parseDouble(args[2]);
        b.y = Double.parseDouble(args[3]);

        Point c = new Point();

        c.x = Double.parseDouble(args[4]);
        c.y = Double.parseDouble(args[5]);

        System.out.println("Площадь треугольника равна: " + getArea(a, b, c));

    }
}
