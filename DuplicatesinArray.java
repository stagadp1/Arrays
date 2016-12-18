package com.Arrays;

import java.util.*;


public class DuplicatesinArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] arr = {1,2,4,7,3,6,7,6};
		System.out.println(duplicate(arr));
		
		System.out.println(findDuplicates(arr));
	}
		
//		
//		duplicates(arr);
//		
//		String[] names = { "Java", "JavaScript", "Python", "C", "Ruby", "Java" };
//
//        // First solution : finding duplicates using brute force method
//        System.out.println("Finding duplicate elements in array using brute force method");
//        for (int i = 0; i < names.length; i++) {
//            for (int j = i + 1; j < names.length; j++) {
//                if (names[i].equals(names[j]) ) {
//                   System.out.println(names[i]);
//                }
//            }
//        }
//
//		
//		 // Second solution : use HashSet data structure to find duplicates
//        System.out.println("Duplicate elements from array using HashSet data structure");
//        Set<String> store = new HashSet<>();
//
//        for (String name : names) {
//            if (store.add(name) == false) {
//                System.out.println("found a duplicate element in array : "
//                        + name);
//            }
//        }
//		
//		// Third solution : using Hash table data structure to find duplicates
//        System.out.println("Duplicate elements from array using hash table");
//		Map<String, Integer> nameAndCount = new HashMap<>();
//
//        // build hash table with count
//        for (String name : names) {
//            Integer count = nameAndCount.get(name);
//            if (count == null) {
//                nameAndCount.put(name, 1);
//            } else {
//                nameAndCount.put(name, ++count);
//            }
//        }
//		
//		Set<Entry<String, Integer>> entrySet = nameAndCount.entrySet();
//        for (Entry<String, Integer> entry : entrySet) {
//
//            if (entry.getValue() > 1) {
//                System.out.println("Duplicate element from array : "
//                        + entry.getKey());
//            }
//        }
//		
//
//	}
//
//	public static void duplicates(int[] arr)
//	{
//		Set<Integer> dupes = new HashSet<Integer>();
//		for (Integer i : arr) 
//		{ 
//			if (!dupes.add(i)) 
//			{ 
//				System.out.println("Duplicate element in array is : " + i); 
//			} 
//		}
//
//	}
//	
	public static String duplicate(int[] numbers){
	    TreeSet<Integer> tset = new TreeSet<Integer>();
	    
	   List <Integer> list= new ArrayList<Integer>();
	    for(int i=0;i<numbers.length;i++)
	    {
	        if(!tset.add(numbers[i]))
	        {
	            list.add(numbers[i]);
	        }
	    }
	    return list.toString();
	}
	
	public static List<Integer> findDuplicates(int[] nums)
	{
		int i=0;
		List<Integer> result = new ArrayList<Integer>();
		Arrays.sort(nums);
		while(i<nums.length-1)
		{
			if(nums[i] == nums[i+1])
			{
				result.add(nums[i]);
				i++;
			}
			i++;
		}
		return result;
	}
}
