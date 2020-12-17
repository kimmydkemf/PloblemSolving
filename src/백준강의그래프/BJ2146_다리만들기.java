package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ2146_다리만들기 {
	static int N;
	static int [][]map;
	static boolean [][]visit;
	static int[]di= {-1,0,1,0};
	static int[]dj= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		visit=new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&!visit[i][j])
					changeMap(new Point(i,j),++cnt);
			}
		}
		Queue<Point> queue[]=new LinkedList[cnt];
		for(int i=0;i<cnt;i++) {
			queue[i]=new LinkedList<>();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0) {
					queue[map[i][j]-1].add(new Point(i,j));
				}
			}
		}
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++)
//				System.out.print(map[i][j]+" ");
//			System.out.println();
//		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<cnt;i++) {
			visit=new boolean[N][N];
			min=Math.min(min,makebridge(queue[i],i+1));
		}
		System.out.println(min);
	}
	static int makebridge(Queue<Point> q,int checksum) {
		int bridge=0;
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				Point now=q.poll();
				for(int d=0;d<4;d++) {
					int ni=di[d]+now.x;
					int nj=dj[d]+now.y;
					if(isIn(ni,nj)&&map[ni][nj]!=checksum&&!visit[ni][nj]) {
						// 1. 다리를 놓을 수 있는곳.
						if(map[ni][nj]==0) {
							visit[ni][nj]=true;
							q.add(new Point(ni,nj));
						}
						// 2. 다른 섬.
						else {
							return bridge;
						}
					}
				}
			}
			bridge++;
		}
		return bridge;
	}
	static void changeMap(Point start,int number) {
		Queue<Point> queue=new LinkedList<>();
		queue.add(start);
		visit[start.x][start.y]=true;
		map[start.x][start.y]=number;
		while(!queue.isEmpty()) {
			Point now=queue.poll();
			for(int i=0;i<4;i++) {
				int ni=di[i]+now.x;
				int nj=dj[i]+now.y;
				if(isIn(ni,nj)&&map[ni][nj]==1&&!visit[ni][nj]) {
					visit[ni][nj]=true;
					map[ni][nj]=number;
					queue.add(new Point(ni,nj));
				}
			}
		}
	}
	static boolean isIn(int x,int y) {
		return (x>=0&&x<N&&y>=0&&y<N)?true:false;
	}
	static class Point{
		int x,y;
		Point(int i,int j){
			x=i;
			y=j;
		}
	}
}
