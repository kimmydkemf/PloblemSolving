package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1389_케빈베이컨의6단계법칙 {
	static int N,M;
	static int [][] map;
	static int INF=987654321;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j)
					continue;
				map[i][j]=INF;
			}
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a][b]=1;
			map[b][a]=1;
		}
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j]=map[i][k]+map[k][j];
					}
				}
			}
		}
		int cnt=0;
		int min=INF;
		for(int i=1;i<=N;i++) {
			int sum=0;
			for(int j=1;j<=N;j++) {
				sum+=map[i][j];
			}
			if(min>sum) {
				min=sum;
				cnt=i;
			}
		}
		System.out.println(cnt);
	}
}
