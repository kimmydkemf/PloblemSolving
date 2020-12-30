package 백준강의분할정복;
import java.util.*;
import java.io.*;

public class BJ2022_사다리 {
	static double x,y,c;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		x=sc.nextDouble(); y=sc.nextDouble();c=sc.nextDouble();
		double mid=0;
		double left=0;
		double right=Double.MAX_VALUE;
		int cnt=0;
		while(true) {
			mid=(left+right)/2;
			cnt++;
			if(cnt==10000)
				break;
			if(check(mid)>c) {
				left=mid;
				
			}else {
				right=mid;
			}
		}
		System.out.println(Math.round(mid*1000)/1000.0);
	}
	static double check(double mid) {
		double Ah=Math.sqrt(Math.pow(x,2)-Math.pow(mid,2));
		double Bh=Math.sqrt(Math.pow(y,2)-Math.pow(mid,2));
		// (0,0) , (0, Ah), (mid, 0), (mid, Bh) 의 접점.
		// 1번선 = y=Bh/mid*x 2번선 = y=-Ah/mid*x +Ah
		// x=y/Bh*mid       x=(y-Ah)*(-1)/Ah*mid
		// y/Bh*mid=(y-Ah)*(-1)/Ah*mid;
		// y/Bh=(y-Ah)*(-1)/Ah  => y/Bh=-y/Ah+1 y/Bh+y/Ah=1; y(Ah+Bh)/BhAh=1; y=BhAh/(Ah+Bh);
		return Bh*Ah/(Bh+Ah);
	}
}
