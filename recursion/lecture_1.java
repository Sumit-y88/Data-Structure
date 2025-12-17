class lecture_1{
    void printIncreasing(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        lecture_1 obj = new lecture_1();
        obj.printIncreasing(5);
    }
}