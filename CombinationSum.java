package com.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//int[] arr1 = {2,3,6,7};
		//System.out.println(combinationSumI(arr1, 7));
		
		//int[] arr2 = {10, 1, 2, 7, 6, 1, 5};
		//System.out.println(combinationSumII(arr2, 8));
		
		//System.out.println(combinationSumIII(3, 7));
		
		int[] arr4 = {1,2,3};
		System.out.println(combinationSumIV(arr4, 4));
	}

	/* COMBINATION SUM I
	 * Given a set of candidate numbers (C) and a target number (T), 
	 * find all unique combinations in C where the candidate numbers sums to T. 
	 * The same repeated number may be chosen from C unlimited number of times. 
	 * Note:
	 * 		All numbers (including target) will be positive integers.
	 * 		The solution set must not contain duplicate combinations. 
	 * Ex- given candidate set [2, 3, 6, 7] and target 7.
	 * Solution set would be [ [7], [2, 2, 3] ]
	 */
	
	public static List<List<Integer>> combinationSumI(int[] candidates, int target) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 
		    if(candidates == null || candidates.length == 0) 
		    	return result;
		 
		    ArrayList<Integer> current = new ArrayList<Integer>();
		    Arrays.sort(candidates);
		 
		    combinationSumIHelper(candidates, target, 0, current, result);
		 
		    return result;
	}
	
	
	public static void combinationSumIHelper(int[] candidates, int target, int j, List<Integer> curr, List<List<Integer>> result)
	{
		
		if(target == 0)
		   {
		       ArrayList<Integer> temp = new ArrayList<Integer>(curr);
		       result.add(temp);
		       return;
		   }
		 
		   for(int i=j; i<candidates.length; i++)
		   {
		       if(target < candidates[i]) 
		            return;
		 
		       curr.add(candidates[i]);
		       
		       combinationSumIHelper(candidates, target - candidates[i], i, curr, result);
		       curr.remove(curr.size()-1); 
		   }
		}
	
	//Combination Sum II  
	//Each  number can be used only once
	
	public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 
		    if(candidates == null || candidates.length == 0) 
		    	return result;
		 
		    ArrayList<Integer> curr = new ArrayList<Integer>();
		    Arrays.sort(candidates);
		 
		    helper(result, curr, 0, target, candidates);
		 
		    return result;
	}
	
	public static void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates)
	{
	    if(target==0)
	    {
	        result.add(new ArrayList<Integer>(curr));
	        return;
	    }
	    if(target<0)
	    {
	        return;
	    }
	 
	    int prev=-1;
	    for(int i=start; i<candidates.length; i++)
	    {
	        if(prev!=candidates[i])
	        { // each time start from different element
	            curr.add(candidates[i]);
	            helper(result, curr, i+1, target-candidates[i], candidates); // and use next element only
	            curr.remove(curr.size()-1);
	            prev=candidates[i];
	        }
	    }
	}
	
	
	//Combination Sum III
	//Find all possible combinations of k numbers that add up to a number n, 
	//given that only numbers from 1 to 9 can be used and each combination should be a 
	//unique set of numbers.
	public static List<List<Integer>> combinationSumIII(int k, int target) 
	{
			List<List<Integer>> result = new ArrayList<List<Integer>>();
		 
		    ArrayList<Integer> curr = new ArrayList<Integer>();
		   
		    helperIII(result, curr, 1, k, target);
		 
		    return result;
	}
	
	public static void helperIII(List<List<Integer>> result, List<Integer> curr,int start,int k,int target)
	{
		if(target == 0 && curr.size() == k)
		{
			result.add(new ArrayList<Integer>(curr));
			return;
		}
		if(target < 0)
				return;
		for(int i=start;i<=9;i++)
		{
			curr.add(i);
			helperIII(result,curr,i+1,k,target-i);
			curr.remove(curr.size()-1);
		}
	}
	
	//Combination Sum IV
	//Given an integer array with all positive numbers and no duplicates, 
	//find the number of possible combinations that add up to a positive integer target.
	// Similar to Coin change problem
	public static int combinationSumIV(int[] candidates, int target) 
	{
		if(candidates == null || candidates.length == 0)
			return 0;
		
		int[] arr = new int[target+1];
		
		arr[0] = 1;
//		for(int i=0;i<=target;i++)
//		{
//			for(int j=0;j<candidates.length;j++)
//			{
//				if(i+candidates[j] <= target)
//				{
//					arr[i+candidates[j]]+=arr[i];
//				}
//			}
//		}
		//OR
		
		 for(int i=0; i<=target; i++)
		 {
		       for(int num: candidates)
		       {
		           if(i+num <= target)
		           {
		               arr[i+num] = arr[i+num] + arr[i];
		               //System.out.println("i+num "+(i+num)+" arr[i+num] "+arr[i+num]);
		           }
		       }
		   }	
		return arr[target];
	}
	
	
}