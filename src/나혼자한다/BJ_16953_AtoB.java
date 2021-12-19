package 나혼자한다;
import java.util.Scanner;

public class BJ_16953_AtoB {
	public class Main {
		static long a,b,result;
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			a=sc.nextLong();
			b=sc.nextLong();
			result=-1;
			recursion(a,1);
			System.out.println(result);
		}
		static void recursion(long a2,int cnt) {
			if(a2==b) {
				result=cnt;
				return;
			}else if(a2>b) {
				return;
			}else {
				cnt+=1;
				recursion(a2*2,cnt);
				recursion(a2*10+1,cnt);
			}
		}
	}
}
