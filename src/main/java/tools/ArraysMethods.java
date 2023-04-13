package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysMethods {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		m = nums1.length;

		while (n > 0) {
			if (nums1[nums1.length - m] == 0) {

				nums1[nums1.length - m] = nums2[nums2.length - n];
				n--;
			}
			m--;
		}
		Arrays.sort(nums1);
	}

	public void merge_with_pointers(int[] nums1, int m, int[] nums2, int n) {
		int[] temp = nums1.clone();

		int list1pointer = 0;
		int list2pointer = 0;
		int elementInList = 0;
		while (list1pointer < m && list2pointer < n) {
			if (temp[list1pointer] < nums2[list2pointer]) {
				nums1[elementInList++] = temp[list1pointer++];
			} else {
				nums1[elementInList++] = nums2[list2pointer++];

			}
		}

		while (list1pointer < m) {
			nums1[elementInList++] = temp[list1pointer++];
		}

		while (list2pointer < n) {
			nums1[elementInList++] = nums2[list2pointer++];
		}

		System.out.println(nums1);
	}

	public int[] shuffle(int[] nums, int n) {
		int pointer = 0;
		int initial_y_value = nums.length - n;
		int[] list = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 != 0) {
				list[i] = nums[initial_y_value++];
			} else {
				list[i] = nums[pointer++];
			}
		}
		return list;
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascalTriangel = new ArrayList<>();
		pascalTriangel.add(Arrays.asList(1));
		if (numRows != 1) {
			pascalTriangel.add(Arrays.asList(1, 1));

		}
		for (int i = 0; i < numRows; i++) {
			if (i < 2) {
				continue;
			}
			int row = i;
			List<Integer> previus = pascalTriangel.get(i - 1);
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j <= row; j++) {
				if (j == 0 || j == row) {
					list.add(1);
				} else {
					list.add(previus.get(j - 1) + previus.get(j));
				}
			}
			pascalTriangel.add(list);
		}
		return pascalTriangel;
	}

	public List<Integer> getRow(int numRows) {
		List<List<Integer>> pascalTriangel = new ArrayList<>();
		pascalTriangel.add(Arrays.asList(1));
		pascalTriangel.add(Arrays.asList(1, 1));
		if (numRows == 0)
			return pascalTriangel.get(0);

		for (int i = 0; i <= numRows; i++) {
			if (i < 2) {
				continue;
			}
			int row = i;
			List<Integer> previus = pascalTriangel.get(i - 1);
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j <= row; j++) {
				if (j == 0 || j == row) {
					list.add(1);
				} else {
					list.add(previus.get(j - 1) + previus.get(j));
				}
			}
			pascalTriangel.add(list);
		}
		return pascalTriangel.get(numRows);
	}

	public boolean isPalindrome(String s) {

		char[] word = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "").toCharArray();
		int last = word.length - 1;
		for (int i = 0; i < word.length / 2; i++) {
			if (word[i] != word[last--]) {
				return false;
			}
		}
		return true;
	}

	public int totalFruit(int[] fruits) {
//		if (fruits.length <= 2) {
//			return fruits.length;
//		}
		int fruit_one = 0;
		int fruit_two = 0;
		int fruit_two_count = 0;
		int current_max = 0;
		int max = 0;
		for (int fruit : fruits) {
			if (fruit == fruit_two) {
				fruit_two_count++;
			} else {
				fruit_two_count = 1;
			}
			if (fruit == fruit_one || fruit == fruit_two) {
				current_max++;
			} else {
				fruit_one = fruit_two;
				fruit_two = fruit;
				current_max = fruit_two_count + 1;
				fruit_two_count = 1;
			}

			max = (max > current_max) ? max : current_max;

		}
		return max;
	}

	// sliding window Tecnique.

	public int totalFruitII(int[] fruits) {
		int fruit_one = 0;
		int fruit_two = 0;
		int fruit_two_count = 0;
		int current_max = 0;
		int max = 0;
		for (int fruit : fruits) {
			if (fruit == fruit_one || fruit == fruit_two) {
				current_max++;
			} else {
				current_max = fruit_two_count + 1;
			}
			if (fruit == fruit_two) {
				fruit_two_count++;
			} else {
				fruit_two_count = 1;
				fruit_one = fruit_two;
				fruit_two = fruit;
			}

			max = (max > current_max) ? max : current_max;

		}
		return max;
	}

	public int maxProfit(int[] prices) {
		int max_profit = 0;
		int min_value_aleady_checked = 999999;
		for (int i = 0; i < prices.length; i++) {
			int value_of_day = prices[i];
			if (value_of_day >= min_value_aleady_checked) {
				continue;

			} else {
				min_value_aleady_checked = value_of_day;
				for (int j = i + 1; j < prices.length; j++) {
					int value_next_day = prices[j];
					if (value_of_day >= value_next_day) {
						continue;
					}
					int difference = value_next_day - value_of_day;
					if (difference > max_profit) {
						max_profit = difference;
					}
				}
			}

		}
		return max_profit;
	}

	public int maxProfitII(int[] prices) {
		int max_profit = 0;
		int current_profit = 0;
		int less_value = 9999;
		for (int price : prices) {
			if (price >= less_value) {
				
			} else {
				less_value = price;
			}
			if (price > less_value) {
				current_profit = price -less_value;
			}
			max_profit = (max_profit > current_profit) ? max_profit : current_profit;
		}
		return max_profit;
	}
}
