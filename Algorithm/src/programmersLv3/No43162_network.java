package programmersLv3;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 네트워크
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */

class Node {
	int x;
	int y;
	LinkedList<Node> adjacent = new LinkedList<Node>();
	
	public Node() {}
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class No43162_network {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//		System.out.println(">>>> " + solution(computers1.length, computers1));
//		
		int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(">>>> " + solution(computers2.length, computers2));
//		
		int[][] computers3 = {{1,0,0,1}, {0,1,1,1}, {0,1,1,0}, {1,1,0,1}};
		System.out.println(">>>> " + solution(computers3.length, computers3) + "\n");
		
		int[][] computers4 = {{1,0,0,1,0,1,0}, {0,1,0,0,0,0,0}, {0,0,1,0,1,0,1}, {1,0,0,1,0,0,0}, {0,0,1,0,1,0,0}, {1,0,0,0,0,1,0}, {0,0,1,0,0,0,1}};
		System.out.println(">>>> " + solution(computers4.length, computers4) + "\n");
	}

	static boolean[] visit;
	static Queue<Node> queue;
	static int[][] computer;
	
	public static void compareAround(int row, int n) {
		for(int i = 0; i < n; i++) {
			if(!visit[i] && computer[row][i] == 1) {
				visit[i] = true;
            	System.out.println("\tvisited: " + i);
				compareAround(i, n);
			}
		}
	}
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        queue = new LinkedList<Node>();
        computer = computers;
        
        for(int i = 0; i < n; i++) {
        	if(!visit[i]) {
            	System.out.println(i + ") ");
        		compareAround(i, n);
        		answer++;
        	}
        }
       
        return answer;
    }
}
