package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018_체스판다시칠하기 {
	static char board[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		board=new char[N][M];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j]=s.charAt(j);
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				min=Math.min(min, find(i,j));
			}
		}
		System.out.println(min);
	}
	static int find(int a,int b) {
		// 왼위 흰색.
		int result1=0;
		for(int i=0;i<8;i++) {
			char now=(i%2==0? 'W' : 'B');
			for(int j=0;j<8;j++) {
				if(now==board[i+a][b+j]) {
					// nothing
				}else {
					result1++;
				}
				if(now=='W') now='B';
				else now='W';
			}
		}
		// 왼위 검정색.
		int result2=0;
		for(int i=0;i<8;i++) {
			char now=(i%2==0? 'B' : 'W');
			for(int j=0;j<8;j++) {
				if(now==board[i+a][b+j]) {
					// nothing
				}else {
					result2++;
				}
				if(now=='W') now='B';
				else now='W';
			}
		}
		return result1>=result2?result2:result1;
	}
}
