/**
 * Array: Best Time to Buy and Sell Stock
 *
 * Problem: prices[i] is the price on day i. Buy once, then sell on a later day.
 *          Return the maximum profit, or 0 if no profit is possible.
 * Pattern: Single pass, track the minimum so far.
 * Time: O(n) | Space: O(1)
 *
 * Insight: For each day, the best you can do is (today's price - cheapest price before today).
 *          Keep the running minimum and the running best profit.
 */
public class MaxProfit {

    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        check(maxProfit(new int[] {7, 1, 5, 3, 6, 4}) == 5, "buy at 1, sell at 6");
        check(maxProfit(new int[] {7, 6, 4, 3, 1}) == 0, "falling prices");
        check(maxProfit(new int[] {}) == 0, "empty");
        check(maxProfit(new int[] {2}) == 0, "single day");

        System.out.println("MaxProfit: all checks passed");
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
