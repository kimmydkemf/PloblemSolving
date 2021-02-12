package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ7569_토마토 {
	static int M,N,H;
	static int[][][]map;
	static int cnt;
	static int di[]= {0,0,0,0,1,-1};
	static int dj[]= {0,0,1,-1,0,0};
	static int dz[]= {1,-1,0,0,0,0};
			
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		map=new int[H][N][M]; // 높이, 세로, 가로
		Queue<Point> queue=new LinkedList<Point>();
		cnt=0;
		for(int h=0;h<H;h++) {
			for(int n=0;n<N;n++) {
				st=new StringTokenizer(br.readLine());
				for(int m=0;m<M;m++) {
					int now=Integer.parseInt(st.nextToken());
					if(now==0) {
						cnt++;
					}else if(now==1) {
						queue.add(new Point(m,n,h));
					}
					map[h][n][m]=now;
				}
			}
		}
		if(cnt==0) {
			System.out.println(0);
		}else {
			System.out.println(bfs(queue));
		}
//		for(int h=0;h<H;h++) {
//			for(int n=0;n<N;n++) {
//				for(int m=0;m<M;m++) {
//					System.out.print(map[h][n][m]);
//				}
//				System.out.println();
//			}
//		}
	}
	private static int bfs(Queue<Point> queue) {
		int time=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			time++;
			for(int i=0;i<size;i++){
				Point now = queue.poll();
				for(int t=0;t<6;t++) {
					int nx=now.x+di[t];
					int ny=now.y+dj[t];
					int nz=now.z+dz[t];
					if(isIn(nx,ny,nz)&&map[nz][ny][nx]==0) {
						cnt--;
						map[nz][ny][nx]=1;
						queue.add(new Point(nx,ny,nz));
					}
				}
			}
			if(cnt==0)
				break;
		}
		return (cnt==0?time:-1);
	}
	static boolean isIn(int x,int y,int z) {
		return x>=0&&y>=0&&z>=0&&x<M&&y<N&&z<H;
	}
	static class Point{
		int x,y,z;
		Point(int x,int y,int z){
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}
}
