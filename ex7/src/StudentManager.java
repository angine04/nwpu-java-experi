import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

public class StudentManager {
    private Collection<Student> students;

    public StudentManager() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public void listStudents() {
        for (Student student : students) {
            System.out.println("=========================");
            System.out.println("Id: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Date of birth: " + student.getDateOfBirth());
            System.out.println("Gender: " + student.getGender());
            System.out.println("Class name: " + student.getClassName());
            System.out.println("");
        }
    }

    public void saveToFile() {
        // Write students to file
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/students.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(students);
            out.close();
            fileOut.close();
            System.out.println("Data saved in /tmp/students.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadFromFile() throws ClassNotFoundException{
        try
          {
             FileInputStream fileIn = new FileInputStream("/tmp/students.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn);
             students = (Collection<Student>) in.readObject();
             System.out.println("Data loaded from /tmp/students.ser");
             in.close();
             fileIn.close();
          }catch(IOException i)
          {
             i.printStackTrace();
             return;
          }catch(ClassNotFoundException c)
          {
             System.out.println("Student class not found");
             c.printStackTrace();
             return;
          }
    }
}


