package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ1080_행렬 {
	static int[][] A;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		A=new int[N][M];
		int[][]B=new int[N][M];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				A[i][j]=s.charAt(j)-'0';
			}
		}
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				B[i][j]=s.charAt(j)-'0';
			}
		}
		int cnt=0;
		for(int i=0;i<N-2;i++) {
			for(int j=0;j<M-2;j++) {
				if(A[i][j]!=B[i][j]) {
					swap(i,j);
					cnt++;
				}
			}
		}
		boolean escape=false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(A[i][j]!=B[i][j]) {
					cnt=-1;
					escape=true;
					break;
				}
			}
			if(escape)
				break;
		}
		System.out.println(cnt);
	}
	static void swap(int i,int j) {
		for(int n=0;n<3;n++){
			for(int m=0;m<3;m++) {
				A[i+n][j+m]=A[i+n][j+m]==0?1:0;
			}
		}
	}
}
