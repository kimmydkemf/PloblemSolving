package 지나가다가;
import java.util.*;
import java.io.*;



/***
 * 
 * @author selordoun
 * 소수를 구하는 문제 M~N까지 사이의 수를 구해야 하고 100만까지의 숫자를 구해야 한다.
 * 에라토스테네스의 체를 활용해서 풀면 간단하게 풀수 있다.
 */
public class BJ1929_소수구하기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int M=sc.nextInt();
		int N=sc.nextInt();
		boolean check[]=new boolean[N+1]; // N까지의 수중 소수를 찾아야 하므로!
		check[0]=true;check[1]=true; // 0과 1은 소수가 아니므로 제거.
		for(int i=2;i<=N;i++) {
			if(!check[i]) { // check[i]는 소수이므로 check[i]의 곱으로 나올수 있는 수들은 소수가 아니다!
				int next=i*2;
				while(next<=N) {
					check[next]=true;
					next+=i;
				}
			}
		}
		// check가 되어 있는 수들은 소수가 아니다!
		for(int i=M;i<=N;i++) {
			if(!check[i])
				sb.append(i+"\n");
		}
		System.out.println(sb.toString());
	}
}
