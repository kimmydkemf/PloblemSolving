package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ2805_나무자르기 {
	static long N,K;
	static long[]arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Long.parseLong(st.nextToken()); K=Long.parseLong(st.nextToken());
		arr=new long[(int)N];
		st=new StringTokenizer(br.readLine());
		long max=0;
		for(int i=0;i<N;i++) {
			arr[i]=Long.parseLong(st.nextToken());
			if(max<arr[i])
				max=arr[i];
		}
		long l=0;
		long r=max;
		long ans=0;
		while(l<=r) {
			long mid=(l+r)/2;
			if(check(mid)) {
				if(ans<mid)
					ans=mid;
				l=mid+1;
			}else {
				r=mid-1;
			}
		}
		System.out.println(ans);
	}
	static boolean check(long mid) {
		long cnt=0;
		for(int i=0;i<N;i++) {
			long result=arr[i]-mid;
			if(result>0)
				cnt+=result;
		}
		return cnt>=K;
	}
}
