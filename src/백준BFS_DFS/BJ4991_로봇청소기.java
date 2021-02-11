package 백준BFS_DFS;

import java.util.*;
import java.io.*;

public class BJ4991_로봇청소기 {
	static char[][] map;
	static Point[] dests;
	static int[][] graph;
	static int C, R;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, -1, 0, 1 };
	static int finalsum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		loop:while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			if (C == 0 && R == 0)
				break;
			map = new char[R][C];
			int size=1;
			dests=new Point[11];
			for (int i = 0; i < R; i++) {
				String temp = br.readLine();
				for (int j = 0; j < C; j++) {
					char now = temp.charAt(j);
					map[i][j] = now;
					if (now == 'o') {
						dests[0] = new Point(i, j, 0);
					}
					if (now == '*') {
						dests[size++]=new Point(i,j,0);
					}
				}
			}
//			System.out.print("dust개수: "+size+", dust: ");
//			for(int i=1;i<size;i++)
//				System.out.print(dests[i].x+","+dests[i].y+" ");
//			System.out.println();
			graph=new int[size][size];
			for(int i=0;i<size-1;i++) {
				for(int j=i+1;j<size;j++) {
					int result=bfs(dests[i],dests[j]);
					if(result==-1) {
						System.out.println(-1);
						continue loop;
					}
					graph[i][j]=result;
					graph[j][i]=result;
				}
			}
			finalsum=Integer.MAX_VALUE;
			boolean[] check=new boolean[size];
			int list[]=new int[size];
			check[0]=true;
			list[0]=0;
			permu(1,size,check,list);
			System.out.println(finalsum);
		}
	}

	private static void permu(int idx, int size, boolean[] check,int [] list) {
		if(idx==size) {
			int sum=0;
			for(int i=0;i<size-1;i++) {
				sum+=graph[list[i]][list[i+1]];
			}
			finalsum=Math.min(sum,finalsum);
			return;
		}
		for(int i=0;i<size;i++) {
			if(!check[i]) {
				check[i]=true;
				list[idx]=i;
				permu(idx+1,size,check,list);
				check[i]=false;
			}
		}
	}

	static int bfs(Point start,Point end) {
		Queue<Point> queue = new LinkedList<>();
		boolean [][] visit=new boolean[R][C];
		visit[start.x][start.y] = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (now.x==end.x&&now.y==end.y) {
				return now.d;
			}
			for (int d = 0; d < 4; d++) {
				int nx = now.x + di[d];
				int ny = now.y + dj[d];
				if (isIn(nx, ny) && !visit[nx][ny] && map[nx][ny] != 'x') {
					queue.add(new Point(nx, ny, now.d+1));
					visit[nx][ny] = true;
				}
			}
		}
		return -1;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < R && y < C;
	}

	static class Point {
		int x, y, d;

		Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
