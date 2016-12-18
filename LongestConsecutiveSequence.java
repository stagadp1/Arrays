package com.Arrays;

import java.util.*;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {100, 4, 200, 1, 3, 2, 6, 7, 9};
		System.out.println(longestconsecutiveelement(arr));
		System.out.println(longestconsecutiveelement2(arr));
		
		
		
	}

	
	public static int longestconsecutiveelement(int[] arr)
	{
	    if(arr.length==0)
	        return 0;
	    Set<Integer> set = new HashSet<Integer>();
	    
	    
	    for(int i:arr)
	    {
	        set.add(i);
	    }
	    int length=1;
	    for(int j:arr)
	    {
	        int left = j-1;
	        int right = j+1;
	        int count = 1;
	        
	        
	        while(set.contains(left))
	        {
	            count++;
	            set.remove(left);
	            left--;
	        }
	        
	        
	        while(set.contains(right))
	        {
	            count++;
	            
	            set.remove(right);
	            right++;
	        }
	        
	     length = Math.max(count,length);
	        
	    
	        
	    }
	    return length;
	    
	}
	
	
	public static int longestconsecutiveelement2(int[] arr)
	{
		int ans=0;
		HashSet<Integer> S = new HashSet<Integer>();
		 
		 for(int i:arr)
		 {
			S.add(i);
		 }
		 
		 for(int i=0;i<arr.length;i++)
		 {
			  if (!S.contains(arr[i]-1))
	            {
				  
				  	int j = arr[i];
					
				  	while (S.contains(j))
				  		j++;
				  	
				  	
				  	 
				  	if(ans < j-arr[i])
				  		ans=j-arr[i];
	            }
           
		 }
		 return ans;
	}
}
