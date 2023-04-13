package main;

import java.util.stream.IntStream;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import models.ListNode;
import models.TreeNode;
import tools.ArraysMethods;
import tools.BasicMaths;
import tools.BinarySearch;
import tools.BinaryTrees;
import tools.DijkstraAlgorithm;
import tools.Graphs;
import tools.LinkedLists;
import tools.Strings;
public class JavaTools {
	static Graphs graphs = new Graphs();
	private static DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
	private static Strings string = new Strings();
	static LinkedLists linkedLists = new LinkedLists();
	private static BinarySearch binarySearch = new BinarySearch();
	private static BasicMaths basicMaths = new BasicMaths();
	private static ArraysMethods arrays = new ArraysMethods();
	private static BinaryTrees binaryTrees = new BinaryTrees();
	static String case1 = "aab";
	static String case2 = "pwwkew";
	static String case3 = "dvdf";
	static String case4 = "baba";
	static String case5 = "zxabcdezyi";

	public static void main(String[] args) {

		try {
			System.out.println("aaaa:::" + string.lengthOfLongestSubstring(case5));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	static TreeNode ex1TreeNode = new TreeNode(10, new TreeNode(6, new TreeNode(4), new TreeNode(8)), new TreeNode(11));
	static TreeNode treeNodeSimetric = new TreeNode(10, new TreeNode(6, new TreeNode(4), new TreeNode(8)),
			new TreeNode(11));
	static TreeNode ex1TreeNode2 = new TreeNode(1, null, new TreeNode(2));
	static TreeNode non_balanced_tree = new TreeNode(1, new TreeNode(2,
			new TreeNode(4, new TreeNode(4), new TreeNode(8)), new TreeNode(8, new TreeNode(4), new TreeNode(8))),
			null);
	static TreeNode ex1TreeNode4 = new TreeNode(1, null, new TreeNode(1));
	static TreeNode high_balanced_tree = new TreeNode(1, new TreeNode(1), new TreeNode(1));
	static TreeNode simetric1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
			new TreeNode(2, new TreeNode(4), new TreeNode(3))); // [1,2,2,3,4,4,3]
	static TreeNode ex1TreeNode5 = new TreeNode(1, new TreeNode(1), null);
	static int[] int_array_no_elements = { 0 };
	static int[] int_array_one_element = { 1 };
	static int[] testfruits = { 1, 2, 3, 2, 2 };
	static int[] testfruits2 = { 0, 1, 2, 2 };
	static int[] test = { 1, 2, 3, 0, 0, 0 };
	static int[] testNumber = { -1, -1, -2 };
	static int[] test2 = { 2, 5, 6 };
	static int[] testCaase1 = IntStream.of(1, 3, 5, 6).toArray();
	static int[] testCaase2 = IntStream.of(1, 3, 5, 6, 7, 8, 9, 11, 12).toArray();
	static int[] testCaase3 = IntStream.of(1, 3).toArray();
	static ListNode listNode1 = new ListNode(-3, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(5)))));
	static ListNode listNode2 = new ListNode(4, new ListNode(6, new ListNode(7)));
	static ListNode LN_ex1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
	static ListNode LN_ex2 = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50)))));
	static ListNode LN_ex3 = new ListNode(2, new ListNode(4, new ListNode(3)));
	static ListNode LN_ex4 = new ListNode(5, new ListNode(6, new ListNode(4)));

	static ListNode bucleNode = linkedLists.infinite_linked_list();
	static TreeNode balancedTree = new TreeNode(1,
			new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
			new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
}
