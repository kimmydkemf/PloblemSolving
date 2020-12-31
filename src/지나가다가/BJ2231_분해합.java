package 지나가다가;
import java.util.*;
import java.io.*;

public class BJ2231_분해합 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int result = solve(N);
		System.out.println(result);
	}
	static int solve(int N) {
		int start=1;
		int result=0;
		while(true) {
			int temp=start;
			result=start;
			while(temp/10 != 0) {
				result+=temp%10;
				temp/=10;
			}
			result+=temp;
			if(start>N)
				return 0;
			else if(result==N)
				return start;
			start++;
		}
	}
}
