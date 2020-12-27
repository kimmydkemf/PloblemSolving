package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ11729_하노이탑이동순서 {
	static int cnt;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		sb=new StringBuilder();
		cnt=0;
		hanoi(1,2,3,N);
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
	static void hanoi(int to,int from, int dest,int N) {
		if(N==1) {
			sb.append(to+" "+dest+"\n");
			cnt++;
			return;
		}
		// 1. N-1개의 원판을 중간으로 옮긴다.
		hanoi(to,dest,from,N-1);
		// 2. 1번 기둥 제일 밑의 원판을 dest로 옮긴다.
		hanoi(to,from,dest,1);
		// 3. N-1개의 원판을 dest로 옮긴다.
		hanoi(from,to,dest,N-1);
	}
}
