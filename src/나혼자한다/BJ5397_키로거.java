package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ5397_키로거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			Stack<Character> stack=new Stack<>();
			Stack<Character> stack2=new Stack<>();
			String s=br.readLine();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='<') {
					if(stack.isEmpty()) continue;
					stack2.add(stack.pop());
				}else if(s.charAt(i)=='>') {
					if(stack2.isEmpty()) continue;
					stack.add(stack2.pop());
				}else if(s.charAt(i)=='-'){
					if(!stack.isEmpty())
						stack.pop();
				}else {
					stack.add(s.charAt(i));
				}
			}
			while(!stack2.isEmpty()) {
				stack.add(stack2.pop());
			}
			for(int i=0;i<stack.size();i++) {
				sb.append(stack.elementAt(i));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
