package edu.tucn.ispse.lecture5.ex5record.ex52;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        // call custom constructor
        Point origin = new Point(0);
        System.out.println(origin);

        // call the canonical constructor
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);

        // call the instance method distance()
        System.out.printf("Distance between %s and %s is: %f\n", p2, p1, p2.distance(p1));

        // call the static method distance()
        System.out.printf("Distance between %s and %s is: %f\n", p1, p2, Point.distance(p1, p2));

        // call static getters and setters
        System.out.println("All points are " + Point.getColor());
        Point.setColor("red");
        System.out.println("All points are " + Point.getColor());

        // call constructor with negative args
        new Point(-1, 0); // IllegalArgument exception expected
    }
}
