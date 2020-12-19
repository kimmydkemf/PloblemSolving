package 백준강의트리;
import java.util.*;
import java.io.*;

public class BJ1167_트리의지름 {
	static ArrayList<Point> array[];
	static boolean[] visit;
	static int result,V;
	public static void main(String[] args) throws IOException{
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		V=Integer.parseInt(br.readLine());
//		 array = new ArrayList[V+1];
//		 visit=new boolean[V+1];
//		for(int i=1;i<=V;i++) {
//			StringTokenizer st=new StringTokenizer(br.readLine());
//			st.nextToken();
//			array[i]=new ArrayList<>();
//			int now=Integer.parseInt(st.nextToken());
//			while(now!=-1) {
//				int dist=Integer.parseInt(st.nextToken());
//				array[i].add(new Point(now,dist));
//				now=Integer.parseInt(st.nextToken());
//			}
//		}
//		int dists[] = bfs(1);
//		int next=1;
//		for(int i=2;i<=V;i++) {
//			if(dists[next]<dists[i])
//				next=i;
//		}
//		dists=bfs(next);
//		int ans=dists[1];
//		for(int i=2;i<=V;i++) {
//			if(ans<dists[i])
//				ans=dists[i];
//		}
//		System.out.println(ans);
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        V=n;
        array = (ArrayList<Point>[]) new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            array[i] = new ArrayList<Point>();
        }
        for (int i=1; i<=n; i++) {
            int x = sc.nextInt();
            while (true) {
                int y = sc.nextInt();
                if (y == -1) break;
                int z = sc.nextInt();
                array[x].add(new Point(y,z));
            }
        }
        int[] dist = bfs(1);
        int start = 1;
        for (int i=2; i<=n; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        dist = bfs(start);
        int ans = dist[1];
        for (int i=2; i<=n; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }
        System.out.println(ans);
	}
	static int[] bfs(int start) {
		boolean visit[]=new boolean[V+1];		
		int[] dust=new int[V+1];
		visit[start]=true;
		Queue<Integer> q=new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int now=q.poll();
			for(Point p:array[now]) {
				int y=p.V;
				int cost=p.dist;
				if(!visit[y]) {
					visit[y]=true;
					dust[y]=dust[now]+cost;
					q.add(y);
				}
			}
		}
		return dust;
	}
	static class Point{
		int V;
		int dist;
		Point(int v,int d){
			V=v;
			dist=d;
		}
	}
}
