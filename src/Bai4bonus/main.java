package Bai4bonus;

import java.util.HashMap;
import java.util.Map;

class WordCounter {
    private HashMap<String, Integer> wordMap = new HashMap<>();

    public void analyze(String text) {
        text = text.toLowerCase().replaceAll("[.,]", "");

        String[] words = text.trim().split("\\s+");

        for (String word : words) {
            if (word.isEmpty()) continue;

            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
    }

    public void displayResult() {
        System.out.println("Danh sach tu va so lan xuat hien:");

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Tim tu xuat hien nhieu nhat
        String maxWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        if (!maxWord.isEmpty()) {
            System.out.println("Tu xuat hien nhieu nhat: "
                    + maxWord + " (" + maxCount + " lan)");
        }
    }
}

public class main {
    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        String text = "Hello world. This is a java program. Hello java, hello world.";

        counter.analyze(text);
        counter.displayResult();
    }
}
