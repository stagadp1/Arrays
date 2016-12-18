package com.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {0,1,2,4,5,7};
		List<String> result = new ArrayList<String>();
		result = summaryRanges(arr);
		System.out.println(result);
	}
	 
	public static List<String> summaryRanges(int[] nums) 
	{
		List<String> result = new ArrayList<String>();
		int current = 0,prev=0;
		
		while(current < nums.length)
		{
			if(current+1 < nums.length && nums[current]+1 == nums[current+1])
			{
				current++;
			}
			else
			{
				if(prev == current)
				{
					result.add(Integer.toString(nums[current]));
				}
				else
				{
					String str = nums[prev]+"->"+nums[current];
					result.add(str);
				}
				++current;
				prev = current;
			}	
		
		}
		return result;
	}
}
