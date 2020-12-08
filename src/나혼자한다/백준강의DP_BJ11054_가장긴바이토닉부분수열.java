package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의DP_BJ11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[]arr=new int[N];
		int[]dp1=new int[N];
		int[]dp2=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		int result=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			int max1=0;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]&&dp1[j]>max1) {
					max1=dp1[j];
				}
			}
			dp1[i]=max1+1;
		}
		for(int i=N-1;i>=0;i--) {
			int max2=0;
			for(int j=i+1;j<N;j++) {
				if(arr[i]>arr[j]&&dp2[j]>max2) {
					max2=dp2[j];
				}
			}
			dp2[i]=max2+1;
			if(result<dp1[i]+dp2[i]-1)
				result=dp1[i]+dp2[i]-1;
		}
		System.out.println(result);
	}
}
