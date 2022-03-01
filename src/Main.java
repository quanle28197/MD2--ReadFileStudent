import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Le Minh Quan", "Ha Noi"));
        students.add(new Student(2, "Le Minh Quan", "Ha Noi"));
        students.add(new Student(3, "Le Minh Quan", "Ha Noi"));
        students.add(new Student(4, "Le Minh Quan", "Ha Noi"));
        students.add(new Student(5, "Le Minh Quan", "Ha Noi"));
        writeToFile("student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("student.txt");
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }


    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            File file;
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }
}
