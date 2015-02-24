package com.sonal.dsnalgo.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		List<Integer> numbersList = new ArrayList<Integer>();
		numbersList.add(1);
		numbersList.add(2);
		numbersList.add(3);
		numbersList.add(4);
		numbersList.add(5);
		numbersList.add(6);
		numbersList.add(7);
		numbersList.add(8);
		numbersList.add(9);
		numbersList.add(10);
		numbersList.add(11);
		doBinarySearch(numbersList, 5);
		doBinarySearch(numbersList, 11);
		doBinarySearch(numbersList, 0);
		doBinarySearch(numbersList, 1);

	}

	public static void doBinarySearch(List<Integer> numbersList, int numberToSearch) {

		int sizeOfNumbersList = numbersList.size();

		int minIndex = 0;
		int maxIndex = sizeOfNumbersList - 1;
		int midIndex = maxIndex / 2;

		Integer searchedIndex = binarySearch(numbersList, numberToSearch, maxIndex, minIndex, midIndex);
		
		if(searchedIndex != null){
			System.out.println("Found !!");
			System.out.println(numberToSearch +  " :: Found At Index :: " + searchedIndex);
		}else{
			System.out.println("XXXXXXXXXXXXXXXXXXXX");
			System.out.println("Not Found");
			System.out.println("XXXXXXXXXXXXXXXXXXXX");
		}

	}

	private static Integer binarySearch(List<Integer> numbersList, Integer numberToSearch, Integer maxIndex, Integer minIndex, Integer midIndex) {

		Integer midNumber = numbersList.get(midIndex);
		Integer indexOfNumberToSearch = null;

		if (midIndex == maxIndex && numberToSearch != numbersList.get(midIndex)) {
			//System.out.println("Not Found");
		} else {
			if (numberToSearch == midNumber) {
				//System.out.println("Found !!");
				indexOfNumberToSearch = midIndex;
			} else {
				if (numberToSearch <= midNumber) {
					maxIndex = midIndex;
					midIndex = (minIndex + maxIndex) / 2;
					indexOfNumberToSearch = binarySearch(numbersList, numberToSearch, maxIndex, minIndex, midIndex);
				} else {
					minIndex = midIndex + 1;
					midIndex = (minIndex + maxIndex) / 2;
					indexOfNumberToSearch = binarySearch(numbersList, numberToSearch, maxIndex, minIndex, midIndex);
				}
			}
		}
		return indexOfNumberToSearch;
		

	}

}
