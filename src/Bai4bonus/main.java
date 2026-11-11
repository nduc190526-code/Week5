package Bai4bonus;


import java.util.*;

class WordCounter {
    HashMap<String, Integer> map = new HashMap<>();

    public void analyze(String text) {
        text = text.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z' || c == ' ') {
                sb.append(c);
            } else {
                sb.append(' ');
            }
        }

        text = sb.toString();

        String[] words = text.trim().split("\\s+");

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
    }

    public void displayResult() {
        String maxWord = "";
        int maxCount = 0;

        for (String word : map.keySet()) {
            int count = map.get(word);

            System.out.println(word + ": " + count);

            if (count > maxCount) {
                maxCount = count;
                maxWord = word;
            }
        }

        System.out.println("Most frequent word: " + maxWord);
        System.out.println("Count: " + maxCount);
    }
}

public class main {
    public static void main(String[] args) {
        String text = "Hello world. This is a java program. Hello java, hello world.";

        WordCounter wc = new WordCounter();

        wc.analyze(text);
        wc.displayResult();
    }
}
