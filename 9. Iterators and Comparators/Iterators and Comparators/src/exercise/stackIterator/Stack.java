package exercise.stackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack implements Iterable<Integer> {
    private List<Integer> elements;

    public Stack() {
        this.elements = new ArrayList<>();
    }

    public List<Integer> getElements() {
        return elements;
    }

    public void setElements(List<Integer> elements) {
        this.elements = elements;
    }

    public void push(int number) {
        elements.add(0, number);
    }

    public void pop() {
        if (elements.isEmpty()) {
            System.out.println("No elements");
        } else {
            elements.remove(0);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index;

            @Override
            public boolean hasNext() {
                return this.index < elements.size();
            }

            @Override
            public Integer next() {
                return elements.get(index++);
            }
        };
    }
}
