package 지나가다가;
import java.util.*;
import java.io.*;

public class BJ10867_중복빼고정렬하기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb=new StringBuilder();
		sb.append(arr[0]+" ");
		for(int i=1;i<N;i++) {
			if(arr[i]!=arr[i-1])
				sb.append(arr[i]+" ");
		}
		System.out.println(sb.toString());
	}
}
