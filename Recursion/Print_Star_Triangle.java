public class Print_Star_Triangle {

    public static void main(String[] args) {

        printStar1(5, 0);

    }

     static void printStar1(int r, int c){

        if ( r == 0 ){
            return;
        }

        if ( r > c ){
            printStar1(r, c+1);
            System.out.print("*");
        }

        else {
            printStar1(r-1, 0);
            System.out.println(); 
        }
    }
    
}
