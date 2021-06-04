package 백준강의자료DP;
import java.util.*;
public class BJ9625_BABBA {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt();
		// 1 -> a -> 0 b-> 1
		// 2 -> a -> 1 b -> 1
		// 3 -> a -> 1 b -> 2
		// 4 -> a -> 2 b -> 3
		int a[]=new int[46];
		int b[]=new int[46];
		a[0]=1; b[1]=0;
		for(int i=1;i<46;i++) {
			a[i]=b[i-1];
			b[i]=a[i-1]+b[i-1];
		}
		System.out.println(a[K]+" "+b[K]);
	}
}
