package 지나가다가;
import java.util.*;
import java.io.*;

public class BJ14889_스타트와링크 {
	static int map[][];
	static int N;
	static boolean []visit;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit= new boolean[N];
		map=new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		comb(0,0);
		System.out.println(min);
	}
	private static void comb(int idx, int cnt) {
		if(cnt==N/2) {
			diff();
			return;
		}
		
		for(int next=idx;next<N;next++) {
			if(!visit[next]) {
				visit[next]=true;
				comb(next+1,cnt+1);
				visit[next]=false;
			}
		}
	}
	
	private static void diff() {
		int start=0;
		int end=0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(visit[i]==true&&visit[j]==true) {
					start+=map[i][j];
					start+=map[j][i];
				}
				else if(visit[i]==false&&visit[j]==false) {
					end+=map[i][j];
					end+=map[j][i];
				}
			}
		}
		int now=Math.abs(start-end);
		if(now==0) {
			System.out.println(now);
			System.exit(0);
		}
		min=Math.min(now,min);
	}
}
