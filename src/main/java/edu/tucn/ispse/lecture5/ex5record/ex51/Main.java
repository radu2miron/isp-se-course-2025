package edu.tucn.ispse.lecture5.ex5record.ex51;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        // test class impl.
        PointClass point1 = new PointClass(1, 2);
        System.out.println(point1);
        // ... call other methods from PointClass

        // test record impl.
        PointRecord point2 = new PointRecord(2, 1); // call the public all-args constructor
        PointRecord point3 = new PointRecord(2, 2);
        System.out.println(point2); // test toString()
        System.out.println("(" + point2.x() + ", " + point2.y() + ")"); // test getters
        System.out.println("point3 hashCode: " + point3.hashCode()); // test hashCode()
        System.out.println("point2 equals point3? " + point2.equals(point3)); // test equals()
    }
}
