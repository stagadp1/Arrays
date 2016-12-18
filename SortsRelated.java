package com.Arrays;

public class SortsRelated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,2,0,1,1,2};
		sortColors(arr);
	}

	/*Given an array with n objects colored red, white or blue, sort 
	 * them so that objects of the same color are adjacent, with the colors 
	 * in the order red, white and blue.
	 * Here, we will use the integers 0, 1, and 2 to represent 
	 * the color red, white, and blue respectively. */
	public static void sortColors(int[] nums) 
	{
		int[] count = new int[3];
		for(int i=0;i<nums.length;i++)
		{
			count[nums[i]]++;
		}
		int pointer1=0;
		int pointer2=0;
		while(pointer1 <= 2)
		{
			if(count[pointer1]!=0)
			{
				nums[pointer2++]=pointer1;
				count[pointer1]--;
				
			}
			else
				pointer1++;
		}
		for(int i=0;i<nums.length;i++)
		{
			System.out.println(nums[i]);
		}
		
    }
}
