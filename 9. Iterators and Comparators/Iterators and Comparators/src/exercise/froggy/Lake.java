package exercise.froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private final List<Integer> elements;

    public Lake(List<Integer> elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        private int index = 0;
        boolean isFinished = false;

        @Override
        public boolean hasNext() {
            return this.index < elements.size();
        }

        @Override
        public Integer next() {
            int result = elements.get(index);
            index += 2;

            if (index >= elements.size() && !isFinished) {
                index = 1;
                isFinished = true;
            }

            return result;
        }
    }
}
