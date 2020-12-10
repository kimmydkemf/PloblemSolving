package 나혼자한다;
import java.util.*;
import java.io.*;

public class 백준강의정렬_BJ10989_수정렬하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		int []arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());			
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++)
			sb.append(arr[i]+"\n");
		System.out.println(sb.toString());
	}
}
