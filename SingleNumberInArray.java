package com.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class SingleNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {1,2,3,4,1,2,4,3,5};
		//System.out.println(singleNumber(A));
		
		int[] B = {3,3,5,1,10,1,10};
		//System.out.println(duplicate(B));
		
		//System.out.println(SingleNumber(B));
		
		int[] arr2 = {1,1,1,2};
		System.out.println(singleNumberII(arr2));
		
		int[] arr3 = {1,2,1,3,2,5};
		//System.out.println(singleNumberIII(arr3));
		
		
	}

	
	public static int singleNumber(int[] A) {

		Hashtable<Integer, Integer> nums = new Hashtable<Integer, Integer>();
	    int result = -1;
	    
	    for (int i = 0; i < A.length; i++) {
	        Integer val = nums.get(A[i]);
	        if (val == null)
	            nums.put(A[i], 1);
	        else
	            nums.put(A[i], val + 1);
	    }
	    
	    Enumeration<Integer> keys = nums.keys();
	    while (keys.hasMoreElements()) 
	    {
	        int k = keys.nextElement();
	        if (nums.get(k) == 1) 
	        	result = k;
	    }
	    
	    return result;
	}
	
	public static String duplicate(int[] numbers){
	    

	    List<Integer> list = new ArrayList<Integer>();
	    
	    Arrays.sort(numbers);
	    int count = 1;
	    for(int i = 0;i<numbers.length-1;i++)
	    {
	        if(numbers[i] == numbers[count])
	            list.add(numbers[i]);
	        count++;
	    }
	 
	    return list.toString();
	}
	
	public static int SingleNumber(int[] arr)
	{
		int x = 0;
		for (int a : arr) {
			x = x ^ a;
			System.out.println(x);
		}
		return x;
	}
	
	
	
	public static int singleNumberII(int A[]) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
      //http://leetcodesolutions.blogspot.com/2013/10/single-number-ii.html
		int one =0, two =0;
      for(int i = 0;i<A.length;i++)
      {
          int one_= (one^A[i])& ~two;
          int two_= (A[i] & one) | (~A[i] & two);
          System.out.println("one_ "+one_+" two_ "+two_);
          one = one_;
          two = two_;
      }
        return one;
    }

	
	
	 public static  int[] singleNumberIII(int[] nums) 
	 {
	        if (nums == null || nums.length == 0) 
	        {
	            return new int[0];
	        }
	         
	        int xor = 0;
	         
	        // Step 1: calculate the xor for all numbers
	        // So the result is the xor of the two single numbers
	        for (int num : nums) 
	        {
	            xor ^= num;
	        }
	         //All the bits that are set in xor will be set
	        //in one non-repeating element (x or y) and not in other. 
/* So if we take any set bit of xor and divide the elements of the array in two sets 
 * – one set of elements with same bit set and other set with same bit not set. 
 * By doing so, we will get x in one set and y in another set. 
 * Now if we do XOR of all the elements in first set, 
 * we will get first non-repeating element, and by doing same in other set 
 * we will get the second non-repeating element. */	        
	        // Step 2: find the first bit 1 from right
	        int mask = 1;
	        while ((mask & xor) == 0) 
	        {
	            mask = mask << 1;
	        }
	         
	        int xor1 = 0;
	        int xor2 = 0;
	         
	        for (int num : nums) 
	        {
	            if ((num & mask) == 0) 
	            {
	                xor1 ^= num;
	            } 
	            else 
	            {
	                xor2 ^= num;
	            }
	        }
	         
	        int[] result = new int[]{xor1, xor2};
	         
	        return result;
	    }

}
