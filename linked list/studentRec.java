import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    int marks;
    char grade;

    Student(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    public char calculateGrade(int marks) {
        if (marks >= 90)
            return 'A';
        else if (marks >= 75)
            return 'B';
        else if (marks >= 60)
            return 'C';
        else if (marks >= 45)
            return 'D';
        else
            return 'F';

    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("------------------------");
    }
}

public class studentRec {
    public static void main(String[] args) {
        System.out.println("Enter the number of student");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Student students[] = new Student[n];

        for(int i = 0 ; i < n; i++){
            System.out.println("Student no. "+ (i+1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();

            System.out.print("Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            students[i] = new Student(name,rollNo,marks);
            System.out.println();
        }
        System.out.println("----Student's Grade-----");
        for(int i = 0; i < n; i++){
            students[i].display();
        }
    }
}
