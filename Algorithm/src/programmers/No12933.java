package programmers;

import java.util.Arrays;

/*
 * 정수 내림차순으로 배치하기
 * https://programmers.co.kr/learn/courses/30/lessons/12933
 */

public class No12933 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 900000000;
		long t = 1983619258; // 에러
		long m = 999999999;
		long k = 410065408;
		System.out.println(solution(k));
	}
	
	public static long solution(long n) {
		long answer = 0;
		// 1999999999
		if(n > 2000000000) return answer;
		
		// 이거 많이 쓰길래 나도 써봄.
		// Returns the string representation of the long argument.
		String s = String.valueOf(n);
		int nLength = s.length();
		char[] nString = new char[nLength];
		
		// 정렬을 위해 s를 배열로
		for(int i = 0; i < nLength; i++) {
			nString[i] = s.charAt(i);
		}
		
		// 정렬 -> 역순
		Arrays.sort(nString);
		for(int i = nString.length - 1; i >= 0 ; i--) {
			System.out.print(nString[i]);
		}
		System.out.println();
		
		int multip = 1;
		int tempNum = 0;
		for(int i = 0; i < nString.length; i++) {
			tempNum = (nString[i] - '0') * multip;
			System.out.println("tempNum: " + tempNum);
			answer += tempNum;
			multip *= 10;
		}
		
	    return answer;
	}
}
