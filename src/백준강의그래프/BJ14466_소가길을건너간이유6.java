package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ14466_소가길을건너간이유6 {
	static int map[][];
	static boolean visit[][];
	static  ArrayList<Node>[][] list;
	static int N,K,R;
	static int di[]= {-1,1,0,0};
	static int dj[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		list=new ArrayList[N][N];
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				list[i][j]=new ArrayList<>();
			}
		}
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			int r1=Integer.parseInt(st.nextToken())-1;
			int c1=Integer.parseInt(st.nextToken())-1;
			int r2=Integer.parseInt(st.nextToken())-1;
			int c2=Integer.parseInt(st.nextToken())-1;
			list[r1][c1].add(new Node(r2,c2));
			list[r2][c2].add(new Node(r1,c1));
		}
		List<Node> cows=new ArrayList<>();
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			cows.add(new Node(r,c));
			map[r][c]=1;
		}
		System.out.println(go(cows));
	}
	static int go(List<Node> cows) {
		int cnt=0;
		for(int i=0;i<K;i++) {
			visit=new boolean[N+1][N+1];
			Node cow = cows.get(i);
			move(cow);
			for(int j=i;j<K;j++) {
				Node nc=cows.get(j);
				if(!visit[nc.x][nc.y]) cnt++;
			}
		}
		return cnt;
	}
	static void move(Node cow) {
		Queue<Node> q=new LinkedList<>();
		q.add(cow);
		visit[cow.x][cow.y]=true;
		while(!q.isEmpty()) {
			Node now=q.poll();
			for(int i=0;i<4;i++) {
				int nx=di[i]+now.x;
				int ny=dj[i]+now.y;
				if(!isIn(nx,ny)) continue;
				if(visit[nx][ny]) continue;
//				if(list[now.x][now.y].contains(new Node(nx,ny))) continue;
				boolean check=false;
				for(Node n:list[now.x][now.y]) {
					if(n.x==nx&&n.y==ny) {
						check=true;
						break;
					}
				}
				if(check) continue;
				q.add(new Node(nx,ny));
				visit[nx][ny]=true;
			}
		}
	}
	static boolean isIn(int x,int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
	static public class Node{
		int x,y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
