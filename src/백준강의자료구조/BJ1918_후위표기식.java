package 백준강의자료구조;

import java.util.*;
import java.io.*;

public class BJ1918_후위표기식 {
	static String temp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		temp = sc.nextLine();
		int length = temp.length();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < length; i++) {
			char t = temp.charAt(i);
			if (t >= 'A' && t <= 'Z') {
				sb.append(t);
			} else {
				if (t == '*' || t == '/') {
					while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
						sb.append(stack.pop());
					}
				} else if (t == '+' || t == '-') {
					while (!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
				} else if (t == ')') {
					while (!stack.isEmpty()&&stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop();
				}
				if(t!=')')
					stack.push(t);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
}
