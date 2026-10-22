package Bai1;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        try{
            System.out.println("Nhap so nguyen a");
            int a=scanner.nextInt();
            System.out.println("Nhap so nguyen b");
            int b=scanner.nextInt();
            int result =a/b;
            System.out.println(result);
        } catch (InputMismatchException e){
            System.out.println("ban phai nhap vao so nguyen");
        }catch (ArithmeticException e){
            System.out.println("Khong the chia cho 0");
        }finally {
            System.out.println("Program finished");
        }

    }
}
