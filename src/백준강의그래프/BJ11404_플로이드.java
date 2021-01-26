package 백준강의그래프;

import java.util.*;
import java.io.*;

public class BJ11404_플로이드 {
	static int[][] map;
	static int n,m;
	static int INF=987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		map=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)
					map[i][j]=0;
				else
					map[i][j]=INF;
			}
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			if(map[start-1][end-1]<cost)
				continue;
			map[start-1][end-1]=cost;
		}
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]>map[i][k]+map[k][j])
						map[i][j]=map[i][k]+map[k][j];
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append((map[i][j]>=INF?0:map[i][j])+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}