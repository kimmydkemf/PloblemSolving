package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ16967_배열복원하기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int C=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int [][]answer=new int[C][R];
		int [][]input=new int[C+x][R+y];
		for(int i=0;i<C+x;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<R+y;j++) {
				input[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<C+x;i++) {
			for(int j=0;j<R+y;j++) {
				if(i<x&&j<R) {
					answer[i][j]=input[i][j];
				}else if(j<y&&i<C) {
					answer[i][j]=input[i][j];
				}else if(j>=y&&i>=x&&j<R&&i<C) {
					answer[i][j]=input[i][j]-answer[i-x][j-y];
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				sb.append(answer[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
