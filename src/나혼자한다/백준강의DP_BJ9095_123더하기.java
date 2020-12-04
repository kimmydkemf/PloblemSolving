package 나혼자한다;
import java.util.*;

public class 백준강의DP_BJ9095_123더하기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		int [] arr=new int[12]; // n은 11보다 작으므로 1~11까지 배열 사용
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;
		for(int tc=1;tc<=TC;tc++) {
			int N=sc.nextInt();
			for(int i=4;i<=N;i++) {
				if(arr[i]>0)
					continue;
				arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
			}
			System.out.println(arr[N]);
		}
	}
}
