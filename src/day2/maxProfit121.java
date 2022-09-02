package day2;

/**
 * @Package:day2
 * @Author: wyb
 * @DATE:2022/8/30
 * @Description: 力扣 121
 */
public class maxProfit121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        return process(prices, 0, 0);
    }

    public static int process(int[] prices, int index, int res) {
        if (index == prices.length) {
            return res;
        }
        for (int i = index + 1; i < prices.length; i++) {
            res = Math.max(prices[i] - prices[index], res);
        }
        return process(prices, index + 1, res);
    }


        public static int maxProfit2(int[] prices) {
            int maxprofit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    int profit = prices[j] - prices[i];
                    if (profit > maxprofit) {
                        maxprofit = profit;
                    }
                }
            }
            return maxprofit;
        }


    public static int maxProfit3(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] > min){
                max = Math.max(prices[i] - min,max);
            }
        }
        return max;
    }
}


