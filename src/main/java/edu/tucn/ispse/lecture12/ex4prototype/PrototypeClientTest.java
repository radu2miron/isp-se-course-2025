package edu.tucn.ispse.lecture12.ex4prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

abstract class Shape implements Cloneable {
    private String description;
    public Shape(String description) {
        this.description = description;
    }

    @Override
    protected Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    public String getDescription() {
        return description;
    }
}

class Square extends Shape {
    public Square(String description) {
        super(description);
    }
}

class Circle extends Shape {
    public Circle(String description) {
        super(description);
    }
}

class ShapeCache {
    private Map<String, Shape> cache = new HashMap<>();

    public ShapeCache() {
        loadCache();
    }

    private void loadCache() {
        cache.put("square", new Square("It's square"));
        cache.put("circle", new Circle("It's round"));
    }

    public Shape getShapeClone(String name) {
        return (Shape) cache.get(name).clone();
    }
}

public class PrototypeClientTest {
    public static void main(String[] args) {
        ShapeCache shapeCache = new ShapeCache();
        System.out.println(shapeCache.getShapeClone("square").getDescription());
        System.out.println(shapeCache.getShapeClone("circle").getDescription());
    }
}
