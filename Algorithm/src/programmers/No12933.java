package programmers;

import java.util.Arrays;

/*
 * ���� ������������ ��ġ�ϱ�
 * https://programmers.co.kr/learn/courses/30/lessons/12933
 */

public class No12933 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 118372;
		System.out.println(solution(n));
	}
	
	public static long solution(long n) {
		long answer = 0;
		// �̰� ���� ���淡 ���� �ẽ.
		// Returns the string representation of the long argument.
		String s = String.valueOf(n);
		int nLength = s.length();
		char[] nString = new char[nLength];
		
		// ������ ���� s�� �迭��
		for(int i = 0; i < nLength; i++) {
			nString[i] = s.charAt(i);
		}
		
		// ���� -> ����
		Arrays.sort(nString);
		
//		for(int i = nString.length - 1; i >= 0 ; i--) {
//			System.out.print(nString[i]);
//		}
		
		int multip = 1;
		int tempNum = 0;
		for(int i = 0; i < nString.length; i++) {
			tempNum = nString[i] - '0';
			answer += tempNum * multip;
			multip *= 10;
		}
		
	    return answer;
	}
}
