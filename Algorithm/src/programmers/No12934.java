package programmers;

/*
 * 정수 제곱근 판별
 * https://programmers.co.kr/learn/courses/30/lessons/12934
 */

public class No12934 {
	public static void main(String[] args) {
		System.out.println(solution(121));
	}

	public static long solution(long n) {
		long d = (long) Math.sqrt(n);
		
	    return (d*d == n) ? (d + 1) * (d + 1) : -1;
	}
}
