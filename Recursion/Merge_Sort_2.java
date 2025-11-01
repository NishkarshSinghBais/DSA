import java.util.*;

public class Merge_Sort_2 {
    
    public static void main(String[] args) {

        int[] arr  = {7, 9, 3, 5, 1, 2};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        
    }

    static void mergeSort(int[] arr, int s, int e){

        if ( e - s == 1 ){
            return;
        }

        int m = s + ( e - s ) / 2;

        mergeSort(arr, s, m);
        mergeSort(arr, m, e);

        sortMerge(arr, s, m, e);
    }

    static void sortMerge(int[] arr, int s, int m, int e){

        int[] merge = new int[ e - s ];

        int i = s;
        int j = m;
        int k = 0;

        while ( i < m && j < e){
            if( arr[i] < arr[j] ){
                merge[k] = arr[i];
                i++;

            } else {
                merge[k] = arr[j];
                j++;
            }

            k++;
        }

        while ( i < m ){
            merge[k] = arr[i];
            i++;
            k++;
        }

        while ( j < e ){
            merge[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < merge.length; l++) {
            arr[s + l] = merge[l];
            
        }

    }
}

