package SQ_Implementation.Ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element_Monotonic_Statck {
    public static void main(String[] args) {

        int[] arr = {6, 0, 8, 1, 3};

        System.out.println(Arrays.toString(nge(arr)));

    }

    static int[] nge(int[] arr){

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];

        for (int i = n-1; i >= 0 ; i--) {
            while ( !st.isEmpty() && st.peek() <= arr[i] ){
                st.pop();
            }
            if ( st.isEmpty() ){
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
