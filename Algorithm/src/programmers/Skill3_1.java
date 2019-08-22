package programmers;

public class Skill3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

	public int solution(int n) {
	    int answer = 0;
	    int horizontal = 0;
	    int vertical = 0;
	    
	    if(n > 60000) return 0;
	    
	    // 세로로 긴 사각형부터 채워 넣을때 최대
	    answer++;
	    // 가로로 긴 사각형부터 채워 넣을때 최대
	    answer++;
	    
	    // 이때 들어가는 가로모양 & 세로모양 사각형의 최대 개수
	    horizontal = (n / 2) * 2;
	    vertical = n; // (n % 2 == 0) ? 0 : 1;
	    
	    
	 // 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.
	    answer %= 1000000007;
		return answer;
	}
}
