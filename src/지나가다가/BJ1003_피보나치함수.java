package 지나가다가;
import java.util.*;
import java.io.*;

public class BJ1003_피보나치함수 {
//	static int[] memo;
	static int zero,one, zero_plus_one;
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		memo=new int[41];
//		finbonachi(40);
//		int TC=sc.nextInt();
		int TC=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
//			int N=sc.nextInt();
			int N=Integer.parseInt(br.readLine());
//			memo=new int[N+1];
			finbonachi(N);
			sb.append(zero+" "+one+"\n");
		}
		System.out.println(sb.toString());
	}
	static void finbonachi(int n) {
		zero=1;
		one=0;
		zero_plus_one=1;
		for(int i=0;i<n;i++) {
			zero=one;
			one=zero_plus_one;
			zero_plus_one=zero+one;
		}
	}
}
