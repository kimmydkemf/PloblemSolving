package 나혼자한다;

import java.util.Scanner;

public class BJ3085_사탕게임 {
	static int N;
	static char arr[][];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		arr=new char[N][N];
		for(int n=0;n<N;n++) {
			String s=sc.next();
			for(int j=0;j<N;j++) {
				arr[n][j]=s.charAt(j);
			}
		}
		int result=0;
		// 안바꾸고 탐색
		for(int i=0;i<N;i++) {
			result=Math.max(result,garo(i));
			result=Math.max(result,sero(i));
		}
		// 가로 탐색
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				if(arr[i][j]==arr[i][j+1]) continue;
				swap(i,j,i,j+1);
				result=Math.max(result,garo(i));
				result=Math.max(result,sero(j));
				result=Math.max(result,sero(j+1));
				swap(i,j,i,j+1);
			}
		}
		// 세로 탐색
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				if(arr[j][i]==arr[j+1][i]) continue;
				swap(j,i,j+1,i);
				result=Math.max(result,garo(j));
				result=Math.max(result,garo(j+1));
				result=Math.max(result,sero(i));
				swap(j,i,j+1,i);
			}
		}
		System.out.println(result);
	}
	static void swap(int a,int b,int c,int d) {
		char temp=arr[a][b];
		arr[a][b]=arr[c][d];
		arr[c][d]=temp;
	}
	static int garo(int i) {
		int cnt=1;
		int result=0;
		char prev=arr[i][0];
		for(int n=1;n<N;n++) {
			if(arr[i][n]==prev) {
				cnt++;
			}else {
				cnt=1;
				prev=arr[i][n];
				result=Math.max(cnt, result);
			}
		}
		return Math.max(result, cnt);
	}
	static int sero(int i) {
		int cnt=1;
		int result=0;
		char prev=arr[0][i];
		for(int n=1;n<N;n++) {
			if(arr[n][i]==prev) {
				cnt++;
			}else {
				cnt=1;
				prev=arr[n][i];
				result=Math.max(cnt,result);
			}
		}
		return Math.max(cnt,result);
	}
}
