    package exercise;

    import java.util.ArrayList;
    import java.util.LinkedHashMap;
    import java.util.Map;
    import java.util.Scanner;

    public class OddOccurrences {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] words = scanner.nextLine().split("\\s+");
            LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();
            ArrayList<String> odds = new ArrayList<>();

            for (String word : words) {
                word = word.toLowerCase();

                if (!counts.containsKey(word)) {
                    counts.put(word, 0);
                }

                counts.put(word, counts.get(word) + 1);
            }

            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    odds.add(entry.getKey());
                }
            }

            int size = odds.size();

            for (int i = 0; i < size; i++) {
                System.out.print(odds.get(i));

                if (i < size - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
