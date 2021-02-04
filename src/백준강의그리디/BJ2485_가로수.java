package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ2485_가로수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[N];
		int mindiff=Integer.MAX_VALUE;
		arr[0]=sc.nextInt();
		for(int i=1;i<N;i++) {
			arr[i]=sc.nextInt();
			mindiff=Math.min(mindiff,arr[i]-arr[i-1]);
		}
		int start=arr[0];
		int end=arr[N-1];
		int sum=0;
		for(int i=mindiff;i>0;i--) {
			if((end-start)%i==0) {
				boolean check=false;
				for(int j=1;j<N;j++) {
					if((arr[j]-start)%i!=0) {
						check=true;
						break;
					}
				}
				if(!check) { // 찾음.
					sum = (end-start)/i+1;
					sum-=arr.length;
					break;
				}
			}
		}
		System.out.println(sum);
	}
}
