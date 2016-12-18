package com.Arrays;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		System.out.println(searchMatrix(arr, 3));
		
		int[][] arr1 = {{5,6}};
		System.out.println(searchMatrixII(arr1, 5));
		
		int[] arr2={1,2,3,1};
		System.out.println(findPeakElement(arr2));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) 
	{
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int m=matrix.length;
		int n=matrix[0].length;
        
		int low = 0;
		int high = m*n-1;
		
		while(low <= high)
		{
			int mid=(low+high)/2;
			int midX = mid/n;
			int midY = mid%n;
			if(target == matrix[midX][midY])
			{
				return true;
			}
			else if(matrix[midX][midY] < target)
			{
				low = mid+1;
			}
			else
			{
				high = mid-1;
			}
		}
		return false;
    }
	
	  public static boolean searchMatrixII(int[][] matrix, int target) 
	  {
		  if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return false;
		  int m=matrix.length-1;
		  int n=matrix[0].length-1;
		  
		  int i=m;
		  int j=0;
		  while(i>=0 && j<=n)
		  {
			  if(target > matrix[i][j])
			  {
				  j++;
			  }
			  else if(target < matrix[i][j])
			  {
				  i--;
				  j++;
			  }
			  else
			  {
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  public static int findPeakElement(int[] nums) 
	  {
		  int n = nums.length;
	        if(n == 1) {
	            return 0;
	        }

	        int start = 0;
	        int end = n - 1;
	        int mid = 0;

	        while(start <= end) 
	        {
	            mid = start + (end - start) / 2;
	            if((mid == 0 || nums[mid] >= nums[mid - 1]) &&
	               (mid == n - 1 || nums[mid] >= nums[mid + 1])) 
	            {
	                    return mid;
	            }
	            else if(mid > 0 && nums[mid-1] > nums[mid]) 
	            {
	                end = mid - 1;
	            } 
	            else 
	            {
	                start = mid + 1;
	            }
	        }
	        return mid;
	    }
}
	
