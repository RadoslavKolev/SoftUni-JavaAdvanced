package exercise.listyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        this.index = 0;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    public void print() {
        if (this.data.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.data.get(this.index));
        }
    }
}
