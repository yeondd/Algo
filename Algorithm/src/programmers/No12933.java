package programmers;

import java.util.Arrays;

/*
 * ���� ������������ ��ġ�ϱ�
 * https://programmers.co.kr/learn/courses/30/lessons/12933
 */

public class No12933 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2147483647 // �ִ밪
		long n = 118372;
//		long t = 1883619258; // ����
//		long m = 1883618258; // ����
		long m = 799999999;
		long k = 2111111110;
		long t = 2147483647; // �ִ밪
//		long i = 2147483648; // ����
		System.out.println(solution(t));
	}
	
	public static long solution(long n) {
		long answer = 0;
		String answerStr = "";
		
		// �־��� ���ڸ� string �迭�� �ٲٰ� ����
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
