package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ12767_CeilingFunction {
	static Node root;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int TC=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		HashMap<String,Integer> map=new HashMap<>();
		for(int tc=1;tc<=TC;tc++) {
			st=new StringTokenizer(br.readLine());
			root=null;
			sb=new StringBuilder();
			for(int i=0;i<N;i++) {
				push(Integer.parseInt(st.nextToken()));
			}
			find(root);
			map.put(sb.toString(),1);
		}
		System.out.println(map.size());
	}
	static void find(Node n) {
		sb.append("V");	
		if(n.left!=null) {
			sb.append("L");
			find(n.left);
			sb.append("l");
		}
		if(n.right!=null) {
			sb.append("R");
			find(n.right);
			sb.append("r");
		}
		sb.append("v");
	}
	static void push(int x) {
		if(root==null) {
			root=new Node(x);
			return;
		}
		Node now=root;
		while(true) {
			if(now.x<x) {
				if(now.right==null) {
					now.right=new Node(x);
					return;
				}else {
					now=now.right;
				}
			}else {
				if(now.left==null) {
					now.left=new Node(x);
					return;
				}else
					now=now.left;
			}
		}
	}
	static class Node{
		int x;
		Node left;
		Node right;
		Node(int x){
			this.x=x;
		}
	}
}
