package lection.genericScale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (this.left.compareTo(this.right) < 0) {
            return right;
        } else if (this.left.compareTo(this.right) > 0) {
            return left;
        }

        return null;
    }
}
