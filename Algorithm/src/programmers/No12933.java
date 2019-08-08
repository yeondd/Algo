package programmers;

import java.util.Arrays;

/*
 * 정수 내림차순으로 배치하기
 * https://programmers.co.kr/learn/courses/30/lessons/12933
 */

public class No12933 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2147483647 // 최대값
		long n = 118372;
//		long t = 1883619258; // 에러
//		long m = 1883618258; // 에러
		long m = 799999999;
		long k = 2111111110;
		long t = 2147483647; // 최대값
//		long i = 2147483648; // 에러
		System.out.println(solution(t));
	}
	
	public static long solution(long n) {
		long answer = 0;
		String answerStr = "";
		
		// 주어진 숫자를 string 배열로 바꾸고 정렬
		String s = String.valueOf(n);
		int strSize = s.length();
		String[] chr = s.split("");
		Arrays.sort(chr);
		
		for(String str: chr) {
			answerStr = str + answerStr;
		}

		answer = Long.parseLong(answerStr);
		return answer;
	}
}
