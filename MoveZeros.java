package com.Arrays;
import java.util.*;

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,0,3,12};
		//moveZeroes(nums);
		
		int[][]matrix={{1,1,1,0},{1,1,1,0},{1,1,0,0},{1,0,0,0}};
		setZeroes(matrix);
		}

	 public static void moveZeroes(int[] nums) {
	        
	      // Arrays.sort(nums);
	       int count =0;
		 for(int i = 0;i<nums.length;i++)
		 {
			 if(nums[i]==0)
				 count++;
			 else if(nums[i]!=0)
			 {
				 nums[i-count] = nums[i];
			 }
		 }
		 
		 for(int i=nums.length-count;i<nums.length;i++)
		 nums[i] = 0;
		 for(int j=0;j<nums.length;j++)
			 System.out.println(nums[j]);
	 }

	 public static void setZeroes(int[][] matrix) 
	 {
		 boolean firstRowZero = false;
	     boolean firstColumnZero = false;   
		 
	     // 1. Set first row or column is zero or not.
		 for(int i=0;i<matrix.length;i++)
		 {
			 if(matrix[i][0] == 0)
				 firstColumnZero=true;
		 }
		 
		 for(int j=0;j<matrix[0].length;j++)
		 {
			 if(matrix[0][j] == 0)
				 firstRowZero=true;
		 }
		 
		 // 2. Mark zeros on first row and column.
		 for(int i=1;i<matrix.length;i++)
		 {
			 for(int j=1;j<matrix[0].length;j++)
			 {
				 if(matrix[i][j] == 0)
				 {
					 matrix[i][0] = 0;
					 matrix[0][j] = 0;
				 }
			 }
		 }
		 
		 // 3. Use this mark to set other/inner elements.
		 for(int i=1;i<matrix.length;i++)
		 {
			 for(int j=1;j<matrix[0].length;j++)
			 {
				 if( matrix[i][0] == 0 || matrix[0][j] == 0)
				 {
					 matrix[i][j]=0;
				 }
			 }
		 }
		 
		 // 4. Set first row and column by using marks in step 1.
		 if(firstColumnZero==true)
		 {
			 for(int i=0;i<matrix.length;i++)
			 {
				 matrix[i][0] = 0;
			 }
		 }
		 
		 if(firstRowZero == true)
		 {
			 for(int j=0;j<matrix[0].length;j++)
			 {
				 matrix[0][j] = 0;
			 }
		 }
			 
		 for(int i=0;i<matrix.length;i++)
		 {
			 for(int j=0;j<matrix[0].length;j++)
			 {
				 System.out.println(matrix[i][j]);
			 }
		 }
	 }
}
