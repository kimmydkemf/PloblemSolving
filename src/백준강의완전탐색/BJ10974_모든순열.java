package 백준강의완전탐색;
import java.util.*;
import java.util.*;

public class BJ10974_모든순열 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N];
		for(int i=0;i<N;i++)
			arr[i]=i+1;
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
		int temp=i;
		while(j>i) {
			if(arr[j]<arr[temp]&&arr[i-1]<arr[j])
				temp=j;
			j--;
		}
		int cnt=arr[temp];
		arr[temp]=arr[i-1];
		arr[i-1]=cnt;
		j=arr.length-1;
		while(i<j) {
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;j--;
		}
		return true;
	}
}
