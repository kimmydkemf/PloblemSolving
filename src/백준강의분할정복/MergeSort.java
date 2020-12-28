package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class MergeSort {
	static int[] A= {10,5,1,3,7};
	public static void main(String[] args) {
		int N=A.length;
		merge(0,N-1);
		for(int i=0;i<N;i++)
			System.out.print(A[i]+" ");
	}
	static void merge(int start,int end) {
		if(start==end)
			return;
		int mid=(start+end)/2;
		merge(start,mid);
		merge(mid+1,end);
		int []B=new int[end-start+1];
		{
			int i=start;
			int j=mid+1;
			int k=0;
			while(i<=mid||j<=end) {
				if(i<=mid&&(j>end||A[i]<A[j])) {
					B[k++]=A[i++];
				}else {
					B[k++]=A[j++];
				}
			}
		}
		for(int i=start;i<=end;i++)
			A[i]=B[i-start];
	}
}
