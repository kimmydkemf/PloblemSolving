package 백준강의완전탐색;
import java.util.*;
import java.io.*;
public class BJ1018_체스판다시칠하기 {
	static char [][] black,origin;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		origin=new char[N][M];
		for(int i=0;i<N;i++) {
			char[] arr=br.readLine().toCharArray();
			for(int j=0;j<M;j++) origin[i][j]=arr[j];
		}
		black = new char[8][8];
		black[0][0]='B';
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(i==0&&j==0) continue;
				if(j==0) black[i][j]=black[i-1][j]=='B'?'W':'B';
				else black[i][j]=black[i][j-1]=='B'?'W':'B';
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				int blackcnt=0,whitecnt=0;
				for(int ki=i;ki<i+8;ki++) {
					for(int kj=j;kj<j+8;kj++) {
						if(origin[ki][kj]==black[ki-i][kj-j]) whitecnt++;
						else blackcnt++;
					}
				}
				min=Math.min(min,Math.min(blackcnt,whitecnt));
			}
		}
		System.out.println(min);
	}
}
