package 프로그래머스;

public class LEVEL2_DFS_BFS_타겟넘버 {
	static int answer=0;
    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers.length,numbers,target);
        return answer;
    }
    static void dfs(int idx,int sum,int size,int []numbers, int target){
        if(idx==size){
            if(sum==target)
                answer++;
            return;
        }
        dfs(idx+1,sum+numbers[idx],size,numbers,target);
        dfs(idx+1,sum-numbers[idx],size,numbers,target);
    }
}
