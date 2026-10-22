package Bai4;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.io.*;
public class Student implements Serializable {
    String id;
    String name;
    double gpa;
    public Student(String id,String name,double gpa){
        this.id=id;
        this.name=name;
        this.gpa=gpa;

    }
    @Override
    public String toString() {
        return id + " - " + name + " - " + gpa;
    }
}
class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String file = "students.dat";
        ArrayList<Student> list = new ArrayList<>();

        while(true){
            String id = sc.next().trim();
            if (id.equals("END"))
                break;
            sc.nextLine();
            String name = sc.nextLine();
            double gpa = sc.nextDouble();
            sc.nextLine();
            list.add(new Student(id, name, gpa));
        }
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file))) {
            out.writeObject(list);
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep.");
        } catch (IOException e) {
            System.out.println("Loi ghi tep.");
            e.printStackTrace();
        }
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(file))) {
            ArrayList<Student> students =
                    (ArrayList<Student>) in.readObject();

            for (Student s : students)
                System.out.println(s);

        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep.");
        } catch (EOFException e) {
            System.out.println("Da doc het tep.");
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay lop Student.");
        } catch (IOException e) {
            System.out.println("Loi doc tep.");
            e.printStackTrace();
        }
    }

}
