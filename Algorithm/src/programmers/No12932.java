package programmers;

/*
 * 자연수 뒤집어 배열로 만들기
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
		// long -> int 어려움. 큰거 -> 작은거로 형변환은 조심할 것.
		int[] answer = {};
		int r = 0;
		long mok = n;
		// 주어진 자연수의 역순을 출력해야 하므로 10으로 나눈 나머지를 따로 저장한다.
		// 이때 스택을 사용하면 원래 순서대로 출력됨.
		Queue queue = new LinkedList();
		
		while(mok > 0) {
			mok = n / 10;
			r = (int) (n % 10);	// 이 경우 10으로 나누면 나머지는 무조건 0~9 사이이므로 강제 변환해도 문제가 없을거라 생각함.
			queue.add(r);
			
//			System.out.println("몫: " + mok + "  나머지: " + r);
			
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
