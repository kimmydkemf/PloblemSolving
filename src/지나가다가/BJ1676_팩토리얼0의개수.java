package 지나가다가;
import java.util.*;
import java.io.*;

public class BJ1676_팩토리얼0의개수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int []arr=new int[N+1];
		arr[0]=0;
		for(int i=1;i<=N;i++) {
			int cnt=0;
			int temp=i;
			while(temp%5==0) {
				cnt++;
				temp/=5;
			}
			arr[i]=arr[i-1]+cnt;
		}
		System.out.println(arr[N]);
	}
}
