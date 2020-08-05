package com.aeliter.mafengwo;

public class LinkedListContainsLoop {
	
	class ListNode {
		ListNode next;
	}
	
	boolean isLinkedListContainsLoop(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		while (slowPtr.next != null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}
	
}
