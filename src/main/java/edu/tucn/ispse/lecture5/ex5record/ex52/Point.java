package edu.tucn.ispse.lecture5.ex5record.ex52;

/**
 * @author Radu Miron
 * @version 1
 * Add methods and fields to record
 */
public record Point(int x, int y) {
    //extra fields added in the record's body must be static
    private static String color = "black";

    // add an extra constructors
    public Point { // compact canonical constructor: this code is added to the default canonical constructor
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x and y must be >0");
        }
    }

    public Point(int x) { // custom constructor
        this(x, 0); // must delegate to canonical constructor
    }

    // Setters cannot be added for non-static fields; The following method cannot be compiled
//    public void setX(int x){
//        this.x = x;
//    }

    // adding a non-static method
    public double distance(Point pointRecord) {
        return Math.sqrt(Math.pow(this.x - pointRecord.x, 2) + Math.pow(this.y - pointRecord.y, 2));
    }

    // adding a static Method
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        Point.color = color;
    }
}
