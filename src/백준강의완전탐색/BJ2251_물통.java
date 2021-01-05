package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ2251_물통 {
	static boolean[][] check;
	static boolean[] result;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		int z=sc.nextInt();
		check=new boolean[201][201];
		result=new boolean[z+1];
		Queue<Node> queue=new LinkedList<>();
		queue.add(new Node(0,0)); check[0][0]=true; result[z]=true;
		while(!queue.isEmpty()) {
			Node now=queue.poll();
			int c=z-now.x-now.y;
			int a=now.x,b=now.y;
			// a -> b
			b+=a; a=0;
			if(b>y) {
				a=b-y;
				b=y;
			}
			if(!check[a][b]) {
				check[a][b]=true;
				queue.add(new Node(a,b));
				if(a==0) {
					result[c]=true;					
				}
			}
			// a -> c
			c=z-now.x-now.y;a=now.x;b=now.y;
			c+=a; a=0;
			if(c>z) {
				a=c-z;
				c=z;
			}
			if(!check[a][b]) {
				check[a][b]=true;
				queue.add(new Node(a,b));
				if(a==0) {
					result[c]=true;					
				}
			}
			// b -> a
			c=z-now.x-now.y;a=now.x;b=now.y;
			a+=b; b=0;
			if(a>x) {
				b=a-x;
				a=x;
			}
			if(!check[a][b]) {
				check[a][b]=true;
				queue.add(new Node(a,b));
				if(a==0) {
					result[c]=true;					
				}
			}
			// b -> c
			c=z-now.x-now.y;a=now.x;b=now.y;
			c+=b;b=0;
			if(c>z) {
				b=c-z;
				c=z;
			}

			if(!check[a][b]) {
				check[a][b]=true;
				queue.add(new Node(a,b));
				if(a==0) {
					result[c]=true;					
				}
			}
			// c -> a
			c=z-now.x-now.y;a=now.x;b=now.y;
			a+=c;c=0;
			if(a>x) {
				c=a-x;
				a=x;
			}
			if(!check[a][b]) {
				check[a][b]=true;
				queue.add(new Node(a,b));
				if(a==0) {
					result[c]=true;					
				}
			}
			// c -> b
			c=z-now.x-now.y;a=now.x;b=now.y;
			b+=c;c=0;
			if(b>y) {
				c=b-y;
				b=y;
			}
			if(!check[a][b]) {
				check[a][b]=true;
				queue.add(new Node(a,b));
				if(a==0) {
					result[c]=true;					
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<=z;i++) {
			if(result[i])
				sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}
	static class Node{
		int x,y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
