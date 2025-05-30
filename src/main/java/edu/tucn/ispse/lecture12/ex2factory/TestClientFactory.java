package edu.tucn.ispse.lecture12.ex2factory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
abstract class AbstractProduct {

    public void writeName(String name) {
        System.out.println("My name is " + name);
    }
}

class ProductA extends AbstractProduct {
}

class ProductB extends AbstractProduct {
    @Override
    public void writeName(String name) {
        StringBuilder tempName = new StringBuilder().append(name);
        System.out.println("My reversed name is " + tempName.reverse());
    }
}

class ProductFactory {
    AbstractProduct createProduct(String type) {
        if (type.equals("B")) {
            return new ProductB();
        } else {
            return new ProductA();
        }
    }
}

abstract class Client {
    public void printProductDescr(String name) {
        new ProductFactory()
                .createProduct(this.getClass().getSimpleName().replace("Client", ""))
                .writeName(name);
    }

    public abstract void printType();
}

class ClientA extends Client {
    AbstractProduct prod;

    @Override
    public void printType() {
        System.out.println("type A");
    }
}

class ClientB extends Client {
    AbstractProduct prod;

    @Override
    public void printType() {
        System.out.println("type B");
    }
}


public class TestClientFactory {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // use REFLEXION to instantiate a specific type of client
        String className = "edu.tucn.ispse.lecture12.ex2factory.Client" + args[0].toUpperCase();
        Client c = (Client) Class.forName(className).getDeclaredConstructor().newInstance();

        c.printProductDescr("Product Name");
        c.printType();
    }
}
