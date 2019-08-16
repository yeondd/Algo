package programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */

public class No42587 {

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		System.out.print(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
        int answer = 0;
        int max = 0;
        int size = priorities.length;
        int locationPrioity = priorities[location];
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < size; i++) {
        	queue.offer(priorities[i]);
        	
        	if(priorities[i] > priorities[max]) max = i;
        }

        int maxPriority = priorities[max];
//        while(!queue.isEmpty()) {
//        	int temp = queue.peek();
//        	
//        	if(temp >= maxPriority) {
//        		queue.poll();
//        		maxPriority = temp;
//        	}
//        	else {
//        		queue.poll();
//        		queue.offer(temp);
//        	}
//        }
        
        return answer;
    }
}
