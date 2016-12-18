package com.Arrays;

public class BestTimetoBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pricesI = {7, 6, 4, 3, 1};
		//System.out.println(maxProfitI(pricesI));
		
		int[] pricesII = {5, 1, 2, 3, 4};
		//System.out.println(maxProfitII(pricesII));
		
		int[] pricesForCooldown = {1, 2, 3,0,2};
		System.out.println(maxProfitwithCooldown(pricesForCooldown));
	}

	
/* 	121. Say you have an array for which the ith element is the price of a given stock on day i.
	If you were only permitted to complete at most one transaction 
	(ie, buy one and sell one share of the stock), design an algorithm to find the
	 maximum profit. 
	 Ex -  	Input: [7, 1, 5, 3, 6, 4]
			Output: 5
	max. difference = 6-1 = 5.		
*/	
	 public static int maxProfitI(int[] prices) 
	 {
	        int min = prices[0];
	        int result=0;
	        for(int i=1;i<prices.length;i++)
	        {
	        	result = Math.max(result, prices[i]-min);
	        	min = Math.min(min, prices[i]);
	        	
	        }
	        return result;
	 }
	 
	 /* Say you have an array for which the ith element is the price of a given stock on day i.
	Design an algorithm to find the maximum profit. You may complete as many transactions 
	as you like (ie, buy one and sell one share of the stock multiple times). 
	However, you may not engage in multiple transactions at the same time 
	(ie, you must sell the stock before you buy again). */
	 
	 public static int maxProfitII(int[] prices) 
	 {
		 int result = 0;
		 for(int i=1;i<prices.length;i++)
		 {
			 if(prices[i]-prices[i-1] > 0)
			 {
				 result+=prices[i]-prices[i-1];
			 }
		 }
		 return result;
	 }
	 
	 public static int maxProfitwithCooldown(int[] prices) 
	 {
		  int buy = Integer.MIN_VALUE, pre_buy = 0, sell = 0, pre_sell = 0;
	        for (int price : prices) 
	        {
	            pre_buy = buy;
	            buy = Math.max(pre_sell - price, pre_buy);
	            pre_sell = sell;
	            sell = Math.max(pre_buy + price, pre_sell);
	        }
	        return sell; 
	  }
}
