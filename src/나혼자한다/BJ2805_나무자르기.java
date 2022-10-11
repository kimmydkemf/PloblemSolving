package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805_나무자르기 {
	static long tree[];
	static int N;
	static long M;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Long.parseLong(st.nextToken());
		tree=new long[N];
		st=new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) tree[n]=Long.parseLong(st.nextToken());
		Arrays.sort(tree);
		System.out.println(binarySearch());
	}
	private static long binarySearch() {
		long Max=Long.MAX_VALUE;
		long Min=0;
		long mid=(Max+Min)/2;
		long ans=0;
		long result=0;
		while(Max>=Min) {
			mid=(Max+Min)/2;
			for(int i=0;i<N;i++) {
				if(tree[i]<=mid) continue;
				result+=tree[i]-mid;
			}
			if(result>=M) {
				ans=mid;
				Min=mid+1;
			}else {
				Max=mid-1;
			}
			result=0;
		}
		return ans;
	}
	
}
