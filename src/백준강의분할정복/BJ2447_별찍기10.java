package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ2447_별찍기10 {
	static boolean [][]map;
	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new boolean[N][N];
		solve(0,0,N);
		print();
	}
	static void print() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==true)
					sb.append("*");
				else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void solve(int x,int y, int size) {
		if(size==3) {
			int cnt=1;
			for(int i=x;i<x+3;i++) {
				for(int j=y;j<y+3;j++) {
					if(cnt++==5)
						continue;
					map[i][j]=true; // true == 별표. false == 공백.
				}
			}
			return;
		}
		int cnt=1;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(cnt++==5)
					continue;
				solve(x+size/3*i,y+size/3*j,size/3);
			}
		}
	}
}
