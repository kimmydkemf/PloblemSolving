package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1743_음식물피하기 {
	static int N,M,K;
	static int cnt;
	static int map[][];
	static boolean check[][];
	static int []di= {-1,0,1,0};
	static int []dj= {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		check=new boolean[N+1][M+1];
		for(int i=1;i<=K;i++) {
			st=new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
		}
		int result=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(!check[i][j]&&map[i][j]==1) {
					result=Math.max(result, findsize(i,j));
				}
			}
		}
		System.out.println(result);
	}
	static int findsize(int a,int b) {
		Queue<Point> q=new LinkedList<>();
		q.add(new Point(a,b));
		check[a][b]=true;
		int cnt=1;
		while(!q.isEmpty()) {
			Point now=q.poll();
			for(int i=0;i<4;i++) {
				int x=now.x+di[i];
				int y=now.y+dj[i];
				if(isIn(x,y)&&map[x][y]==1&&!check[x][y]) {
					check[x][y]=true;
					q.add(new Point(x,y));
					cnt++;
				}
			}
		}
		return cnt;
	}
	static boolean isIn(int a,int b) {
		return a>=1&&b>=1&&a<=N&&b<=M;
	}
	static class Point{
		int x,y;
		Point(int a,int b){
			x=a;
			y=b;
		}
	}
}
