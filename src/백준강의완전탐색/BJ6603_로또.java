package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ6603_로또 {
	static int N;
	static int[]arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			if(N==0)
				break;
			arr=new int[N];
			for(int i=0;i<N;i++)
				arr[i]=Integer.parseInt(st.nextToken());
			comb(0,0,new int[6]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static void comb(int idx,int cnt,int[]result) {
		if(idx>N)
			return;
		if(cnt==6) {
			for(int i=0;i<6;i++)
				sb.append(result[i]+" ");
			sb.append("\n");
			return;
		}
		if(6-cnt>N-idx) {// 더 가도 6개를 채울 수 없음.
			return;
		}
		result[cnt]=arr[idx];
		comb(idx+1,cnt+1,result); // idx를 뽑는 경우.
		comb(idx+1,cnt,result); // 현재 idx를 뽑지 않는 경우.
	}
}
