package 백준강의자료DP;
import java.util.*;
import java.io.*;

public class BJ12852_1로만들기2 {
	static int arr[][]=new int[1000001][2];
	public static void main(String[] args) throws IOException{
		arr[1][0]=1; 
		arr[2][0]=1; arr[2][1]=1;
		arr[3][0]=1; arr[3][1]=1;
		for(int i=4;i<1000001;i++) {
			if(i%3==0&&arr[i/3][0]<arr[i-1][0]) {
				arr[i][0]=arr[i/3][0]+1;
				arr[i][1]=i/3;
			}else if(i%2==0&&arr[i/2][0]<arr[i-1][0]) {
				arr[i][0]=arr[i/2][0]+1;
				arr[i][1]=i/2;
			}else {
				arr[i][0]=arr[i-1][0]+1;
				arr[i][1]=i-1;
			}
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(0+"\n"+1);
			return;
		}
		StringBuilder sb=new StringBuilder();
		sb.append(arr[N][0]+"\n");
		int idx=N;
		while(idx!=0) {
			sb.append(idx+" ");
			idx=arr[idx][1];
		}
		System.out.println(sb.toString());
	}
}
