package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ1058_친구 {
	static int map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			String temp=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=temp.charAt(j)=='Y'?1:0;
			}
		}
		int[][]map1=new int[N][N];
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j||i==k||k==j) continue;
					if(map[i][j]==0&&map[i][k]==1&&map[k][j]==1) map1[i][j]=1;
				}
			}
		}
		int max=0;
		for(int i=0;i<N;i++) {
			int cnt=0;
			for(int j=0;j<N;j++) {
				cnt+=map[i][j];
				cnt+=map1[i][j];
			}
			max=Math.max(cnt,max);
		}
		System.out.println(max);
		return;
	}
}