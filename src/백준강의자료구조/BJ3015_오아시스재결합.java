package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ3015_오아시스재결합 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Node> s=new Stack<>();
		long ans=0;
		for(int i=0;i<N;i++) {
			Node now=new Node(Long.parseLong(br.readLine()),1);	
			while(!s.isEmpty()) {
				if(s.peek().x<=now.x) {
					ans+=s.peek().y;
					if(s.peek().x==now.x) {
						now.y+=s.peek().y;
					}
					s.pop();
				}else
					break;
			}
			if(!s.isEmpty())ans++;
			s.add(now);
		}
		System.out.println(ans);
	}
	static class Node{
		long x;
		int y;
		Node(long x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
 