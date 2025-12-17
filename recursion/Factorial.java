public class Factorial {
    long printFactorial(int n){
        if(n == 0){
            return 1;
        }
        return n * printFactorial(n-1);
    } 
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.printFactorial(20));
    }
}
