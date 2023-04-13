package tools;

import java.util.List;

public class BinarySearch {

	List<Integer> test = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

	// I'll try the problem using recursion
	// a prerrequisi for binarysearch is that the integers list must by ordered.
	// first I going to implement the iterative way
	public int binary_search_iterative(int [] integerList, int target) {

			int low = 0;
			int high = integerList.length - 1;
			int mid = 0;
			while (low < high) {
				mid = (low + high) / 2;
				if (integerList[mid] > target) {
					high = mid - 1;
				} else if (integerList[mid]< target) {
					low = mid + 1;
				} else if (integerList[mid] == target) {
					return mid;
				}
			}
			// if the code reach this part is because the value wasn't found
			  return (target < integerList[0])? 0 :(target > integerList[integerList.length-1])? integerList.length:  mid+1;
	}
}
