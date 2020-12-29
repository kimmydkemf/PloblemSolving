package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ1654_랜선자르기 {
	static int[] arr;
	static int K,N;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken()); N=Integer.parseInt(st.nextToken());
		arr=new int[K];
		long max=0;
		for(int i=0;i<K;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(arr[i]>max)
				max=arr[i];
		}
		long l=1;
		long r=max;
		long ans=0;
		while(l<=r) {
			long mid=(l+r)/2;
			if(check(mid)) {
				if(ans<mid)
					ans=mid;
				l=mid+1;
			}
			else {
				r=mid-1;
			}
		}
		System.out.println(ans);
	}
	static boolean check(long mid) {
		int cnt=0;
		for(int i=0;i<K;i++) {
			cnt+=arr[i]/mid;
		}
		if(cnt>=N)
			return true;
		else
			return false;
	}
}
