package programmersLv2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * «¡∏∞≈Õ
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
        for(int i = 0; i < size; i++) {
        	node = new Node<Integer, Integer>(i, priorities[i]);
        	
        	if(maxNode.value < node.value) {
        		maxNode = node;
        	}
        	
        	queue.offer(node);
        }

        
        while(!queue.isEmpty()) {
        	node = queue.poll();
        	
        	if(node.value != maxNode.value) {
        		queue.offer(node);
        	}
        	else {
        		answer++;
        		if(node.number == location) {
        			break;
        		}
        		maxNode = findMax();
        	}
        }
        
        return answer;
    }
}
