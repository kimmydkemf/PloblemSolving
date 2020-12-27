package 백준강의분할정복;
import java.util.*;
import java.io.*;


public class BJ11728_배열합치기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int arrA[]=new int[A];int arrB[]=new int[B];
		int result[]=new int[A+B];
		st=new StringTokenizer(br.readLine());
		for(int j=0;j<A;j++)
			arrA[j]=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int j=0;j<B;j++)
			arrB[j]=Integer.parseInt(st.nextToken());
		int a=0;int b=0;
		for(int i=0;i<A+B;i++) {
			if(a==A) {
				result[i]=arrB[b++];
			}else if(b==B) {
				result[i]=arrA[a++];
			}else {
				if(arrA[a]<arrB[b]) {
					result[i]=arrA[a++];
				}else {
					result[i]=arrB[b++];
				}
			}
			sb.append(result[i]+" ");
		}
		System.out.println(sb.toString());
	}
}
