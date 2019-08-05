package programmers;

/*
 * �ݶ��� ����
 * https://programmers.co.kr/learn/courses/30/lessons/12943
 */

public class No12943 {

	public static void main(String[] args) {
		System.out.println(solution(626331));
	}

//	1-1. �Էµ� ���� ¦����� 2�� �����ϴ�. 
//	1-2. �Էµ� ���� Ȧ����� 3�� ���ϰ� 1�� ���մϴ�.
//	2. ����� ���� ���� ���� �۾��� 1�� �� ������ �ݺ��մϴ�.
	
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
