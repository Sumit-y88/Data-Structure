import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    int[] marks;
    char grade;

    // Constructor
    Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        int avg = calculateAverage(marks);
        this.grade = calculateGrade(avg);
    }

    // Calculate average marks
    private int calculateAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    // Grade based on average marks
    private char calculateGrade(int avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 45) return 'D';
        else return 'F';
    }

    // Display student details
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nGrade: " + grade);
        System.out.println("------------------------");
    }
}

public class StudentGrading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjectCount = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            sc.nextLine(); // consume newline
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();

            int[] marks = new int[subjectCount];
            for (int j = 0; j < subjectCount; j++) {
                System.out.print("Enter marks for Subject " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }

            students[i] = new Student(name, rollNo, marks);
        }

        // Display all student data
        System.out.println("\n--- Student Grades ---");
        for (int i = 0; i < students.length; i++) {
            students[i].display();
        }

        sc.close();
    }
}
