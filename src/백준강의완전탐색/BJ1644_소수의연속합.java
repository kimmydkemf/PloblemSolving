package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1644_소수의연속합 {
	static boolean sosu[]=new boolean[4000002];
	public static void main(String[] args) {
		sosu[0]=true;sosu[1]=true;sosu[4000001]=true;
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=2;i<=4000000;i++) {
			if(sosu[i])
				continue;
			for(int j=2;j*i<=4000000;j++)
				sosu[i*j]=true;
		}
		int sum=0;
		int right=0;
		int left=0;
		int cnt=0;
		while(true) {
			if(sum>N) {
				sum-=left;
				left++;
				while(left<=N&&sosu[left]) {
					left++;
				}
			}else if(right>N) break;
			else {
				if(sum==N) {
					cnt++;
				}
				right++;
				while(right<=4000001&&sosu[right]) {
					right++;
				}
				if(right<=N)
					sum+=right;
			}
//			System.out.println("left:"+left+","+right+", "+sum);
		}
		System.out.println(cnt);
	}
}
