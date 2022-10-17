package lection.genericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(5, 8);
        System.out.println(scale.getHeavier());

        Scale<Double> scaleDouble = new Scale<>(5.1, 4.3);
        System.out.println(scaleDouble.getHeavier());
    }
}
