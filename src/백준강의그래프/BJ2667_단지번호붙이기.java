package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ2667_단지번호붙이기 {
	static int N;
	static int [][]map;
	static boolean [][]visit;
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		visit=new boolean[N][N];
		for(int i=0;i<N;i++) {
			String st=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=st.charAt(j)-'0';
			}
		}
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++)
//				System.out.print(map[i][j]);
//			System.out.println();
//		}
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&!visit[i][j]) {
					queue.add(bfs(new Point(i,j)));
					cnt++;
				}
			}
		}
		sb.append(cnt+"\n");
		while(!queue.isEmpty()) {
			sb.append(queue.poll()+"\n");
		}
		System.out.println(sb.toString());
	}
	static int bfs(Point start) {
		Queue<Point> q=new LinkedList<>();
		q.add(start);
		visit[start.x][start.y]=true;
		int sum=0;
		while(!q.isEmpty()) {
			Point now=q.poll();
			sum++;
			for(int i=0;i<4;i++) {
				int ni=di[i]+now.x;
				int nj=dj[i]+now.y;
				if(isIn(ni,nj)&&map[ni][nj]==1&&!visit[ni][nj]) {
					visit[ni][nj]=true;
					q.add(new Point(ni,nj));
				}
			}
		}
		return sum;
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
