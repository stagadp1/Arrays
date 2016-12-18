	package com.Arrays;

public class HorizontalFlip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = {{1,1,3},{0,0,4},{2,4,5}};
		
		HFlip(arr);
		PrintArray(arr);
	}

	public static void HFlip(int[][] arr)
	{
		//System.out.println(arr.length);
		
		int len = arr.length;
		for(int i=0;i<arr.length/2;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				int temp = arr[i][j];
				arr[i][j] = arr[len-1-i][j];
				arr[len-1-i][j] = temp;
			}
		}
		
	}
	
	public static void VFlip(int[][] matrix)
	{
		int columns = matrix[0].length;
	    int rows = matrix.length;
	    int temp = 0;
	    
	    for(int i = 0; i < rows; i++){
	        for(int j = 0; j < columns/2; j++){
	            temp = matrix[i][j];
	            matrix[i][j] = matrix[i][columns - j -1];
	            matrix[i][columns - j -1] = temp;
	        }
	    }
	}
	
	public static void PrintArray(int[][] arr )
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				System.out.println(arr[i][j]);
			}
		}	
	}
}
