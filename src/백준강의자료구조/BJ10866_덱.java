package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ10866_덱 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Deque<Integer> dq=new LinkedList<>();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push_front":
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "front":
				sb.append(dq.peekFirst()==null?-1:dq.peekFirst());
				sb.append("\n");
				break;
			case "back":
				sb.append(dq.peekLast()==null?-1:dq.peekLast());
				sb.append("\n");
				break;
			case "size":
				sb.append(dq.size());
				sb.append("\n");
				break;
			case "empty":
				sb.append(dq.isEmpty()?1:0);
				sb.append("\n");
				break;
			case "pop_back":
				sb.append(dq.isEmpty()?-1:dq.pollLast());
				sb.append("\n");
				break;
			case "pop_front":
				sb.append(dq.isEmpty()?-1:dq.pollFirst());
				sb.append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
