package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4796_캠핑 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for(int i=1;;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int L=Integer.parseInt(st.nextToken());
			int P=Integer.parseInt(st.nextToken());
			int V=Integer.parseInt(st.nextToken());
			if(L==0&&P==0&&V==0) break;
			int cnt=V/P*L+Math.min(L,V%P);
			sb.append("Case "+i+": "+cnt+"\n");
		}
		System.out.println(sb.toString());
	}
}
