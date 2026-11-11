package Bai3bonus;


import java.util.*;

public class main {
    public static void main(String[] args) {
        String text = """
                Java is a popular programming language. Java is used
                to develop many applications. Programming is an
                important skill for students. Students learn Java
                because Java is simple and powerful. Learning
                programming requires practice. Practice makes
                programming easier. Java is widely used in software
                development. Many students enjoy learning Java.
                """;

        text = text.toLowerCase();
        text = text.replaceAll("[^a-z\\s]", " ");

        String[] words = text.trim().split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        String maxWord = "";
        int maxCount = 0;

        for (String word : map.keySet()) {
            int count = map.get(word);

            if (count > maxCount) {
                maxCount = count;
                maxWord = word;
            }
        }

        System.out.println("Word appears most: " + maxWord);
        System.out.println("Number of appearances: " + maxCount);

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("\nWords sorted by frequency:");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nUnique words:");

        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                System.out.println(word);
            }
        }
    }
}
