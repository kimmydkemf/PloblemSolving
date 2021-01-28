package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ2632_피자판매 {
	static int A[];
	static int B[];
	static ArrayList<Integer> comA,comB;
	static int a,b,pizza;
	static boolean [] check;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		pizza=sc.nextInt();
		a=sc.nextInt();
		b=sc.nextInt();
		A=new int[a];
		B=new int[b];
		for(int i=0;i<a;i++)
			A[i]=sc.nextInt();
		for(int i=0;i<b;i++)
			B[i]=sc.nextInt();
		
		
		comA=new ArrayList<Integer>(); 
		comB=new ArrayList<Integer>();
//		dfs(0,a,0,comA,A);
//		dfs(0,b,0,comB,B);
		
		for(int i=0;i<a;i++) {
			check=new boolean[a];
			check[i]=true;
			checksum(A[i],i,i+1,check,A,comA);
		}
		for(int i=0;i<b;i++) {
			check=new boolean[b];
			check[i]=true;
			checksum(B[i],i,i+1,check,B,comB);
		}
		comA.add(0);
		comB.add(0);
		Collections.sort(comA);
		Collections.sort(comB);
		
		
		int left=0;
		int right=comB.size()-1;
		long ans=0;
		
		while(left<comA.size()&&right>=0) {
			int Lv=comA.get(left);
			int Rv=comB.get(right);
			int sum=Lv+Rv;
			if(sum==pizza) {
				long Ac=0;
				long Bc=0;
				while(left<comA.size()&&comA.get(left)==Lv) {
					Ac++;
					left++;
				}
				while(right>=0&&comB.get(right)==Rv) {
					Bc++;
					right--;
				}
				ans+=Ac*Bc;
			}
			if(sum>pizza) {
				right--;
			}
			if(sum<pizza) {
				left++;
			}
		}
		System.out.println(ans);
	}
	private static void checksum(int sum, int startidx, int idx, boolean[] check, int[] a, ArrayList<Integer> comA) {
		if(idx==a.length) idx=0;
		comA.add(sum);
		if(check[idx]==false&&idx!=startidx-1&&sum<=pizza) {
			check[idx]=true;
			checksum(sum+a[idx],startidx,idx+1,check,a,comA);
		}else {
			return;
		}
	}
	
//	static void dfs(int idx,int end,int sum, ArrayList list,int[] arr) {
//		if(idx==end) {
//			list.add(sum);
//			return;
//		}
//		dfs(idx+1,end,sum+arr[idx],list,arr);
//		dfs(idx+1,end,sum,list,arr);
//	}
}
