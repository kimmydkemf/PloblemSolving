package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ9935_문자열폭발 {
	static boolean [] erase;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String Text=br.readLine();
		String Bomb=br.readLine();
		int n=Text.length();
		erase=new boolean[n];
		int m=Bomb.length();
		if(m==1) {
			for(int i=0;i<n;i++) {
				if(Text.charAt(i)==Bomb.charAt(0))
					erase[i]=true;
			}
		}else {
			Stack<Node> s=new Stack<>();
			for(int i=0;i<n;i++) {
				if(Text.charAt(i)==Bomb.charAt(0)) {
					s.push(new Node(i,0));
				}else {
					if(!s.empty()) {
						Node now=s.peek();
						if(Text.charAt(i)==Bomb.charAt(now.y+1)) {
							s.push(new Node(i,now.y+1));
							if(now.y+1==m-1) {
								for(int k=0;k<m;k++) {
									Node node=s.pop();
									erase[node.x]=true;
								}
							}
						}else {
							while(!s.empty()) {
								s.pop();
							}
						}
					}
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		boolean printed=false;
		for(int i=0;i<n;i++) {
			if(erase[i]) continue;
			sb.append(Text.charAt(i));
			printed=true;
		}
		if(!printed) {
			System.out.println("FRULA");
		}else {
			System.out.println(sb.toString());
		}
	}
	static class Node{
		int x,y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
