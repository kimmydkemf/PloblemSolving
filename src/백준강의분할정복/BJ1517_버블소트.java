package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ1517_버블소트 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int sum=0;
		arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		long ans=merge(0,N-1);
		System.out.println(ans);
	}
	static long merge(int start, int end) {
		if(start==end)
			return 0;
		int mid=(start+end)/2;
		int []B=new int[end-start+1];
		
		long ans=merge(start,mid)+merge(mid+1,end);
		{
			int i=start;
			int j=mid+1;
			int k=0;
			while(i<=mid||j<=end) {
				if(i<=mid&&(j>end || arr[i]<=arr[j] )){
					B[k++]=arr[i++];
				}else {
					ans+=(long)(mid-i+1);
					B[k++]=arr[j++];
				}
			}
		}
		for(int i=start;i<=end;i++)
			arr[i]=B[i-start];
		return ans;
	}
}
