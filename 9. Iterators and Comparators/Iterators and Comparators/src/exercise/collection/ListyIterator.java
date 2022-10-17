package exercise.collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> data;
    private int currentIndex;

    public ListyIterator(List<String> data) {
        this.data = data;
        this.currentIndex = 0;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public boolean move() {
        if (hasNext()) {
            this.currentIndex++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        return this.currentIndex < this.data.size() - 1;
    }

    public void print() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("Invalid Operation");
        }

        System.out.println(this.data.get(this.currentIndex));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index;

            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public String next() {
                return data.get(index++);
            }
        };
    }
}
