package tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import models.ListNode;

public class LinkedLists {

	public ListNode infinite_linked_list() {
		ListNode infinite_linked_list = new ListNode(2);
		ListNode a = new ListNode(1, infinite_linked_list);
		infinite_linked_list.next = a;
		return infinite_linked_list;
	}

	// works but with low performance
	public ListNode order_linked_List(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		} else if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}
		List<Integer> listOfNumber = new ArrayList<>();
		while (list1 != null) {
			listOfNumber.add(list1.val);
			list1 = list1.next;
		}
		while (list2 != null) {
			listOfNumber.add(list2.val);
			list2 = list2.next;
		}
		Collections.sort(listOfNumber);

		ListNode answer = new ListNode(0);
		ListNode tail = answer;
		for (Integer number : listOfNumber) {
			tail.next = new ListNode(number, null);
			tail = tail.next;
		}
		return answer.next;
	}

	// works but with low performance
	public ListNode order_linked_List_remove_with_Set(ListNode list1) {
		if (list1 == null) {
			return null;
		}
		Set<Integer> listOfNumber = new HashSet<>();
		while (list1 != null) {
			listOfNumber.add(list1.val);
			list1 = list1.next;
		}
		TreeSet<Integer> sort = new TreeSet<>(listOfNumber);
		ListNode answer = new ListNode(0);
		ListNode tail = answer;
		for (Integer number : sort) {
			tail.next = new ListNode(number, null);
			tail = tail.next;
		}
		return answer.next;
	}

	/**
	 * @author LENOVO new algorithm --> tortoise and hate algorithm This was using
	 *         the algorhim called the tortouse and the hate, basiclly i use two
	 *         pointer to loop the linkedList and wait to them to find themselves.
	 *         Otherwise the list will be over and the pointers will never find each
	 *         over. So the list has not a bucle
	 */

	public boolean hasCycle(ListNode head) {
		// two pointers
		ListNode p1 = null;
		ListNode p2 = null;
		if (head == null) {
			return false;
		}
		p1 = head;
		p2 = head;
		while (p2.next != null && p2.next.next != null) {
			p2 = p2.next.next;
			p1 = p1.next;
			if (p1 == p2) {
				return true;
			}
		}
		return false;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode list1 = headA;
		while (list1 != null) {
			ListNode temp2 = headB;
			while (temp2 != null) {
				if (list1 == temp2) {
					return list1;
				}
				temp2 = temp2.next;
			}
			list1 = list1.next;
		}
		return null;
	}

	public ListNode getIntersectionNodeChatGPT(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pA = headA;
		ListNode pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}

		return pA;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode tail = head;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = carry;
			if (l1 != null) {
				
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			tail.next = new ListNode(sum % 10);
			// sub to that carry is from int type it is going to save always the int value
			// of the expression.
			carry = sum / 10;
			tail = tail.next;
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}

		return head.next;
	}
	/**
	 * The main idea is to reduce the spaced used in this algorithm by reusing the var called l1.
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode tail = head;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = carry;
			if (l1 != null) {
				
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			tail.next = new ListNode(sum % 10);
			// sub to that carry is from int type it is going to save always the int value
			// of the expression.
			carry = sum / 10;
			tail = tail.next;
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}

		return head.next;
	}
}
