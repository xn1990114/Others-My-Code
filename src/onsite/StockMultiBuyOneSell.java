package onsite;
/*
 * Company: HomeAway
 * Maximizing Profit from Stocks: 大意是會給你每天的stock price，每天可以做的事是
 * a. buy "One" share of stock
 * b. sell "Multiple" shares，
 * c. do nothing
 * 想辦法找出最大利潤
 * Ex:[1,2,100] max profit = 197
 * Ex:[3,2,1] max profit = 0
 */
public class StockMultiBuyOneSell {
	public int findMaxProfix(int[] prices){
		int max=0;
		int profit=0;
		for(int i=prices.length-1;i>=0;i--){
			if(prices[i]<=max){
				profit=profit+max-prices[i];
			}
			else{
				max=prices[i];
			}
		}
		return profit;
	}
}
