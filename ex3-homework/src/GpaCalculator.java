import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Gpa {
    Map<Float, Float> courses = new HashMap<Float, Float>();

    int getGradePoints(float grade){
        if(grade >= 85){
            return 4;
        } else if(grade >= 75){
            return 3;
        } else if(grade >= 60){
            return 2;
        } else if(grade >= 45){
            return 1;
        } else {
            return 0;
        }
    }

    public void addCourse(float credit, float grade) {
        courses.put(credit, grade);
    }

    float getGpa(){
        float totalGradePoints = 0;
        float totalCredits = 0;
        for (Map.Entry<Float, Float> entry : courses.entrySet()) {
            totalGradePoints += getGradePoints(entry.getValue()) * entry.getKey();
            totalCredits += entry.getKey();
        }
        return totalGradePoints / totalCredits;
    }

}

public class GpaCalculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of courses: ");
        int n = scanner.nextInt();
        Gpa gpa = new Gpa();
        for(int i = 0; i < n; i++){
            System.out.println("Enter the credit for course " + (i+1) + ": ");
            float credit = scanner.nextFloat();
            System.out.println("Enter the grade for course " + (i+1) + ": ");
            float grade = scanner.nextFloat();
            gpa.addCourse(credit, grade);
        }
        System.out.println("GPA: " + gpa.getGpa());
        scanner.close();
    }
}
