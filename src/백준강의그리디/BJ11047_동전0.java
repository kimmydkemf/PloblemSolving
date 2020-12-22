package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ11047_동전0 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int []arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		int cnt=0;
		N--;
		while(N>=0) {
			int result=K/arr[N];
			if(result>0) {
				cnt+=result;
				K-=arr[N]*result;			
			}
			N--;
		}
		System.out.println(cnt);
	}
}
