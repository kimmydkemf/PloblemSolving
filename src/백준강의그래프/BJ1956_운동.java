package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1956_운동 {
	static int V,E;
	static int map[][];
	static int INF=987654321;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		map=new int[V+1][V+1];
		
		for(int i=0;i<=V;i++) {
			for(int j=0;j<=V;j++) {
				map[i][j]=INF;
			}
		}
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			map[start][end]=cost;
		}
		for(int k=1;k<=V;k++) {
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					if(map[i][j]>map[i][k]+map[k][j])
						map[i][j]=map[i][k]+map[k][j];
				}
			}
		}
		int min=INF;
		for(int i=1;i<=V;i++) {
			min=Math.min(min,map[i][i]);
		}
		if(min==INF)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}
