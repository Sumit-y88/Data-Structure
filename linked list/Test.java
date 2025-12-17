public class Test {
    public static void main(String[] args) {         
        int[] table = new int[5];
        int j = 2;
        for(int i =0;i<table.length;i++){
            table[i] = j;
            j = j+2;
        }
        for(int i = 0;i<table.length;i++){
            System.out.print(table[i] +" ");
        }

    }
}
