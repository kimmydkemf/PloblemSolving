package 백준강의자료구조;
import java.util.*;

public class BJ10773_제로 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt();
		Stack<Integer> stack=new Stack<>();
		for(int k=1;k<=K;k++) {
			int now=sc.nextInt();
			if(now==0) {
				stack.pop();
			}else {
				stack.push(now);
			}
		}
		long result=0;
		while(!stack.isEmpty()) {
			result+=stack.pop();
		}
		System.out.println(result);
	}
}
