package 백준강의그래프;
import java.util.*;

public class BJ1068_트리 {	
	static ArrayList<Integer>[] tree;
	static boolean[] isVisited;
	static int answer = 0, deleteNode;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		tree = new ArrayList[num];
		isVisited = new boolean[num];
		int root = 0;
		for( int i = 0 ; i < num ; i++ ) {
			tree[i] = new ArrayList();
			isVisited[i] = false;
		}
		for( int i = 0 ; i < num ; i++ ) {
			int parent = sc.nextInt();
			if(parent != -1) {
				tree[parent].add(i);
			}else root = i;
		}
		deleteNode = sc.nextInt();
		if(deleteNode == root) System.out.println(0);
		else {
			DFS(root);
			System.out.println(answer);
		}		
	}
	
	static void DFS(int node) {
		isVisited[node] = true;
		int childNum = 0;
		for( int i = 0 ; i < tree[node].size() ; i++ ) {
			int adjNode = tree[node].get(i);
			if( isVisited[adjNode] == false && adjNode != deleteNode) {
				childNum++;
				DFS(adjNode);
			}
		}
		if(childNum == 0) {
			answer++;
		}
	}
}