package 나혼자한다;

import java.util.ArrayList;

public class MinHeap {
	private ArrayList<Integer> minheap;
	MinHeap(){
		minheap=new ArrayList<>();
		minheap.add(1000000);
	}
	void insert(int val) {
		int size=minheap.size();
		minheap.add(val);
		while(size>1&&minheap.get(size)<minheap.get(size/2)) {
			int temp=minheap.get(size);
			minheap.set(size, minheap.get(size/2));
			minheap.set(size/2, temp);
			size/=2;
		}
	}
	int delete() {
		if(minheap.size()==1)
			return 0;
		int deleteItem=minheap.get(1);
		int pos=minheap.size()-1;
		minheap.set(1, minheap.get(pos));
		minheap.remove(pos);
		pos=1;
		while((pos*2)<minheap.size()) {
			if((pos*2+1)<minheap.size()&&minheap.get(pos*2)>minheap.get(pos*2+1)) {
				int temp=minheap.get(pos);
				minheap.set(pos, minheap.get(pos*2+1));
				minheap.set(pos*2+1, temp);
			}else {
				int temp=minheap.get(pos);
				minheap.set(pos, minheap.get(pos*2));
				minheap.set(pos*2, temp);
			}
			pos*=2;
		}
		return deleteItem;
	}
	public int size() {
		return minheap.size();
	}
	public int get() {
		return minheap.get(1);
	}
}
