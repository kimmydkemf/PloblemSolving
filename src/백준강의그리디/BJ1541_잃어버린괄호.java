package 백준강의그리디;
import java.util.*;
import java.io.*;

public class BJ1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String S=br.readLine();
		int length=S.length();
		int plus=0;int minus=0;
		boolean check=false;
		String temp="";
		for(int i=0;i<length;i++) {
			char now=S.charAt(i);
			if(now-'0'>=0&&now-'0'<10) { // 숫자면,
				temp+=now;
			}else {
				if(!check) {
					plus+=Integer.parseInt(temp);
				}else {
					minus+=Integer.parseInt(temp);
				}
				if(!check&&now=='-') {
					check=true;
				}
				temp="";
			}
		}
		if(!check) {
			plus+=Integer.parseInt(temp);
		}else {
			minus+=Integer.parseInt(temp);
		}
		System.out.println(plus-minus);
	}
}
