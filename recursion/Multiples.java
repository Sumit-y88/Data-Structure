public class Multiples {
   static void printMultiples(int p, int q){
        if(q == 1){
            System.out.println(p);
            return;
        }
        printMultiples(p, q-1);

        System.out.println(p*q);
    }
    public static void main(String[] args) {
        printMultiples(5, 10);
    }
}
