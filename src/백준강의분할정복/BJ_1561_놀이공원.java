package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ_1561_놀이공원 {
	static int ans,M;
	static int[] arr;
	static long N;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Long.parseLong(st.nextToken()); M=Integer.parseInt(st.nextToken());
		arr=new int[M+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=M;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		long l=0;
		long r=2000000000L*30L;
		long time=0;
		if(N<=M) {
			System.out.println(N);
			return;
		}
		while(l<=r) {
			long mid=(l+r)/2;
			long end=M;
			long start=-1;
			for(int i=1;i<=M;i++) {
				end+=mid/arr[i];
				if(mid%arr[i]==0)
					start++;
			}
			start=end-start;
			if(N>end) {
				l=mid+1;
			}else if(N<start) {
				r=mid-1;
			}else {
				l=start;
				r=end;
				time=mid;
				break;
			}
		} // N명이 다 탈 수 있는 최소 시간을 구한다.
//		System.out.println(l);
//		System.out.println(r);
		long result=0;
		for(int i=1;i<=M;i++) {
			if(time%arr[i]==0) {
				if(l==N) {
					result=i;
					break;
				}else {
					l++;
				}
			}
		}
		System.out.println(result);
	}
	static int check(long mid) { 
		long cnt=M;
		for(int i=1;i<=M;i++) {
			cnt+=mid/arr[i];
		}
		if(cnt>N) {
			return 1;
		}else if(cnt<N) {
			return 2;
		}else {
			return 3;
		}
	}
}
