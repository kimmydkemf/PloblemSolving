package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ7576_토마토 {
	static int [][]map;
	static boolean[][]visit;
	static int tcnt,fincnt;
	static int N,M;
	static int[] di= {-1,0,1,0};
	static int[]dj= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visit=new boolean[N][M];
		tcnt=0;
		fincnt=0;
		Queue<Point> queue=new LinkedList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int now=Integer.parseInt(st.nextToken());
				map[i][j]=now;
				if(now==0) {
					tcnt++;
				}else if(now==1) {
					tcnt++;
					fincnt++;
					visit[i][j]=true;
					queue.add(new Point(i,j));
				}
			}
		}
		int sum=bfs(queue);
		if(fincnt==tcnt) {
			System.out.println(sum);
		}else {
			System.out.println(-1);
		}
	}
	static int bfs(Queue<Point> q) {
		int cnt=-1;
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				Point now=q.poll();
				for(int d=0;d<4;d++) {
					int ni=di[d]+now.x;
					int nj=dj[d]+now.y;
					if(isIn(ni,nj)&&map[ni][nj]==0&&!visit[ni][nj]) {
						map[ni][nj]=1;
						visit[ni][nj]=true;
						q.add(new Point(ni,nj));
						fincnt++;
					}
				}
			}
			cnt++;
		}
		return cnt;
	}
	static boolean isIn(int i,int j) {
		return (i>=0&&i<N&&j>=0&&j<M)?true:false;
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
