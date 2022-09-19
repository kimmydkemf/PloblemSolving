package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			Stack<Character> stack=new Stack<>();
			String str=br.readLine();
			boolean check = false;
			for(int j=0;j<str.length();j++) {
				char now=str.charAt(j);
				if(now=='(') {
					stack.add(now);
				}else {
					if(stack.size()>0) {
						stack.pop();
					}else {
						check=true;
						break;
					}
				}
			}
			if(stack.size()!=0) check=true;
			if(!check) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}
}
