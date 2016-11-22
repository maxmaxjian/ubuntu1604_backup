
class Solution {
    public int maxProfit(int[] prices) {
	if (prices.length > 1) {
	    int buy = prices[0], sell = prices[0];
	    int[] rest = new int[prices.length-1];
	    for (int i = 1; i < prices.length; i++) {
		rest[i-1] = prices[i];
		if (prices[i] > sell)
		    sell = prices[i];
	    }
	    return max(sell-buy, maxProfit(rest));
	}
	else
	    return 0;
    }

    private int max(int x1, int x2) {
	return (x1 < x2) ? x2 : x1;
    }

	public static void main(String[] args) {
	    int[] prices = {1,4,5,7,6,3,2,9};

	    Solution soln = new Solution();
	    int mprofit = soln.maxProfit(prices);
	    System.out.println("The maximium profit obtained by one buy and sell is:");
	    System.out.println(mprofit);
	}
	
}
