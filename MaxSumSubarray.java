package com.Arrays;

public class MaxSumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,-2,4};
		//System.out.println(maxSubArray(arr));
		//System.out.println(maxSum(arr));
		
		System.out.println(maxProduct(arr));
	}

	public static int maxSubArray(int[] nums) 
	{
		if(nums.length==0)
			return 0;
        int max_ending_here = nums[0];
        int max_so_far = nums[0];
        for(int i=1;i<nums.length;i++)
        {
        	
        	max_ending_here = Math.max(nums[i], max_ending_here+nums[i]);
        	max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
	
	public static int maxSum(int[] input) {
		   
		 
		   int max = input[0];
		   int newSum = input[0];
		   for(int i=1;i<input.length;i++)
		   {
		       newSum = Math.max(newSum+input[i],input[i]);
		       max = Math.max(max,newSum);
		   }
		    return max;
		}

	 public static int maxProduct(int[] nums) 
	 {
		 if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        int len = nums.length;
	        int min = nums[0];
	        int max = nums[0];
	         
	        int result = nums[0];
	         
	        for (int i = 1; i < len; i++) 
	        {     
	            int curMin = Math.min(Math.min(min * nums[i], max * nums[i]), nums[i]);
	            int curMax = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
	             
	            min = curMin;
	            max = curMax;
	            result = Math.max(result, max);
	        }
	         
	        return result;
	 }
	
}
