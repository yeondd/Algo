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
		long k = 2111111114;
		long t = 2147483647; // 최대값
//		long i = 2147483648; // 에러
		System.out.println(solution(k));
	}
	
	public static long solution(long n) {
		long answer = 0;
		String answerStr = "";
		
		// 주어진 숫자를 string 배열로 바꾸고 정렬
		String s = String.valueOf(n);
		int strSize = s.length();
		String[] chr = s.split("");
		Arrays.sort(chr);
		
		if(strSize >= 10) {
			// 전체 배열에 있는 숫자 중 최대 값은 2이고, 한 개만 있어야 함.
			if(chr[strSize - 1].compareTo("2") < 0) {	// 최대 값이 2 이하
				// 관계없음
				System.out.println("최대 값이 2 이하");
			} else if(chr[strSize - 1].compareTo("2") == 0) {	// 최대 값이  2 일때
				if(chr[strSize - 2].compareTo("2") >= 0) {		// 그 다음으로 큰 값이 2보다 크거나 같으면 안됨.
					System.out.println("최대 값이 2 이고, 그 다음으로 큰 값이 2 이상");
					return 0;
				} else {
					System.out.println("최대 값이 2 이고, 그 다음으로 큰 값이 2 미만");
				}
				
			} else {	// 최대 값이 2보다 큰 경우 -> 안됨
				System.out.println("최대 값이 2보다 큼");
				return 0;
			}
		}
		
		for(String str: chr) {
			answerStr = str + answerStr;
		}

		answer = (long) Integer.parseInt(answerStr);
		return answer;
	}
}
