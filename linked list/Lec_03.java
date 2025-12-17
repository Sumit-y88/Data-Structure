import java.util.*;
public class Lec_03 {
    public static void main(String[] args){
        System.out.println("Enyer a number to check wheather it is a odd or even");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num%2 == 0){
            System.out.println(num + " is an even number");
        }else{
            System.out.println(num + " is odd number");
        }

    }
}
