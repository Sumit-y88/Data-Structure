import java.util.Scanner;
public class exercise_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your marks so that i can calculate the percentage");
        System.out.println("Mathematics:");
        int maths = sc.nextInt();
        System.out.println("English");
        int eng = sc.nextInt();
        System.out.println("Science");
        int sci = sc.nextInt();
        System.out.println("Hindi:");
        int hindi = sc.nextInt();
        System.out.println("Sanskrit: ");
        int sanskrit = sc.nextInt();
        int sum = maths+eng+sci+hindi+sanskrit;
        System.out.println(sum);
        float div = sum/500f;
        float per = div*100;
        System.out.println("The percentage of the student is :" + per);
    }
}
