package sliding_window;

public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int profit = prices[i + 1] - prices[i];
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

    //brute force solution:
    public static int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int sell = prices[j] - buy;
                res = Math.max(res, sell);
            }
        }
        return res;
    }

    //two pointers solution:
    public static int maxProfit3(int[] prices) {
        int l = 0, r = 1;
        int maxProfit = 0;
        while (r < prices.length) {
            if (prices[l] < prices[r]) {//buy less, sell more
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else
                l = r;
            r++;
        }
        return maxProfit;
    }

    public static int maxProfit4(int[] prices) {
        int maxProfit = 0;
        int minBuy = prices[0];
        for (int sell : prices) {
            maxProfit = Math.max(maxProfit, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
