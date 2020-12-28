package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ1992_쿼드트리 {
	static StringBuilder sb;
	static int[][]arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		solve(0,0,N);
		System.out.println(sb.toString());
	}
	static void solve(int x,int y,int size) {
		int start=arr[x][y];
		if(find(start,x,y,size)) {
			sb.append(start+"");
			return;
		}
		sb.append("(");
		solve(x,y,size/2);
		solve(x,y+size/2,size/2);
		solve(x+size/2,y,size/2);
		solve(x+size/2,y+size/2,size/2);
		sb.append(")");
	}
	static boolean find(int start,int x,int y,int size) {
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(arr[i][j]!=start)
					return false;
			}
		}
		return true;
	}
}
