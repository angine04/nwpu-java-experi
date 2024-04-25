import java.time.LocalDate;
import java.util.Scanner;

public class StudentMngMain {

    public static void addStudent(StudentManager studentManager, Scanner scanner) {
        try {
            System.out.println("Enter student id:");
            int id;
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
            } else {
                throw new Exception("Invalid id!");
            }
            if (!(studentManager.getStudentById(id) == null)) {
                throw new Exception("Student id already exists!");
            }
            System.out.println("Enter student name:");
            String name;
            if (scanner.hasNext()) {
                name = scanner.next();
            } else {
                throw new Exception("Invalid name!");
            }
            System.out.println("Enter student String of birth(yyyy-mm-dd):");
            String dateStr;
            if (scanner.hasNext()) {
                dateStr = scanner.next();
            } else {
                throw new Exception("Invalid date of birth!");
            }
            LocalDate dateOfBirth = LocalDate.parse(dateStr);
            System.out.println("Enter student gender(M/F):");
            String genderStr;
            Gender gender;
            if (scanner.hasNext()) {
                genderStr = scanner.next();
                if (!(genderStr.equals("M") || genderStr.equals("F"))) {
                    throw new Exception("Invalid gender! please enter M/F.");
                }
                gender = Enum.valueOf(Gender.class, genderStr);
            } else {
                throw new Exception("Invalid gender!");
            }
            System.out.println("Enter student class name:");
            String className;
            if (scanner.hasNext()) {
                className = scanner.next();
            } else {
                throw new Exception("Invalid class name!");
            }
            Student student = new Student(id, name, dateOfBirth, gender, className);
            studentManager.addStudent(student);
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        } finally {
        }
    }

    public static void searchStudentById(StudentManager studentManager, Scanner scanner) {
        try {
            System.out.println("Enter student id:");
            int id;
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
            } else {
                throw new Exception("Invalid id!");
            }
            Student student = studentManager.getStudentById(id);
            if (student == null) {
                System.out.println("Student not found!");
            } else {
                System.out.println("Student found:");
                System.out.println("Id: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Date of birth: " + student.getDateOfBirth());
                System.out.println("Gender: " + student.getGender());
                System.out.println("Class name: " + student.getClassName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (scanner.hasNext()) {
                scanner.next();
            }
        }
    }

    public static void deleteStudentById(StudentManager studentManager, Scanner scanner) {
        try {
            System.out.println("Enter student id:");
            int id;
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
            } else {
                throw new Exception("Invalid id!");
            }
            Student student = studentManager.getStudentById(id);
            if (student == null) {
                throw new Exception("Student not found!");
            } else {
                studentManager.deleteStudent(student);
                System.out.println("Student deleted successfully!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (scanner.hasNext()) {
                scanner.next();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        StudentManager studentManager = new StudentManager();
        try (Scanner scanner = new Scanner(System.in)) {
            for (;;) {
                int option;
                System.out.println("=========================");
                System.out.println("Student Management System");
                System.out.println("1. Add student");
                System.out.println("2. Search student by id");
                System.out.println("3. Delete student by id");
                System.out.println("4. List all students");
                System.out.println("5. Save data to file");
                System.out.println("6. Load data from file");
                System.out.println("7. Exit");
                System.out.println("=========================");
                System.out.println("Select an option:");
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                } else {
                    scanner.nextLine();
                    option = 0;
                }
                switch (option) {
                    case 1:
                        addStudent(studentManager, scanner);
                        break;
                    case 2:
                        searchStudentById(studentManager, scanner);
                        break;
                    case 3:
                        deleteStudentById(studentManager, scanner);
                        break;
                    case 4:
                        studentManager.listStudents();
                        break;
                    case 5:
                        studentManager.saveToFile();
                        break;
                    case 6:
                        studentManager.loadFromFile();
                        break;
                    case 7:
                        System.out.println("Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
            }
        }
    }
}
