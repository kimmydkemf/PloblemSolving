package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class BJ1213_팰린드롬만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] alpha = new int[26];
		for(int i=0; i<line.length(); i++) {
			int idx = line.charAt(i)-'A';
			alpha[idx]++;
		}
		
		int isOne =0;
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i]%2!=0) isOne++;
		}
		
		String answer ="";
		StringBuilder sb = new StringBuilder();
		if(isOne>1) answer += "I'm Sorry Hansoo";
		else {
			for(int i=0; i<alpha.length; i++) {
				for(int r=0; r<alpha[i]/2; r++) {
					sb.append((char)(i+65));
				}
			}
			answer += sb.toString();
			String end = sb.reverse().toString();
			
			sb = new StringBuilder();
			for(int i=0; i<alpha.length; i++) {
				if(alpha[i]%2==1) {
					sb.append((char)(i+65));
				}
			}
			answer +=sb.toString()+end;
		}
		System.out.println(answer);
	}
}
