package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ9095_123더하기 {
	static int n,cnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			n=sc.nextInt();
			cnt=0;
			recursion(0);
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	static void recursion(int sum) {
		if(sum>n)
			return;
		if(sum==n) {
			cnt++;
			return;
		}
		recursion(sum+1);
		recursion(sum+2);
		recursion(sum+3);
	}
}
