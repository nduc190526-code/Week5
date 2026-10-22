package Bai3;
import java.io.*;
import java.util.Scanner;
public class WriteFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten tep: ");
        String file = sc.nextLine();
        System.out.print("Nhap n: ");
        int n = sc.nextInt();

        try (DataOutputStream out = new DataOutputStream(
                new FileOutputStream(file))) {
            for (int i = 0; i < n; i++)
                out.writeInt(sc.nextInt());
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        }
    }
}
