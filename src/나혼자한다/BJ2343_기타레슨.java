package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2343_기타레슨 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int arr[]=new int[N];
		int max=0;
		int end=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			max=Math.max(max, arr[i]);
			end+=arr[i];
		}
		
		int left=max;
		int right=end;
		int mid=0;
		
		
		while(left<=right) {
			mid=(left+right)/2;
			int cnt=1;
			int sum=0;
			for(int i=0;i<N;i++) {
				sum+=arr[i];
				if(sum>mid) {
					sum=arr[i];
					cnt++;
				}
			}
			if(cnt>M) { 
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}
		System.out.println(left);
	}
}
