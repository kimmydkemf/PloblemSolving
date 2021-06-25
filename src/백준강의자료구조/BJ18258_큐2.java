package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ18258_큐2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		Deque<Integer> dq=new LinkedList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			switch(s) {
			case "push":
				dq.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(dq.isEmpty()) {
					sb.append(-1);
				}else {
					sb.append(dq.pop());
				}
				break;
			case "front":
				if(dq.isEmpty()) {
					sb.append(-1);
				}else {
					sb.append(dq.peekFirst());
				}
				break;
			case "back":
				if(dq.isEmpty()) {
					sb.append(-1);
				}else {
					sb.append(dq.peekLast());
				}
				break;
			case "size":
					sb.append(dq.size());
				break;
			case "empty":
				if(dq.isEmpty()) {
					sb.append(1);
				}else {
					sb.append(0);
				}
				break;
			}
			if(!s.equals("push"))
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
