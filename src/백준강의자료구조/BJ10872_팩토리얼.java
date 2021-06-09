package 백준강의자료구조;
import java.util.*;

public class BJ10872_팩토리얼 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		System.out.println(fact(N));
	}
	static int fact(int n) {
		if(n<=1) return 1;
		return n*fact(n-1);
	}
}
