package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import models.TreeNode;

public class BinaryTrees {

	public TreeNode in_order_traversal_bad_answer(TreeNode binary_tree) {
		TreeNode left_Side = binary_tree;
		TreeNode right_Side = binary_tree.right;
		HashMap<String, Integer> keys_and_order = new HashMap<>();
		int pointerLeft = 0;
		int pointerRight = 0;
		keys_and_order.put("left_root", binary_tree.left.val);
		while (left_Side.left != null) {
			left_Side = left_Side.left;
			keys_and_order.put("right" + pointerLeft + " : ", (left_Side.right != null) ? left_Side.right.val : 0);
			keys_and_order.put("left" + pointerLeft++ + " :", left_Side.val);
		}
		keys_and_order.put("right_root", binary_tree.right.val);
		while (right_Side.left != null) {
			right_Side = right_Side.left;
			keys_and_order.put("right" + pointerRight + " : ", (right_Side.right != null) ? right_Side.right.val : 0);
			keys_and_order.put("left" + pointerRight++ + " :", right_Side.val);
		}
		System.out.println(left_Side);
		System.out.println(right_Side);
		System.out.println(keys_and_order);
		return left_Side;
	}

	public List<Integer> in_order_traversal_recursive_wrapper(TreeNode binary_tree) {
		List<Integer> ans = new ArrayList<>();
		in_order_traversal_recursive(binary_tree, ans);
		return ans;
	}

	public boolean in_order_traversal_recursive_comparator(TreeNode binary_tree, TreeNode binary_tree2) {
		List<Integer> ans = new ArrayList<>();
		List<Integer> ans2 = new ArrayList<>();
		in_order_traversal_recursive(binary_tree, ans);
		in_order_traversal_recursive(binary_tree2, ans2);
		return ans.equals(ans2);
	}

	public boolean isSame(TreeNode p, TreeNode q) {
		return (p == q)
				|| (p != null && q != null && p.val == q.val && isSame(p.left, q.right) && isSame(p.right, q.left));
	}

	// Helper function to get the height of a binary tree.
	private int getHeight(TreeNode tree) {
		if (tree == null) {
			return 0;
		}
		return Math.max(getHeight(tree.left), getHeight(tree.right)) + 1;
	}

	public boolean isBalancedII(TreeNode tree) {
		if (tree == null || (Math.abs(getHeight(tree.left) - getHeight(tree.right)) > 1)) {
			return false;
		}

		return isBalanced(tree.left) == isBalanced(tree.right);
	}

	public boolean isBalanced(TreeNode tree) {
		// Base case: An empty tree is height-balanced.
		if (tree == null) {
			return true;
		}

		// Check if the height difference between the left and right subtrees is at most
		// 1.
		int leftHeight = getHeight(tree.left);
		int rightHeight = getHeight(tree.right);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}

		// Recursively check if the left and right subtrees are height-balanced.
		return isBalanced(tree.left) == isBalanced(tree.right);
	}

	public boolean isSameSame(TreeNode p) {
		return (p != null && isSame(p.left, p.right));
	}

	public int tree_max_deepth_wrapper(TreeNode tree) {
		return tree_max_deepth(tree, 0);
	}

	public int tree_max_deepth(TreeNode p, int max_value) {
		if (p == null) {
			System.out.println(max_value);
			return max_value;
		}
		max_value++;
		int a = tree_max_deepth(p.left, max_value);
		int b = tree_max_deepth(p.right, max_value);
		// return max_value;
		return a > b ? a : b;
	}
	/**
	 * in this Algorithm we just sum each node, the important step here is to know that 
	 * we are looking for the leaf node
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left == null) {
			return 1 + minDepth(root.right);
		} else if (root.right == null) {
			return 1 + minDepth(root.left);
		} else {
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));
		}
	}	

	public TreeNode sortedArray_To_BST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		int middle = nums.length / 2;
		int[] newArray = Arrays.copyOfRange(nums, 0, middle);
		int[] newArra2 = Arrays.copyOfRange(nums, middle, nums.length - 1);
		TreeNode root = new TreeNode(nums[middle]);
		root.left = sortedArray_To_BST(newArray);
		root.right = sortedArray_To_BST(newArra2);
		return root;
	}

	public void in_order_traversal_recursive(TreeNode binary_tree, List<Integer> ans) {
		ans.add(0);
		if (binary_tree == null) {
			return;
		}

		in_order_traversal_recursive(binary_tree.left, ans);
		ans.add(binary_tree.val);
		in_order_traversal_recursive(binary_tree.right, ans);
	}

}
