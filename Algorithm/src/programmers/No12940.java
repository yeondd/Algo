package programmers;

/*
 * 최대공약수와 최소공배수
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 */

public class No12940 {

	public static void main(String[] args) {
		int[] answer = solution(24, 18);
		System.out.print(answer[0] + "  ");
		System.out.println(answer[1]);
	}
	
	public static int[] solution(int n, int m) {
		int[] answer = {1, 1};
		
		int i = 1;
		while(n > i && m > i) {
			i++;
//			System.out.printf("%d>>> n: %d, m: %d\n", i, n, m);
			if(n % i == 0 && m % i == 0) {
				n /= i;
				m /= i;
				answer[0] *= i;
				i = 1;
			}
		}
		
		answer[1] *= answer[0] * n * m;
		
	    return answer;
	}
}
