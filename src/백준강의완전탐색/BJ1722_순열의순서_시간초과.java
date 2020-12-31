package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1722_순열의순서_시간초과 {
	static int arr[];
	static long fact[];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N];
		for(int i=0;i<N;i++)
			arr[i]=i+1;
		StringTokenizer st=new StringTokenizer(br.readLine());
		int K=Integer.parseInt(st.nextToken());
		if(K==1) { // next permutation을 횟수만큼해서 구하기!
			int t=Integer.parseInt(st.nextToken());
			for(int i=1;i<t;i++)
				nextPermutation();
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<N;i++)
				sb.append(arr[i]+" ");
			System.out.println(sb.toString());
		}else {
			int cnt=1;
			int [] brr=new int[N];
			fact=new long[N];
			for(int i=0;i<N;i++) {
				brr[i]=Integer.parseInt(st.nextToken());
				fact[i]=factorial(i);
			}
			for(int i=0;i<N;i++) {
				int temp=0;
				for(int j=i+1;j<N;j++)
					if(brr[i]>brr[j]) temp++;
				cnt+=temp*fact[N-1-i];
			}
			System.out.println(cnt);
		}
	}
	static long factorial(int N) {
		if(N==0)
			return 0;
		if(N==1)
			return 1;
		if(fact[N-1]!=0)
			return fact[N]=N*fact[N-1];
		else
			return fact[N]=N*factorial(N-1);
	}
	static boolean nextPermutation() {
		int i=arr.length-1;
		while(i>0&&arr[i]<arr[i-1]) i--;
		if(i<=0)
			return false;
		int j=arr.length-1;
		while(j>=i&&arr[j]<=arr[i-1]) j--;
		int temp=arr[j];
		arr[j]=arr[i-1];
		arr[i-1]=temp;
		j=arr.length-1;
		while(i<j) {
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;j--;
		}
		return true;
	}
	static boolean check(int[] brr) {
		int size=brr.length;
		for(int i=0;i<size;i++) {
			if(arr[i]!=brr[i])
				return false;
		}
		return true;
	}
}
