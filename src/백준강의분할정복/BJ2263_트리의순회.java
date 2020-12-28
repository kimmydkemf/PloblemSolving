package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ2263_트리의순회 {
	static int[] inorder=new int[100000];
	static int[] postorder=new int[100000];
	static int[] position=new int[1000001];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		sb=new StringBuilder();
		for(int i=0;i<N;i++) inorder[i]=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) postorder[i]=Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) position[inorder[i]]=i;
		solve(0,N-1,0,N-1);
		System.out.println(sb.toString());
	}
	static void solve(int in_start,int in_end,int post_start,int post_end) {
		if(in_start>in_end||post_start>post_end) return;
		int root=postorder[post_end];
		sb.append(root+" ");
		int pos=position[root];
		int left=pos-in_start;
		solve(in_start,pos-1,post_start,post_start+left-1);
		solve(pos+1,in_end,post_start+left,post_end-1);
	}
}
