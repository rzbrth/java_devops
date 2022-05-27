package ds.linkedlist;

public class FindLoopInLinkedList {

	Node head;

	public static boolean isLoopPresent(Node head) {

		if (head == null || head.next == null) {
			return false;
		}
		Node fast = head.next;
		Node slow = head;
		while (fast != null && fast.next != null & slow != null) {
			if (fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;

		}

		return false;
	}
}
