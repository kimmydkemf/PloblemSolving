package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ14503_로봇청소기 {
	static int [][]map;
	static boolean [][] visit;
	static int[] di= {-1,0,1,0}; 
	static int[] dj= {0,1,0,-1};
	static int cnt=0,N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		visit=new boolean[N][M];
		
		st=new StringTokenizer(br.readLine());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken()); // 0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽.
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bfs(r,c,d);
		System.out.println(cnt);
	}
	static void bfs(int r,int c,int d) {
		Queue<robot> queue=new LinkedList<>();
		queue.add(new robot(r,c,d));
		visit[r][c]=true;
		cnt++;
		while(!queue.isEmpty()) {
			robot now=queue.poll();
			for(int i=1;i<=4;i++) {
				int nx=now.x+di[(now.dir+3*i)%4];
				int ny=now.y+dj[(now.dir+3*i)%4];
				if(isIn(nx,ny)&&!visit[nx][ny]&&map[nx][ny]==0) {
					queue.add(new robot(nx,ny,(now.dir+3*i)%4));
					visit[nx][ny]=true;
					cnt++;
					break;
				}
			}
			if(!queue.isEmpty()) continue;
			int backx=now.x-di[now.dir];
			int backy=now.y-dj[now.dir];
			if(map[backx][backy]==0) {
				queue.add(new robot(backx,backy,now.dir));
			}
		}
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<M;
	}
	static class robot{
		int x;
		int y;
		int dir;
		robot(int x,int y,int dir){
			this.x=x;
			this.y=y;
			this.dir=dir;
		}
	}
}
