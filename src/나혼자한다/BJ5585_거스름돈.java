package 나혼자한다;

import java.util.Scanner;

public class BJ5585_거스름돈 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int last=1000-sc.nextInt();
		int start=500;
		int cnt=0;
		boolean five=true;
		while(start>=1) {
			int sum=last/start;
			cnt+=sum;
			last-=sum*start;
			if(five) {
				start/=5;
			}else {
				start/=2;
			}
			five=!five;
		}
		System.out.println(cnt);
	}
}
