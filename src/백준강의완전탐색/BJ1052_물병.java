package 백준강의완전탐색;
import java.util.*;

public class BJ1052_물병 {
	public static void main(String[] args) {	
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int result=0;
		for(result=0;;result++) {
			int tempN=N+result;
			int cnt=0;
			while(tempN>0) {
				if(tempN%2==1) cnt++;
				tempN/=2;
			}
			if(cnt<=K) break;
		}
		System.out.println(result);
	}
}
