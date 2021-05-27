package 백준강의그리디;
import java.util.*;

public class BJ1439_뒤집기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String temp=sc.nextLine();
		int zero=0,one=0;
		if(temp.charAt(0)=='0') zero++;
		else one++;
		for(int i=1;i<temp.length();i++) {
			if(temp.charAt(i)==temp.charAt(i-1)) continue;
			if(temp.charAt(i)=='0') zero++;
			else one++;
		}
		System.out.println(one>zero?zero:one);
	}
}
