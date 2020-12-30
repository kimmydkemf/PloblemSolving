package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ11723_집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int Command=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		int now=0;
		for(int i=0;i<Command;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int shift;
			int check;
			switch(st.nextToken()) {
			case "add":
//				shift=Integer.parseInt(st.nextToken());
//				now=now|1<<shift;
				shift=Integer.parseInt(st.nextToken()); shift--;
				now=(now|1<<shift);
				break;
			case "check":
//				shift=Integer.parseInt(st.nextToken());
//				check=now&(1<<shift);
//				sb.append(check==0?0:1+"\n");
				shift=Integer.parseInt(st.nextToken()); shift--;
				int res=(now&(1<<shift));
				if(res==0) sb.append("0\n");
				else sb.append("1\n");
				break;
			case "remove":
//				shift=Integer.parseInt(st.nextToken());
//				now=now&~(1<<shift);
				shift=Integer.parseInt(st.nextToken()); shift--;
				now=(now&~(1<<shift));
				break;
			case "toggle":
//				shift=Integer.parseInt(st.nextToken());
//				int temp=1<<shift;
//				now=now^temp;
				shift=Integer.parseInt(st.nextToken()); shift--;
				now=(now^(1<<shift));
				break;
			case "all":
//				now=(1<<21)-1;
				now=(1<<21)-1;
				break;
			case "empty":
//				now=1;
				now=0;
				break;
			}
		}
		System.out.println(sb.toString());
	} 
}
