package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class NextPermutation {
	static int [] arr= {1,2,3,4,5};
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		do {
			for(int a:arr)
				sb.append(a+" ");
			sb.append("\n");
		}while(nextPermutation());
		System.out.println(sb.toString());
	}
	static boolean nextPermutation() {
		int i=arr.length-1;
		while(i>0&&arr[i]<arr[i-1]) i--;
		if(i<=0)
			return false;
		int j=arr.length-1;
		while(j>=i&&arr[j]<arr[i-1]) j--;
		int temp=arr[j];
		arr[j]=arr[i-1];
		arr[i-1]=temp;
		j=arr.length-1;
		while(i<j) {
			temp=arr[j];
			arr[j]=arr[i];
			arr[i]=temp;
			i++;j--;
		}
		return true;
	}
}
