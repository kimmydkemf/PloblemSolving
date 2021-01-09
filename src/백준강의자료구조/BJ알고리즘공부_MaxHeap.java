package 백준강의자료구조;
import java.util.*;
import java.io.*;

public class BJ알고리즘공부_MaxHeap {
	static int[] input= {4,3,5,2,7,9,3,2};
	static int[] heap;
	static int pos;
	public static void main(String[] args) {
		int size=input.length;
		heap=new int[size+1];
		pos=1;
		for(int i=0;i<size;i++) {
			push(input[i]);
		}
		for(int i=0;i<size;i++) {
			System.out.println(pop());
		}
	}
	static int pop() {
		if(pos==1)
			return -1;
		int result=heap[1];
		heap[1]=heap[--pos];
		heap[pos]=0;
		int parent=1;
		int left=2;
		int right=3;
		while(heap[parent]<heap[left]||heap[parent]<heap[right]) {
			if(heap[left]>heap[right]) {
				int temp=heap[left];
				heap[left]=heap[parent];
				heap[parent]=temp;
				parent=left;left=parent*2;right=parent*2+1;
			}else {
				int temp=heap[right];
				heap[right]=heap[parent];
				heap[parent]=temp;
				parent=right;left=parent*2;right=parent*2+1;
			}
			if(right>=pos) {
				break;
			}
		}
		return result;
	}
	static void push(int n) {
		int now=pos;
		heap[pos++]=n;
		while(now!=1&&heap[now]>heap[now/2]) {
			int temp=heap[now];
			heap[now]=heap[now/2];
			heap[now/2]=temp;
			now/=2;
		}
	}
}
