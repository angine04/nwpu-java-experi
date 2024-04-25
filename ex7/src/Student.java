import java.io.Serializable;
import java.time.LocalDate;

enum Gender {
    M,
    F
}

public class Student implements Serializable{
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String className;

    // Constructor
    public Student(int id, String name, LocalDate date, Gender gender, String className) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = date;
        this.className = className;
        this.gender = gender;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for LocalDateOfBirth
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Getter for LocalDateOfBirth
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    // Setter for gender
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // Getter for gender
    public Gender getGender() {
        return gender;
    }

    // Setter for className
    public void setClassName(String className) {
        this.className = className;
    }

    // Getter for className
    public String getClassName() {
        return className;
    }
}
