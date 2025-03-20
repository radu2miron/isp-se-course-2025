package edu.tucn.ispse.lecture5.ex5record.ex51;

import java.util.Objects;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class PointClass {
    private int x;
    private int z;

    public PointClass(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointClass point = (PointClass) o;
        return x == point.x && z == point.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, z);
    }

    @Override
    public String toString() {
        return "PointClass{" +
                "x=" + x +
                ", z=" + z +
                '}';
    }
}
