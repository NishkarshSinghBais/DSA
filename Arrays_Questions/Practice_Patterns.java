public class Practice_Patterns {
    public static void main(String[] args) {
        int n = 4;
        pattern4(n);
    }
    static void pattern1(int n){
//        *
//        * *
//        * * *
//        * * * *

        for (int i = 1; i <= n; i++){
            for (int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }
    static void pattern2(int n){

//        * * * *
//        * * * *
//        * * * *
//        * * * *

        for (int i = 1; i <= n; i++){
            for (int j=1; j<=n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n){

//        * * * *
//        * * *
//        * *
//        *

        for (int i = 1; i <= n; i++){
            for (int j=1; j<=n-i+1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n){

        for (int i = 1; i <= n; i++){
            for (int j=1; j<=i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
