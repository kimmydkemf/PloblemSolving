package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ11279_최대힙 {
	static int heap[];
	static int pos;
	public static void main(String[] args) {
		// 0 이면, 출력 아니면 입력 
		heap=new int[1000001];
		pos=1;
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int tc=1;tc<=TC;tc++) {
			int n=sc.nextInt();
			if(n==0) {
				int p=pop();
				sb.append(p+"\n");
			}else {
				push(n);
			}
		}
		System.out.println(sb.toString());
	}
	static void push(int x) {
		int now=pos;
		heap[pos++]=x;
		while(now!=1&&heap[now]>heap[now/2]) {
			int temp=heap[now];
			heap[now]=heap[now/2];
			heap[now/2]=temp;
			now/=2;
		}
	}
	static int pop() {
		if(pos==1)
			return 0;
		int result=heap[1];
		heap[1]=heap[--pos];
		heap[pos]=0;
		for(int i=1;i<=pos;) {
			if(i*2>100000)
				break;
			if(heap[i]>heap[i*2]&&heap[i]>heap[i*2+1]) {
				break;
			}else if(heap[i*2]>heap[i*2+1]) {
				int temp=heap[i*2];
				heap[i*2]=heap[i];
				heap[i]=temp;
				i*=2;
			}else {
				int temp=heap[i*2+1];
				heap[i*2+1]=heap[i];
				heap[i]=temp;
				i=i*2+1;
			}
		}
		return result;
	}
}
