package 프로그래머스;

public class LEVEL3_DP_N으로표현 {
	class Solution {
	    int answer=-1;
	    public int solution(int N, int number) {
	        dfs(N,number,0,0);
	        return answer;
	    }
	    void dfs(int N,int number,int cnt,int number2){
	        if(cnt>8){ // 최소값이 8보다 크면 -1을 retrun 함.
	            answer=-1;
	            return;
	        }
	        if(number==number2){    // 값을 찾았고
	            if(answer==-1||answer>cnt){ // 기존의 값보다 최소면 값 변경.
	                answer=cnt;
	                return;
	            }
	        }
	        int nn=N;
	        for(int i=1;i<9-cnt;i++){   // 4칙연산을 하는데 9-cnt로 남은횟수만큼 dfs하게 하면서, 사칙연산을 계산해서 보냄.
	            dfs(N,number,cnt+i,number2*nn);
	            dfs(N,number,cnt+i,number2/nn);
	            dfs(N,number,cnt+i,number2+nn);
	            dfs(N,number,cnt+i,number2-nn);
	            nn=nn*10+N; // 여기서 55, 555와 같은 값을 만들고 그값은 i를 증가시켜서 dfs 시켜줌.
	        }
	    }
	}
}
