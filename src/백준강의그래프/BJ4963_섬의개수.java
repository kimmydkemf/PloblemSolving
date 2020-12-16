package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ4963_섬의개수 {
	static int[][]map;
	static boolean[][]visit;
	static int H,W;
	static int[]di= {-1,-1,-1,0,0,1,1,1};
	static int[]dj= {-1,0,1,1,-1,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			if(H==0&&W==0)
				break;
			map=new int[H][W];
			visit=new boolean[H][W];
			for(int i=0;i<H;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int cnt=0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]==1&&!visit[i][j]) {
						bfs(new Point(i,j));
						cnt++;
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	static void bfs(Point start) {
		Queue<Point> queue=new LinkedList<>();
		queue.add(start);
		visit[start.x][start.y]=true;
		while(!queue.isEmpty()) {
			Point now=queue.poll();
			for(int i=0;i<8;i++) {
				int ni=di[i]+now.x;
				int nj=dj[i]+now.y;
				if(isIn(ni,nj)&&map[ni][nj]==1&&!visit[ni][nj]) {
					visit[ni][nj]=true;
					queue.add(new Point(ni,nj));
				}
			}
		}
	}
	static boolean isIn(int i,int j) {
		return (i>=0&&i<H&&j>=0&&j<W)?true:false;
	}
	static class Point{
		int x,y;
		Point(int i,int j){
			x=i;
			y=j;
		}
	}
}
