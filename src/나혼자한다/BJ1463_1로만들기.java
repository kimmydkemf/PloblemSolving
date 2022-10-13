package 나혼자한다;

import java.util.Scanner;

public class BJ1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] cnt=new int[N+1];
		cnt[1]=0;
		if(N>1) cnt[2]=1;
		if(N>2) cnt[3]=1;
		for(int i=4;i<=N;i++) {
			cnt[i]=cnt[i-1]+1;
			if(i%2==0&&cnt[i/2]+1<cnt[i]) {
				cnt[i]=cnt[i/2]+1;
			}
			if(i%3==0&&cnt[i/3]+1<cnt[i]) {
				cnt[i]=cnt[i/3]+1;
			}
		}
		
		System.out.println(cnt[N]);
	}
}
