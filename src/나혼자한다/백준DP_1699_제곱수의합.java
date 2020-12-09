package 나혼자한다;
import java.util.*;
import java.io.*;
import java.math.*;

public class 백준DP_1699_제곱수의합 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[100001];
		arr[1]=1;
		arr[2]=2;
		arr[3]=3;
		for(int i=4;i<=N;i++) {
			if(Math.pow((int)Math.sqrt(i),2)==i) {
				arr[i]=1;
			}
			else if(((int)(i/2))*2==i&&arr[(i/2)]==1) {
				arr[i]=2;
			}else {
				int min=Integer.MAX_VALUE;
				for(int j=1;j<i/2;j++) {
					int sum=arr[j]+arr[i-j];
					if(min>sum)
						min=sum;
				}
				arr[i]=min;
			}
		}
		System.out.println(arr[N]);
	}
}
