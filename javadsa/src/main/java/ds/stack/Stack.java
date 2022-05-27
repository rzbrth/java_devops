package ds.stack;

/*
 * push() : Insert a new element into stack i.e inserting a new element at the beginning
   pop() : Return top element of the Stack i.e deleting the first element from the linked list.
   peek(): Return the top element.
 */
public class Stack {

	private static class Node {
		private int data;
		private Node prev;

		private Node(int data) {
			this.data = data;
		}
	}

	private Node top; // add remove from top

	public boolean isEmpty() {
		return top == null;
	}

	public int peek() {
		return top.data; // may throw exception
	}

	public void push(int data) {
		Node node = new Node(data);

		if (isEmpty()) {
			top = node;
		} else {
			node.prev = top;
			top = node;
		}

	}

	public int pop() {
		int data = 0;
		if (top != null) {
			data = top.data;
			top = top.prev;
		}
		return data;

	}
}
