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
        ArrayList<Truck> waiting = new ArrayList<Truck>();
		Iterator<Truck> iter = waiting.iterator();
        int weightSum = 0;
        int watingIdx = 0;
        
        for(int i: truck_weights) {
        	Truck t = new Truck(i);
        	queue.offer(t);
        }
        
        while(!queue.isEmpty()) {
        	answer++;
        	
        	// 다리 위에 더 올릴 수 없으면 기존 대기줄에 있는 트럭 이동
        	if(weightSum + queue.peek().weight > weight) {
        		while (iter.hasNext()) {
        		    Truck t = iter.next();
        		    
        		    // 트럭이 끝까지 가지 않으면 한 칸 go
        		    if(t.getPosition() < bridge_length) {
            			t.going();
        			}
        		    // 트럭이 끝에 도달한 경우 대기줄에서 제거
        		    else {
        				waiting.remove(t);
        			}
        		}
        	}
        	else {
        		Truck temp = queue.poll();
        		waiting.add(temp);
            	weightSum += temp.weight;
        		watingIdx++;
        	}
        }
        
        return answer;
    }
}
public class No42583 {
	
	public static void main(String[] args) {
		solutionClass sc = new solutionClass();
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		
		System.out.println(sc.solution(bridge_length, weight, truck_weights));
	}
}
