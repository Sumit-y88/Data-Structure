public class Lec_05 {
    public static void main(String[] args){
    //     for(int j = 1;j<5;j++){
    //         for(int i = 1;i<6;i++){
    //             System.out.print("*");
    //         }
    //         System.out.print("\n");
    //     }
    //Hollow Rectangle
    // for(int i = 1;i<=4;i++){
    //     for(int j=1;j<=5;j++){
    //         if( i==1 || j==1 || i==4 || j==5){
    //             System.out.print("*");
    //         }else{
    //             System.out.print(" ");
    //         }
    //     }
    //     System.out.println();
    // }

    //Inverted half piramid
        // for(int i = 5; i>0;i--){
        //     for(int j=0;j<i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //number half pyramind
        for(int i = 5;i>=1;i--){
            for(int j = 1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }

    }
}
