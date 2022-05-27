package ds.string;

import java.util.Stack;

public class BalancedParentheses {

	// Create 2d array with all brackets
	public static char[][] TOKEN = { { '{', '}' }, { '(', ')' }, { '[', ']' } };

	public static boolean isBalanced(String exp) {

		if (exp == null) {
			throw new RuntimeException("Exp can't be null or empty");
		}
		Stack<Character> stack = new Stack<>();

		for (char c : exp.toCharArray()) {
			// if bracket is type open add to stack
			if (isOpenChar(c)) {
				stack.push(c);
			} else {
				// if stack empty or bracket is not matching stack top then return false
				if (stack.isEmpty() || !matches(stack.pop(), c)) {
					return false;
				}
			}

		}

		return stack.isEmpty();
	}

	private static boolean matches(Character open, char close) {
		for (char[] c1 : TOKEN) {
			// first check if open char matches with first element of array
			if (c1[0] == open) {
				// check for second element, since it will contain closed bracket
				return c1[1] == close;
			}

		}

		return false;
	}

	private static boolean isOpenChar(char c) {

		for (char[] c1 : TOKEN) {
			// check for first element, since it will contain open bracket
			return c1[0] == c;

		}

		return false;
	}

	/*
	 * Approach 2
	 */
	public static boolean isBalanced2(String exp) {

		Stack<Character> stack = new Stack<>();
		for (char c : exp.toCharArray()) {

			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {

				if (stack.isEmpty()) {
					return false;
				}

				char c1 = stack.pop();
				switch (c) {

				case ')':
					if (c1 == '}' || c1 == ']') {
						return false;
					}
					break;
				case '}':
					if (c1 == ')' || c1 == ']') {
						return false;
					}
					break;
				case ']':
					if (c1 == '}' || c == ')') {
						return false;
					}
					break;
				}

			}

		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isBalanced2("([}{}])"));
	}
}
