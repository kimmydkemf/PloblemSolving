package 백준강의수학;
import java.util.*;
import java.io.*;

public class BJ17830_이진수씨의하루일과 {
	static int TC,N;
	static int[] min,max;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		TC=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			min=new int[N];
			max=new int[N];
			String s=st.nextToken();
			for(int i=0;i<N;i++) {
				char now=s.charAt(i);
				if(now=='?'){
					min[i]=0;
					max[i]=1;
				}else {
					min[i]=now-'0';
					max[i]=now-'0';
				}
			}
			int minpos=0,maxpos=0;
			int cnt1=0,cnt2=0;
			for(int i=N-1;i>=0;i--) {
				if(min[i]==1) {
					minpos=N-i;
					cnt1++;
				}
				if(max[i]==1) {
					maxpos=N-i;
					cnt2++;
				}
			}
			if(maxpos==0) {
				sb.append(1+" ");
			}else {
				if(cnt2>1) {
					sb.append(N+maxpos+" ");
				}else
					sb.append(N+maxpos-1+" ");
			}
			if(minpos==0) {
				sb.append(1+" ");
			}else {
				if(cnt1>1) {
					sb.append(N+minpos+" ");
				}else
					sb.append(N+minpos-1+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
