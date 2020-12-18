package 백준강의트리;
import java.util.*;
import java.io.*;

public class BJ1991_트리순회 {
	static int cnt;
	static String str;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][]arr=new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int root=(int)(st.nextToken().charAt(0)-'A');
			String nleft=st.nextToken(),nright=st.nextToken();
			if(!nleft.equals(".")) {
				arr[root][0]=nleft.charAt(0)-'A';
			}
			if(!nright.equals(".")) {
				arr[root][1]=nright.charAt(0)-'A';
			}
		}
		str="";
		preorder(arr,0);
		System.out.println(str);
		str="";
		inorder(arr,0);
		System.out.println(str);
		str="";
		postorder(arr,0);
		System.out.println(str);
	}

	private static void postorder(int[][] arr, int idx) {
		if(arr[idx][0]!=0)
			postorder(arr,arr[idx][0]);
		if(arr[idx][1]!=0)
			postorder(arr,arr[idx][1]);
		str+=(char)('A'+idx);
	}

	private static void inorder(int[][] arr, int idx) {
		if(arr[idx][0]!=0)
			inorder(arr,arr[idx][0]);
		str+=(char)('A'+idx);
		if(arr[idx][1]!=0)
			inorder(arr,arr[idx][1]);
	}

	private static void preorder(int[][] arr, int idx) {
		str+=(char)('A'+idx);
		if(arr[idx][0]!=0)
			preorder(arr,arr[idx][0]);
		if(arr[idx][1]!=0)
			preorder(arr,arr[idx][1]);
	}
}
