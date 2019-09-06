package programmersLv2;

/*
 * 피보나치 수
 * https://programmers.co.kr/learn/courses/30/lessons/12945	
 */

public class No12945_Fibonacci {

	public static void main(String[] args) {
		System.out.println(solution(100000));
	}
	
	public static int fibonacci(int n) {
		int num = 0;
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else {
			num = (fibonacci(n - 1) + fibonacci(n - 2));
		}
		return num;
	}

	public static int solution(int n) {
		int answer = 0;
		
		int[] fibo = new int[n + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1234567;
//			System.out.println(i + " : " + fibo[i]);
		}
		
		answer = fibo[n];
	    return answer;
	}
}
