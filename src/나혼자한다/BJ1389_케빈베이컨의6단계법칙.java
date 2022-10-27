package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1389_케빈베이컨의6단계법칙 {
	static int N,M;
	static int map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a-1][b-1]=1;
			map[b-1][a-1]=1;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j&&map[i][j]!=1) map[i][j]=999999;
			}
		}
		floyd();
		int result=Integer.MAX_VALUE;
		int person=0;
		for(int i=0;i<N;i++) {
			int cnt=0;
			for(int j=0;j<N;j++) {
				cnt+=map[i][j];
			}
			if(result>cnt) {
				person=i;
				result=cnt;
			}
		}
		System.out.println(person+1);
	}
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void floyd() {
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]>map[i][k]+map[k][j]) map[i][j]=map[i][k]+map[k][j];
				}
			}
		}
	}
}
