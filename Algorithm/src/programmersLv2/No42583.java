package programmersLv2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 다리를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */

class Truck {
	int weight;
	int position;
	
	public Truck() {}
	public Truck(int weight) {
		this.weight = weight;
		position = 0;
	}
	
	public void going() {
		position++;
	}
	
	public int getPosition() {
		return position;
	}
}

class solutionClass {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> queue = new LinkedList<Truck>();
        Queue<Truck> waiting = new LinkedList<Truck>();
        int weightSum = 0;
        
        for(int i: truck_weights) {
        	Truck t = new Truck(i);
        	queue.offer(t);
        }
        
        Truck init = queue.poll();
        init.going();
    	weightSum += init.weight;
		waiting.offer(init);
		answer++;
		System.out.println("OFFER: " + init.weight);
        
        while(!waiting.isEmpty()) {
        	answer++;
			System.out.println(answer);
			
			for(Truck t: waiting) {
    			t.going();
    		}
			
		    if(waiting.peek().getPosition() > bridge_length) {
		    	Truck temp = waiting.poll();
		    	weightSum -= temp.weight;
		    	System.out.println("POLL: " + temp.weight);
			}
    		
        	if(!queue.isEmpty() && weightSum + queue.peek().weight <= weight) {
        		Truck temp = queue.poll();
        		temp.going();
            	weightSum += temp.weight;
        		waiting.offer(temp);
    			System.out.println("OFFER: " + temp.weight);
        	}

			System.out.println();
        }
        return answer;
    }
}
public class No42583 {
	
	public static void main(String[] args) {
		solutionClass sc = new solutionClass();
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		System.out.println(sc.solution(bridge_length, weight, truck_weights));
	}
}
