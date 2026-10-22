package Bai3;
import java.util.Scanner;
import java.io.*;
public class ReadFile {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ten tep: ");
        String file = sc.nextLine();
        try (DataInputStream in = new DataInputStream(
                new FileInputStream(file))) {
            while (true)
                System.out.println(in.readInt());
        } catch (EOFException e) {
            System.out.println("Da doc het tep.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        }
    }
}
