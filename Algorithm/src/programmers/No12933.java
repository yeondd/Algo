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
		long k = 2111111114;
		long t = 2147483647; // �ִ밪
//		long i = 2147483648; // ����
		System.out.println(solution(k));
	}
	
	public static long solution(long n) {
		long answer = 0;
		String answerStr = "";
		
		// �־��� ���ڸ� string �迭�� �ٲٰ� ����
		String s = String.valueOf(n);
		int strSize = s.length();
		String[] chr = s.split("");
		Arrays.sort(chr);
		
		if(strSize >= 10) {
			// ��ü �迭�� �ִ� ���� �� �ִ� ���� 2�̰�, �� ���� �־�� ��.
			if(chr[strSize - 1].compareTo("2") < 0) {	// �ִ� ���� 2 ����
				// �������
				System.out.println("�ִ� ���� 2 ����");
			} else if(chr[strSize - 1].compareTo("2") == 0) {	// �ִ� ����  2 �϶�
				if(chr[strSize - 2].compareTo("2") >= 0) {		// �� �������� ū ���� 2���� ũ�ų� ������ �ȵ�.
					System.out.println("�ִ� ���� 2 �̰�, �� �������� ū ���� 2 �̻�");
					return 0;
				} else {
					System.out.println("�ִ� ���� 2 �̰�, �� �������� ū ���� 2 �̸�");
				}
				
			} else {	// �ִ� ���� 2���� ū ��� -> �ȵ�
				System.out.println("�ִ� ���� 2���� ŭ");
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
