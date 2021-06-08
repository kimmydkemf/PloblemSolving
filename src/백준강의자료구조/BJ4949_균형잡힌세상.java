package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		while(true) {
			Stack<Character> stack=new Stack<>();
			String now=br.readLine();
			if(now.charAt(0)=='.')
				break;
			boolean check=false;
			for(int i=0;i<now.length()-1;i++) {
				char temp=now.charAt(i);
				if(temp=='('||temp=='[') {
					stack.add(temp);
				}else if(temp==')'||temp==']') {
					if(stack.isEmpty()) {
						check=true;
						break;
					}
					char c=stack.pop();
					if((temp==')'&&c=='(')||(temp==']'&&c=='[')) {
						continue;
					}else {
						check=true;
						break;
					}
				}else continue;
			}
			if(!stack.isEmpty()) check=true;
			if(check) sb.append("no\n");
			else sb.append("yes\n");
		}
		System.out.println(sb.toString());
	}
}
