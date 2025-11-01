public class Stock_buy_and_sell {

    public static void main(String[] args) {

        int[] arr = { 7,1,5,3,6,4 };
        System.out.println(stock(arr));
    }

    static int stock(int[] arr){

        int maxProfit = 0;
        int profit = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ( arr[j] >= arr[i] ){
                    profit = arr[j] - arr[i];
                    maxProfit = Math.max(profit, maxProfit);
                }
            }
        }

        return maxProfit;
    }
}
