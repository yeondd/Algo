package programmersLv2;

import java.util.PriorityQueue;

/*
 * �� �ʰ�
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */

public class No42626_moreSpicy {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
	
	// ���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i: scoville) {
        	minHeap.offer(i);
        }
        
        int min = minHeap.peek();
        
        while(min < K && minHeap.size() >= 2) {
        	int mix = minHeap.poll() + (minHeap.poll() * 2);

    		minHeap.offer(mix);
    		min = minHeap.peek();
    		answer++;
        }
        
        return answer;
    }
}
