package 백준강의수학;
import java.util.*;
import java.io.*;

public class BJ1978_소수찾기 {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		boolean arr[]=new boolean[1001];
		arr[0]=true; arr[1]=true;
		for(int i=2;i<=1000;i++) {
			if(arr[i])
				continue;
			for(int j=2;j*i<=1000;j++) {
				arr[j*i]=true;
			}
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			int now=sc.nextInt();
			if(arr[now]==false) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
