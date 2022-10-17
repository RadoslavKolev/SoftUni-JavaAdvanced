package lection.jar;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar1 = new Jar<>();

        jar1.add(0);
        jar1.add(1);
        jar1.add(2);

        System.out.println(jar1.remove());
        System.out.println(jar1.remove());

        Jar<String> jar2 = new Jar<>();

        jar2.add("Pesho");
        jar2.add("Tosho");
        jar2.add("Gosho");

        System.out.println(jar2.remove());
        System.out.println(jar2.remove());
    }
}
