package programmersLv2;

import java.util.PriorityQueue;

/*
 * 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */

public class No42626_moreSpicy {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
	
	// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(scoville.length);
        
        for(int i: scoville) {
        	minHeap.offer(i);
        }
        
        int min = minHeap.peek();
        
        while(min < K && minHeap.size() > 1) {
        	int mix = minHeap.poll() + (minHeap.poll() * 2);

        	if(minHeap.size() == 2) {
        		if(mix < K) {
        			return -1;
        		}
        	}
    		minHeap.offer(mix);
    		min = minHeap.peek();
    		answer++;
        }
        
        return answer;
    }
}
