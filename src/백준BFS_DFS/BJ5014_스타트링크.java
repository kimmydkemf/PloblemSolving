package 백준BFS_DFS;
import java.util.*;
import java.io.*;

public class BJ5014_스타트링크 {
	static int[] arr;
	static boolean[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int F=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken()); // start
		int G=Integer.parseInt(st.nextToken()); // end
		int U=Integer.parseInt(st.nextToken());
		int D=Integer.parseInt(st.nextToken());
		arr=new int[F+1];
		check=new boolean[F+1];
		check[0]=true;
		Queue<Button> queue=new LinkedList<>();
		queue.add(new Button(S,0));
		check[S]=true;
		int end=-1;
		while(!queue.isEmpty()) {
			Button now=queue.poll();
			if(now.st==G) {
				end=now.cnt;
				break;
			}
			if(now.st+U<=F&&!check[now.st+U]) {
				check[now.st+U]=true;
				queue.add(new Button(now.st+U,now.cnt+1));
			}
			if(now.st-D>0&&!check[now.st-D]) {
				check[now.st-D]=true;
				queue.add(new Button(now.st-D,now.cnt+1));
			}
		}
		System.out.println(end==-1?"use the stairs":end);
	}
	static class Button{
		int st,cnt;
		Button(int s,int c){
			st=s;
			cnt=c;
		}
	}
}
