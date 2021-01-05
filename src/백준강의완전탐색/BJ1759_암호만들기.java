package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1759_암호만들기 {
	static String mo;
	static String ja;
	static char[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		sb=new StringBuilder();
		int L=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		arr=new char[C];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			String now=st.nextToken();
			if(now.contains("e")||now.contains("a")||now.contains("i")||now.contains("o")||now.contains("u")) {
				mo+=now;
			}else {
				ja+=now;
			}
			arr[i]=now.charAt(0);
		}
		Arrays.sort(arr);
		recursion(0,0,"",L,C);
		System.out.println(sb.toString());
	}
	static void recursion(int idx,int cnt,String s,int L,int C) {
		if(cnt==L) {
			int min=0;
			for(int i=0;i<L;i++) {
				char temp=s.charAt(i);
				if(temp=='a'||temp=='e'||temp=='i'||temp=='o'||temp=='u')
					min++;
			}
			if(min<1||L-min<2)
				return;
			sb.append(s+"\n");
			return;
		}
		if(idx>=C) {
			return;
		}
		// idx select
		recursion(idx+1,cnt+1,s+arr[idx],L,C);
		// idx not_select
		recursion(idx+1,cnt,s,L,C);
	}
}
