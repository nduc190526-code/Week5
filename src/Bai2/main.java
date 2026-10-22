package Bai2;
import java.io.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Source file: ");
        String src = sc.nextLine();
        System.out.print("Destination file: ");
        String dest = sc.nextLine();

        BufferedReader br = null;
        PrintWriter pw = null;
        int count = 0;

        try {
            br = new BufferedReader(new FileReader(src));
            pw = new PrintWriter(new FileWriter(dest));

            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
                count++;
            }

            System.out.println("Copied " + count + " lines.");
        } catch (FileNotFoundException e) {
            System.out.println(br == null
                    ? "Source file not found."
                    : "Cannot create destination file.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (pw != null) pw.close();
            } catch (IOException e) {
                System.out.println("I/O error.");
                e.printStackTrace();
            }
        }
    }
}