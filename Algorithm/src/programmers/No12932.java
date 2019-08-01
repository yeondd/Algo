package programmers;

/*
 * �ڿ��� ������ �迭�� �����
 * https://programmers.co.kr/learn/courses/30/lessons/12932
 */

import java.util.LinkedList;
import java.util.Queue;

public class No12932 {

	public static void main(String[] args) {
		long n = 12345;
		int[] answer = solution(n);
		
		for(int i: answer) {
			System.out.print(i + "  ");
		}
	}

	public static int[] solution(long n) {
		// long -> int �����. ū�� -> �����ŷ� ����ȯ�� ������ ��.
		int[] answer = {};
		int r = 0;
		long mok = n;
		// �־��� �ڿ����� ������ ����ؾ� �ϹǷ� 10���� ���� �������� ���� �����Ѵ�.
		// �̶� ������ ����ϸ� ���� ������� ��µ�.
		Queue queue = new LinkedList();
		
		while(mok > 0) {
			mok = n / 10;
			r = (int) (n % 10);	// �� ��� 10���� ������ �������� ������ 0~9 �����̹Ƿ� ���� ��ȯ�ص� ������ �����Ŷ� ������.
			queue.add(r);
			
//			System.out.println("��: " + mok + "  ������: " + r);
			
			n = mok;
		}

		answer = new int[queue.size()];
		int i = 0;
		while(!queue.isEmpty()) {
			answer[i] = (int) queue.poll();
			i++;
		}
		
	    return answer;
	}
}
