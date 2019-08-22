package programmers;

/*
 * x��ŭ ������ �ִ� n���� ����
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 */

public class No12954 {
	public static void main(String[] args) {
		long[] answer = solution(-1, 10);
		for(long i: answer) {
			System.out.println(i);
		}

		System.out.println(answer.length);
	}

	public static long[] solution(int x, int n) {
		long[] answer = {};
		
		if(x > 1000000 || x < -1000000) {return new long[1];}
		if(n > 1000) return answer;
		else answer = new long[n];
		
		answer[0] = x;
		for(int i = 1; i < n; i++) {
			answer[i] = answer[i - 1] + x;
		}
		
	    return answer;
	}
}
