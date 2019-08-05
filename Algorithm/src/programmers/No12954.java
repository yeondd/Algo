package programmers;

/*
 * x��ŭ ������ �ִ� n���� ����
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 */

public class No12954 {
	public static void main(String[] args) {
		long[] answer = solution(-4, 2);
		for(long i: answer) {
			System.out.println(i);
		}
	}

	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		
		for(int i = 1; i <= n; i++) {
			answer[i - 1] = x * i;
		}
		
	    return answer;
	}
}
