package lection.genericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {
    public static <T> T[] create(int length, T item) {
        T[] result = (T[]) Array.newInstance(item.getClass(), length);

        for (int i = 0; i < length; i++) {
            result[i] = item;
        }

        return result;
    }

    public static <T> T[] create(Class<T> myClass, int length, T item) {
        T[] result = (T[]) Array.newInstance(myClass, length);

        for (int i = 0; i < length; i++) {
            result[i] = item;
        }

        return result;
    }
}
