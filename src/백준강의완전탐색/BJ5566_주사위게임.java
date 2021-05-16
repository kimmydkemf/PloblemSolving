package 백준강의완전탐색;
import java.util.*;

public class BJ5566_주사위게임 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[]arr=new int[N];
		int start=0;
		for(int i=0;i<N;i++) arr[i]=sc.nextInt();
		for(int i=1;i<=M;i++) {
			start+=sc.nextInt();
			if(start>=N-1) {
				System.out.println(i);
				return;
			}
			if(arr[start]!=0) {
				start+=arr[start];
				if(start>=N-1) {
					System.out.println(i);
					return;
				}
			}
		}
	}
}
