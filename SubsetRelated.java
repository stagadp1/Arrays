package com.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetRelated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,2,3};
		//System.out.println(canPartition(nums));
		
		int[] arr={1,2,3};
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 result = subsets(arr);
		 System.out.println(result);
	}

	 public static boolean canPartition(int[] nums) 
	 {
		  if (nums == null || nums.length < 2) {
	            return false;
	        }
	        int sum = 0;
	        for (int n : nums) {
	            sum += n;
	        }
	        if (sum % 2 != 0) {
	            return false;
	        }
	        sum /= 2;
	        int row = nums.length + 1;
	        int col = sum + 1;
	        //cache[i][j] = true if a subset of {nums[0], nums[1], ..nums[i-1]} has sum 
            //equal to j, otherwise false
	        boolean[][] cache = new boolean[row][col];
	        cache[0][0] = true;
	        for (int i = 1; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                if (cache[i-1][j] || (j-nums[i-1] >= 0 && cache[i-1][j-nums[i-1]])) { // the i-th element is nums[i-1] here
	                    cache[i][j] = true;
	                }
	            }
	        }
	        for(int i=0;i<cache.length;i++)
	        {
	        	for(int j=0;j<cache[0].length;j++)
	        	{
	        		  System.out.println("i "+i+" j "+j+" "+cache[i][j]);
	        	}
	        }
	      
	        return cache[row-1][col-1];
	 }
	 
	 
	 public static List<List<Integer>> subsets(int[] S) {
		    List<List<Integer>> result = new ArrayList<List<Integer>>();
		   
		    if(S.length == 0){
		        return result;
		    }
		    
		    Arrays.sort(S);
		    dfs(S, 0, new ArrayList<Integer>(), result);
		    return result;
		}

		public static void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
		    result.add(new ArrayList<Integer>(path));
		    System.out.println("result "+result);
		    for(int i = index; i < s.length; i++){
		        path.add(s[i]);
		        System.out.println("path "+path);
		        dfs(s, i+1, path, result);
		        path.remove(path.size()-1);
		        System.out.println("path "+path);
		    }
	 
}
}
