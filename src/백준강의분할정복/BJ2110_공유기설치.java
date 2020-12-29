package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ2110_공유기설치 {
	static long N,K;
	static long[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Long.parseLong(st.nextToken());K=Long.parseLong(st.nextToken());
		arr=new long[(int)N];
		for(int i=0;i<N;i++)
			arr[i]=Long.parseLong(br.readLine());
		Arrays.sort(arr);
		long l=1;
		long r=arr[(int)N-1]-arr[0];
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
		long cnt=1;
		long check=arr[0];
		for(int i=1;i<N;i++) {
			if(arr[i]-check<mid)
				continue;
			else {
				cnt++;
				check=arr[i];
			}
		}
		return cnt>=K;
	}
}
