package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ1021_회전하는큐 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		Queue<Integer> queue=new LinkedList<>();
		for(int i=1;i<=N;i++) queue.add(i);
		int result=0;
		for(int i=0;i<M;i++) {
			int cnt=0;
			int answer=Integer.parseInt(st.nextToken());
			while(true) {
				int now=queue.poll();
				if(now==answer) break;
				queue.add(now);
				cnt++;
			}
			result+=Math.min(cnt,queue.size()+1-cnt);
		}
		System.out.println(result);
	}
}
