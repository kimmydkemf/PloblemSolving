package 삼성SW역량테스트기출문제;
import java.util.*;
import java.io.*;

public class BJ14891_톱니바퀴 {
	static Deque<Integer> d[][];
	static boolean check[];
	static int []direction;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		d=new Deque[4][2]; // 0번은 오른쪽 12, 1.5, 3, 4.5 이고 1번은 왼쪽 6, 7.5, 9, 10.5 
		for(int i=0;i<4;i++) {
			d[i][0]=new LinkedList<Integer>();
			d[i][1]=new LinkedList<Integer>();
			String temp = br.readLine();
			for(int j=0;j<8;j++) {
				if(j<4)
					d[i][0].add(Integer.parseInt(temp.charAt(j)+""));
				else
					d[i][1].add(Integer.parseInt(temp.charAt(j)+""));
			}
		}
		int K=Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {	// - 1반시계 1시계.
			check=new boolean[4];
			direction=new int[4];
			StringTokenizer st=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
			int dir=Integer.parseInt(st.nextToken());
			finddir(num,dir);
			move();
		}
		int point=1;
		int sum=0;
		for(int i=0;i<4;i++) {	// N: 0 S: 1
			// S일때 1,2,4,8 점 획득.
			if(d[i][0].peek()==1) {
				sum+=point;
			}
			point*=2;
		}
		System.out.println(sum);
	}
	static void move() {
		for(int i=0;i<4;i++) {
			if(direction[i]==0) continue;
			if(direction[i]==1) { // 시계방향.
				int RightL=d[i][0].pollLast();
				int LeftL=d[i][1].pollLast();
				d[i][0].addFirst(LeftL);
				d[i][1].addFirst(RightL);
			}else { // 반시계방향.
				int RightF=d[i][0].pollFirst();
				int LeftF=d[i][1].pollFirst();
				d[i][0].addLast(LeftF);
				d[i][1].addLast(RightF);
			}
		}
	}
	static void finddir(int n,int dir) {
		check[n-1]=true;
		direction[n-1]=dir;
		Queue<Integer> q = new LinkedList<>();
		q.add(n-1);
		while(!q.isEmpty()) {
			int now=q.poll();
			if(now+1<4&&!check[now+1]) { // right 톱니바퀴와 비교.
				int t1=d[now][0].pollLast();
				int t2=d[now+1][1].pollLast();
				if(direction[now]!=0&&d[now][0].peekLast()!=d[now+1][1].peekLast()) {
					direction[now+1]=-(direction[now]);
				}else {
					direction[now+1]=0;
				}
				d[now][0].addLast(t1);
				d[now+1][1].addLast(t2);
				check[now+1]=true;
				q.add(now+1);
			}
			if(now-1>=0&&!check[now-1]) { // left 톱니바퀴와 비교.
				int t1=d[now][1].pollLast();
				int t2=d[now-1][0].pollLast();
				if(direction[now]!=0&&d[now][1].peekLast()!=d[now-1][0].peekLast()) {
					direction[now-1]=-(direction[now]);
				}else {
					direction[now-1]=0;
				}
				d[now][1].addLast(t1);
				d[now-1][0].addLast(t2);
				check[now-1]=true;
				q.add(now-1);
			}
		}
	}
}
