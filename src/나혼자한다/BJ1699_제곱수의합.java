package 나혼자한다;

import java.util.Scanner;

public class BJ1699_제곱수의합 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[N+1];
		//arr[0]=1;
		arr[1]=1;
		for(int i=2;i<=N;i++) {
			int result=(int)Math.sqrt(i);
			if(i==result*result) {
				arr[i]=1;
			}else {
				result=Integer.MAX_VALUE;
				for(int j=1;j<=i/2;j++) {
					result=Math.min(result, arr[j]+arr[i-j]);
				}
				arr[i]=result;
			}
		}
		System.out.println(arr[N]);
	}
}
