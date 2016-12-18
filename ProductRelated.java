package com.Arrays;

public class ProductRelated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,-2,4,};
		System.out.println(MaxProduct(arr));
		
		int[] arr1={1,2,3,4};
		print(productExceptSelf(arr1));
		
	}

	public static int MaxProduct(int[] nums)
	{
		 int[] max = new int[nums.length];
		 int[] min = new int[nums.length];
		 
		    max[0] = min[0] = nums[0];
		    int result = nums[0];
		 
		    for(int i=1; i<nums.length; i++)
		    {
		        if(nums[i]>0)
		        {
		            max[i]=Math.max(nums[i], max[i-1]*nums[i]);
		            min[i]=Math.min(nums[i], min[i-1]*nums[i]);
		        }
		        else
		        {
		            max[i]=Math.max(nums[i], min[i-1]*nums[i]);
		            min[i]=Math.min(nums[i], max[i-1]*nums[i]);
		        }
		 
		        result = Math.max(result, max[i]);
		    }
		 
		    return result;
	}
	
	public static int[] productExceptSelf(int[] nums) 
	{
		int[] result = new int[nums.length];
		
		result[nums.length-1] = 1;
		for(int i=nums.length-2;i>=0;i--)
		{
			result[i] = result[i+1]*nums[i+1];
		}
		
		int left = 1;
		for(int i=0;i<nums.length;i++)
		{
			result[i] = left * result[i];
			left = left * nums[i];
		}
		return result;
	}
	
	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
}
