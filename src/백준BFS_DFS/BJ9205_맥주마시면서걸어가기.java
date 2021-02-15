package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			int N=Integer.parseInt(br.readLine());
			Point location[]=new Point[N+2];
			for(int i=0;i<=N+1;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				location[i]=new Point(x,y);
			}
			Point start=location[0];
			Point end=location[N+1];
			
			boolean check[]=new boolean[N+2];
			Queue<Point> queue=new LinkedList<>();
			check[0]=true;
			queue.add(start);
			boolean find=false;
			while(!queue.isEmpty()) {
				Point now = queue.poll();
				if(now.x==end.x&&now.y==end.y) {
					find=true;
					break;
				}
				for(int i=1;i<=N+1;i++) {
					if(!check[i]&&Math.abs(now.x-location[i].x)+Math.abs(now.y-location[i].y)<=1000) {
						queue.add(location[i]);
						check[i]=true;
					}
				}
			}
			if(find) sb.append("happy\n");
			else sb.append("sad\n");
		}
		System.out.println(sb.toString());
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
