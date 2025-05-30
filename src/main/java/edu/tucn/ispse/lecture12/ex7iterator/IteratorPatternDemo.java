package edu.tucn.ispse.lecture12.ex7iterator;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Container {
    Iterator iterator();
}

class NameRepository implements Container {
    private String names[] = {"Robert", "John", "Julie", "Lora"};
    private NameIterator nameIterator;

    @Override
    public Iterator iterator() {
        nameIterator = new NameIterator();
        return nameIterator;
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }

            return null;
        }
    }
}

public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }

        System.out.println("---------------\n");

        //OR

        Iterator it = namesRepository.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
