class RecursionLearn{

    public static int calcFact(int n){
        if(n == 1|| n==0){
            return 1;
        }
        int f_nm_1 = n*calcFact(n-1);
        return f_nm_1;
    }
    public static void main(String[] args) {
        System.out.println(calcFact(10));
    }
}

