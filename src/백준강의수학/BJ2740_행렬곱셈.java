package 백준강의수학;
import java.util.*;
import java.io.*;

public class BJ2740_행렬곱셈 {
	static int[][] A;
	static int[][] B;
	static int[][] C;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int Aa=Integer.parseInt(st.nextToken());int Ab=Integer.parseInt(st.nextToken());
		A=new int[Aa][Ab];
		for(int i=0;i<Aa;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<Ab;j++)
				A[i][j]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		int Ba=Integer.parseInt(st.nextToken());int Bb=Integer.parseInt(st.nextToken());
		B=new int[Ba][Bb];
		for(int i=0;i<Ba;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<Bb;j++)
				B[i][j]=Integer.parseInt(st.nextToken());
		}
		C=new int[Aa][Bb];
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<Aa;i++) {
			for(int j=0;j<Bb;j++) {
				C[i][j]=0;
				for(int k=0;k<Ab;k++) {
					C[i][j]+=(A[i][k]*B[k][j]);
				}
				sb.append(C[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
