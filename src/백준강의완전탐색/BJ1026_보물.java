package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1026_보물 {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int []A=new int[N];
		int []B=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			A[i]=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int now=Integer.parseInt(st.nextToken());
			B[i]=now;
		}
		Arrays.sort(A);
		Arrays.sort(B);
		int min=0;
		for(int i=0;i<N;i++) {
			min+=A[i]*B[N-1-i];
		}
		System.out.println(min);
	}
}
