public class fibonacci {
    static int printFibonacci(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return printFibonacci(n-1) + printFibonacci(n-2);
    }
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i <= n; i++) {
            System.out.print(printFibonacci(i) + " ");
        }
    }
}