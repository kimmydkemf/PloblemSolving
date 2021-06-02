package 백준강의자료DP;
import java.util.*;

public class BJ15624_피보나치수7 {
	static long div=1000000007;
	public static void main(String[] args) {
		long start=0,next=1;
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		if(N<2) {
			if(N==0) System.out.println(start);
			else System.out.println(next);
		}else {
			for(int i=2;i<=N;i++) {
				long temp=next;
				next=(start+next)%div;
				start=temp;
			}
			System.out.println(next);
		}
	}
}
