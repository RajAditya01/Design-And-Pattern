import java.util.NoSuchElementException;

public interface Iterator {
    boolean hasNext();
    Integer next();
}

public class MyList {
    private Integer[] elements;

    public MyList(Integer[] elements) {
        this.elements = elements;
    }

    public Iterator createIterator() {
        return new MyListIterator(elements);
    }

    private class MyListIterator implements Iterator {
        private int currentIndex = 0;

        public MyListIterator(Integer[] elements) {
            MyList.this.elements = elements;
        }

        public boolean hasNext() {
            return currentIndex < elements.length;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Integer currentElement = elements[currentIndex];
            currentIndex++;
            return currentElement;
        }
    }
}

public class Iterator {
    public static void main(String[] args) {
        Integer[] elements = {1, 2, 3, 4, 5};
        MyList myList = new MyList(elements);
        Iterator iterator = myList.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}