package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1072_게임 {
	static long X,Y,Z;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		X=sc.nextInt();
		Y=sc.nextInt();
		Z=Y*100/X;
		if(Z>=99) { // 99% 와 100%는 확률이 변하지 않음. 
			System.out.println(-1);
		}else {
			System.out.println(binarySearch(1,X));
		}
	}
	static long binarySearch(long start,long end) {
		long mid=0,ratio=0;
		while(start<=end) {
			mid=(start+end)/2;
			ratio=(Y+mid)*100/(X+mid);
			if(ratio>Z) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return start;
	}
}
