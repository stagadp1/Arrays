package com.Arrays;

public class SpiralTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		//spiral(arr);
		
		int[][] arr2 = spiralII(3);
		for(int i=0;i<arr2.length;i++)
		{
			for(int j=0;j<arr2[0].length;j++)
			{
				System.out.println(arr2[i][j]);
			}
		}
	}

	public static void spiral(int[][] arr)
	{
		int row = arr.length;
		int col = arr[0].length;
		int top = 0, bottom = row - 1, left = 0, right =col-1;
		int dir = 0; // 0(right) 1(bottom) 2(left) 3(up)
		while(top <= bottom && left <= right) // because top moving towards bottom and left moving towards right
		{
			if(dir == 0)
			{
				for(int i= left;i<=right;i++)
				{
					System.out.println(arr[top][i]);
				}
				top++;
				dir=1;
			}
			else if(dir == 1)
			{
				for(int i= top;i<=bottom;i++)
				{
					System.out.println(arr[i][right]);
				}
				right--;
				dir = 2;
			}
			else if(dir == 2)
			{
				for(int i=right;i>=left;i--)
				{
					System.out.println(arr[bottom][i]);
				}
				bottom--;
				dir=3;
			}
			else if(dir == 3)
			{
				for(int i=bottom;i>=top;i--)
				{
					System.out.println(arr[i][left]);
				}
				left++;
				dir=0;
			}
		}
	}
	
	
	public static int[][] spiralII(int num)
	{
		
		int row = num;
		int col = num;
		int[][] arr = new int[row][col];
		int top = 0, bottom = row - 1, left = 0, right =col-1;
		int dir = 0; // 0(right) 1(bottom) 2(left) 3(up)
		int count = 1;
		while(top <= bottom && left <= right && count <= num*num) // because top moving towards bottom and left moving towards right
		{
			if(dir == 0)
			{
				for(int i= left;i<=right;i++)
				{
					arr[top][i] = count;
					count++;
				}
				top++;
				dir=1;
			}
			else if(dir == 1)
			{
				for(int i= top;i<=bottom;i++)
				{
					arr[i][right] = count;
					count++;
				}
				right--;
				dir = 2;
			}
			else if(dir == 2)
			{
				for(int i=right;i>=left;i--)
				{
					arr[bottom][i]= count;
					count++;
				}
				bottom--;
				dir=3;
			}
			else if(dir == 3)
			{
				for(int i=bottom;i>=top;i--)
				{
					arr[i][left]= count;
					count++;;
				}
				left++;
				dir=0;
			}
		}
		return arr;
	}

}
