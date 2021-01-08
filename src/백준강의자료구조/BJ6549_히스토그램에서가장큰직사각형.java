package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ6549_히스토그램에서가장큰직사각형 {
	static Long [] arr;
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			if(N==0)
				break;
			arr=new Long[N];
			for(int i=0;i<N;i++)
				arr[i]=Long.parseLong(st.nextToken());
			Stack<Integer> s=new Stack<>();
			long ans=0;
			for(int i=0;i<N;i++) {
				while(!s.empty()&&arr[i]<arr[s.peek()]) {
					Long height=arr[s.peek()];
					s.pop();
					int width=i;
					if(!s.empty()) width=(i-s.peek()-1);
					ans=Math.max(ans,height*width);
				}
				s.push(i);
			}
			while(!s.isEmpty()) {
				Long height=arr[s.peek()];
				s.pop();
				int width=N;
				if(!s.empty()) width=N-s.peek()-1;
				ans=Math.max(ans,height*width);
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb.toString());
	}
}
