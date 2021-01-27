package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1507_궁금한민호 {
	static int N;
	static int [][] map;
	static boolean [][] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		check=new boolean[N][N];
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				if(k==i) continue;
				for(int j=0;j<N;j++) {
					if(j==i) continue;
					if(j==k) continue;
					if(map[i][j]>(map[i][k]+map[k][j])) {
						System.out.println(-1);
						return;
					}
					if(map[i][j]==map[i][k]+map[k][j])
						check[i][j]=true;
				}
			}
		}
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=i;j<N;j++) {
				if(!check[i][j])
					sum+=map[i][j];
			}
		}
		System.out.println(sum);
	}
}
