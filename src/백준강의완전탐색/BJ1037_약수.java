package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1037_약수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int [] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		long result=0;
		if(N%2==0) {
			result=arr[0]*arr[N-1];
		}else {
			result=(long)Math.pow(arr[N/2],2);
		}
		System.out.println(result);
	}
}
