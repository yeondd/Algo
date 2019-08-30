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
	
	public Node() {}
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class No43162_network {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(">>>> " + solution(n, computers));
	}

	public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] visit = new boolean[n][n];
        Queue<Node> queue = new LinkedList<Node>();
        Node node = new Node();
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(visit[i][j]) continue;
        		
        		if(queue.isEmpty()) {
            		if(computers[i][j] == 1 && !visit[i][j]) {
            			queue.offer(new Node(i, j));
            			visit[i][j] = true;
            			answer++;
            		}
        		}
        		
        		while(!queue.isEmpty()) {
        			node = queue.poll();
        			int row = node.x;
        			int col = node.y;
        			
            		// top
        			if(row - 1 >= 0 && computers[row][col] == computers[row - 1][col] && !visit[row - 1][col]) {
        				queue.offer(new Node(row - 1, col));
        				visit[row - 1][col] = true;
        			}
        			// right
        			if(col + 1 < n && computers[row][col] == computers[row][col + 1] && !visit[row][col + 1]) {
        				queue.offer(new Node(row, col + 1));
        				visit[row][col + 1] = true;
        			}
        			// down
        			if(row + 1 < n && computers[row][col] == computers[row + 1][col] && !visit[row + 1][col]) {
        				queue.offer(new Node(row + 1, col));
        				visit[row + 1][col] = true;
        			}
        			// left
        			if(col - 1 >= 0 && computers[row][col] == computers[row][col - 1] && !visit[row][col - 1]) {
        				queue.offer(new Node(row, col - 1));
        				visit[row][col - 1] = true;
        			}
        		}
        	}
        }
        
        return answer;
    }
}
