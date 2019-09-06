package programmersLv2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 프린터
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */

class Node<N, V> {
	N number;
	V value;
	
	public Node() {}
	public Node(N number, V value) {
		this.number = number;
		this.value = value;
	}
}

public class No42587_printer {

	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(solution(priorities, location));
	}
	
	static Queue<Node<Integer, Integer>> queue;
	
	// queue에 있는 원소 중에 제일 큰 값을 찾는 함수
	public static Node<Integer, Integer> findMax() {
		Node<Integer, Integer> node = new Node<Integer, Integer>(0, 0);
		Iterator<Node<Integer, Integer>> iter = queue.iterator();
		
		while(iter.hasNext()) {
			Node<Integer, Integer> next = iter.next();
			if(node.value < next.value) {
				node = next;
			}
		}
		
		return node;
	}

	public static int solution(int[] priorities, int location) {
        int answer = 0;
        int size = priorities.length;
        Node<Integer, Integer> node;
        Node<Integer, Integer> maxNode = new Node<Integer, Integer>(0, 0);
        queue = new LinkedList<Node<Integer, Integer>>();
        
        // node queue setting
        // 받아온 우선순위를 큐에 순서대로 넣으면서 max 초기 값 찾기
        for(int i = 0; i < size; i++) {
        	// queue에 넣는 node는 입력순서, 우선순위로 구성
        	node = new Node<Integer, Integer>(i, priorities[i]);
        	
        	if(maxNode.value < node.value) {
        		maxNode = node;
        	}
        	
        	queue.offer(node);
        }

        
        while(!queue.isEmpty()) {
        	node = queue.poll();
        	
        	// max값이 아니면 queue에 다시 집어넣고
        	if(node.value != maxNode.value) {
        		queue.offer(node);
        	}
        	// max값이면 출력해도 됨
        	else {
        		answer++;
        		// 단 원하는 값이 출력됐으면 더이상 탐색할 필요 없으므로 중단시킨다.
        		if(node.number == location) {
        			break;
        		}
        		maxNode = findMax();
        	}
        }
        
        return answer;
    }
}
