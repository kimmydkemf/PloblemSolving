package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ2108_통계학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		long sum=0;
		int cnt=1;
		int result3[]=new int[3];
		int abs=-4001;
		for(int i=0;i<N;i++) {
			sum+=arr[i];
			if(arr[i]!=abs) {
				if(result3[0]<cnt||(result3[0]==cnt&&result3[1]==1)) {
					if(abs==-4001) {
					}
					else if(result3[0]<cnt) {
						result3[0]=cnt;
						result3[1]=1;
						result3[2]=arr[i-1];
					}else {
						result3[0]=cnt;
						result3[1]=2;
						result3[2]=arr[i-1];
					}
				}
				abs=arr[i];
				cnt=1;
				continue;
			}
			cnt++;
			abs=arr[i];
		}
		if(cnt>result3[0]||(result3[0]==cnt&&result3[1]==1)) {
			result3[0]=cnt;
			result3[1]=1;
			result3[2]=arr[N-1];
		}
		System.out.println((int)Math.round((double)sum/N));
		System.out.println(arr[N/2]);
		System.out.println(result3[2]);
		System.out.println(arr[N-1]-arr[0]);
	}
}
