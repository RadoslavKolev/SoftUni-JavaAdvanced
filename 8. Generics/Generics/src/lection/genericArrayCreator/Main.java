package lection.genericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = ArrayCreator.<Integer>create(5, 21);
        String[] arr2 = ArrayCreator.<String>create(String.class, 5, "Pesho");

        for (Integer integer : arr1) {
            System.out.print(integer + " ");
        }

        System.out.println();

        for (String str : arr2) {
            System.out.print(str + " ");
        }
    }
}
