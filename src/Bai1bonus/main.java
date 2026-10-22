package Bai1bonus;


public class main {
    public static void useString() {
        String str = "";

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            str = str + "Hello";
        }

        long end = System.currentTimeMillis();

        System.out.println("String time: " + (end - start) + " ms");
        System.out.println("String length: " + str.length());
    }

    public static void useStringBuffer() {
        StringBuffer sb = new StringBuffer();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            sb.append("Hello");
        }

        long end = System.currentTimeMillis();

        System.out.println("StringBuffer time: " + (end - start) + " ms");
        System.out.println("StringBuffer length: " + sb.length());
    }

    public static void contentAnalysis(String text) {
        int sentences = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == '.' || c == '?' || c == '!') {
                sentences++;
            }
        }

        System.out.println("So cau: " + sentences);
        String result = text.replace("Java", "Python");
        System.out.println("Van ban sau khi thay the:");
        System.out.println(result);
    }

    public static void main(String[] args) {

        useString();
        useStringBuffer();

        String text = "Java is easy! Do you like Java? " + "I am learning Java. Java is interesting.";

        contentAnalysis(text);
    }
}
