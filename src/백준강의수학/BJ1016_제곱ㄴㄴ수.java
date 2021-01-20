package 백준강의수학;
import java.util.*;
import java.io.*;

public class BJ1016_제곱ㄴㄴ수 {
	static boolean[] arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long min=sc.nextLong();
		long max=sc.nextLong();
		arr=new boolean[(int)(max-min)+1];
		for(long i=2;i*i<=max;i++) {
			long next=i*i;
			long start=min%next==0?min/next:(min/next)+1;
			for(long j=start;next*j<=max;j++) {
				arr[(int)(j*next-min)]=true;				
			}
		}
		int cnt=0;
		for(int i=0;i<=max-min;i++) {
			if(arr[i])
				continue;
			cnt++;
		}
		System.out.println(cnt);
	}
}
