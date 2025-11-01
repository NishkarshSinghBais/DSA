package SQ_Implementation.Ques;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Sliding_window_maximum {
    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println(Arrays.toString(find(arr, 3)));
    }

    static int[] find(int[] arr, int k){
        int n = arr.length;
        int[] ans = new int[n-k+1];
        int ansi = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if ( !dq.isEmpty() && dq.peekFirst() < i - k + 1 ){
                dq.pollFirst();
            }
            while ( !dq.isEmpty() && arr[dq.peekLast()] <= arr[i] ){
                dq.pollLast();
            }
            dq.offerLast(i);
            if ( i >= k-1 ){
                ans[ansi++] = arr[dq.peekFirst()];
            }
        }
        return ans;

    }
}
