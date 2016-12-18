package com.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] coins = {1, 2, 3};
		//int[] coins = {1};
		//System.out.println("coinChange with fewest number of coins "+coinChange(coins, 4));
		
		int[] numberOfSol = {1,2,3};
		System.out.println(numberOfSolutionsOnSpace(4, numberOfSol));
	}
	
	public static int coinChange(int[] coins, int amount) 
	{
		if (coins == null || coins.length == 0 || amount <= 0) 
		{
            return 0;
        }
         
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) 
        {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) 
        {
            for (int j = 0; j < coins.length; j++) 
            {
                if (coins[j] <= i) 
                {
                	
                    if (dp[i - coins[j]] != Integer.MAX_VALUE) 
                    {
                    	
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                        System.out.println("i "+i+" "+dp[i]);
                    }
                }
            }
        }
        
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
        
    }
	
	
	
	public static int numberOfSolutionsOnSpace(int total, int arr[])
	{
		int temp[] = new int[total+1];
		temp[0] = 1;
		for(int i=0; i < arr.length; i++)
		{
			for(int j=1; j <= total ; j++)
			{
				if(j >= arr[i])
				{                
					temp[j] += temp[j-arr[i]]; 
					System.out.println("i "+i+" j "+j+" temp "+temp[j]);
				}    
			}
		}
		return temp[total];
	}

}
