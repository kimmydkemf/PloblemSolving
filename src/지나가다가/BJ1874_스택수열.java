package 지나가다가;
import java.util.*;
import java.io.*;

public class BJ1874_스택수열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Integer> stack=new Stack<>();
		StringBuilder sb=new StringBuilder();
		int arr[]=new int[N];
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(br.readLine());
		int idx=0;
		int temp=1;
		while(true) {
			if(stack.isEmpty()) {
				stack.push(temp++);
				sb.append("+\n");
			}else {
				if(stack.peek()==arr[idx]) {
					sb.append("-\n");
					stack.pop();
					idx++;
				}else {
					stack.push(temp++);
					sb.append("+\n");
				}
			}
			if(idx==N)
				break;
			if(temp>N+1)
				break;
		}
		if(stack.isEmpty()) {
			System.out.println(sb.toString());
		}else {
			System.out.println("NO");
		}
	}
}
