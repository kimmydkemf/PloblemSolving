package 백준강의자료DP;
import java.util.*;

public class BJ8349_악수 {
	public static void main(String[] args) {
		// 0 -> 0, 1-> 1, 2-> 2, 3-> 3
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int start=1;
		int next=1;
		if(N==1) System.out.println(1);
		else {
			for(int i=2;i<=N;i++) {
				int temp=(start+next)%10;
				start=next;
				next=temp;
			}
			System.out.println(next);
		}
	}
}
