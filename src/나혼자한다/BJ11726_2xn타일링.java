package 나혼자한다;

import java.util.Scanner;

public class BJ11726_2xn타일링 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long [] arr=new long[N+1];
		if(N<=2) {
			if(N==1) {
				System.out.println(1);
			}else {
				System.out.println(2);
			}
		}else {
			arr[1]=1;
			arr[2]=2;
			for(int i=3;i<=N;i++) {
				arr[i]=(arr[i-1]+arr[i-2])%10007;
			}
			System.out.println(arr[N]);
		}
	}
}
