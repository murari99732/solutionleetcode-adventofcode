package rough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class Interval {

	public static void main(String[] args) {
		matrix("a+b(f{g})");
	}

	static void matrix(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
				st.push(s.charAt(i));
			}
			if (s.charAt(i) == '}' ) {
				if (st.peek() != '{') {
					System.out.println("wrong");
					break;
				}
				st.pop();
			}
			if (s.charAt(i) == ')')
			{	if (st.peek() != '(') {
					System.out.println("wrong");
					break;
				}
			st.pop();}
			if (s.charAt(i) == ']')
			{		if (st.peek() != '[') {
					System.out.println("wrong");
					break;
				}
			st.pop();
		}
		}
	}
}
