import java.util.Arrays;

public class Remove_duplicates_from_sorted_array {
    public static void main(String[] args){

        int[] num = { 2, 4, 4, 8, 9 };
        int newLength = remDup(num);
        System.out.println(newLength);

    }

    static int remDup(int[] num){

        int i = 0;
        for (int j = 1; j < num.length; j++) {
            if ( num[i] != num[j] ){
                i++;

                num[i] = num[j];
            }
        }

        return i + 1;
    }
}

