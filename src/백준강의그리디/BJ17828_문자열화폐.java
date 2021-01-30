package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ17828_문자열화폐 {
	static int []arr;
	static int N;
	static long X;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		arr=new int[N];
		X=Long.parseLong(st.nextToken());
		long tempX=X;
		int pos=N-1;
		while(tempX>0&&pos>=0) {
			int temp=25;
			while(tempX<=temp+pos&&temp>=0) {
				temp--;
			}
			arr[pos--]=temp;
			tempX-=(temp+1);
		}
		if(tempX!=0||N>X) {
			System.out.println("!");
			return;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++)
			sb.append((char)('A'+arr[i]));
		System.out.println(sb.toString());
	}
}
