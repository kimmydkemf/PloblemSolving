package 백준강의그래프;
import java.util.*;
import java.io.*;

public class BJ17827_달팽이리스트 {
	static int [] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int V=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		StringBuilder sb=new StringBuilder();
		int cycle=N-V+1;
		int noncycle=V-1;
		for(int i=0;i<M;i++) {
			long now=Long.parseLong(br.readLine());
			if(now<N) {
				sb.append(arr[(int)now+1]);
			}else {
				long remain = (now-noncycle)%cycle;
				sb.append(arr[(int)remain+V]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
