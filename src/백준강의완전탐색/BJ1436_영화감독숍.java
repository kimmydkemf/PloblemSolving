package 백준강의완전탐색;
import java.util.*;

public class BJ1436_영화감독숍 {
	static int K;
	static String [] temp;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int r=666; int result=0; int n=0;
		while(n!=N) {
			if(Integer.toString(r).contains("666")) {
				n++;
				result=r;
			}
			r++;
		}
		System.out.println(result);
	}
}
