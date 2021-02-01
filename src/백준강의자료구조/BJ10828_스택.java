package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ10828_스택 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Integer> stack=new Stack<>();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stack.isEmpty())sb.append(-1+"\n");
				else sb.append(stack.pop()+"\n");
				break;
			case "size":
				sb.append(stack.size()+"\n");
				break;
			case "empty":
				sb.append((stack.isEmpty()?1:0)+"\n");
				break;
			case "top":
				if(stack.isEmpty()) sb.append(-1+"\n");
				else sb.append(stack.peek()+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
