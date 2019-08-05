package programmers;

/*
 * 콜라츠 추측
 * https://programmers.co.kr/learn/courses/30/lessons/12943
 */

public class No12943 {

	public static void main(String[] args) {
		System.out.println(solution(626331));
	}

//	1-1. 입력된 수가 짝수라면 2로 나눕니다. 
//	1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
//	2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
	
	public static int solution(int num) {
		int answer = 0;
		long n = num;
		
		while(n != 1) {
			if(answer > 500) {
				answer = -1;
				break;
			}
			
			if(n % 2 == 0) {
				n = n / 2;
			} else {
				n = n * 3 + 1;
			}
			answer++;
		}

	    return answer;
	}
}
