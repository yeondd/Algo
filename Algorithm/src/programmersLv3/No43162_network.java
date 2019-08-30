package programmersLv3;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ��Ʈ��ũ
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

		int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(">>>> " + solution(computers1.length, computers1));
		
		int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(">>>> " + solution(computers2.length, computers2));
		
		int[][] computers3 = {{1,0,0,1}, {0,1,1,1}, {0,1,1,0}, {1,1,0,1}};
		System.out.println(">>>> " + solution(computers3.length, computers3) + "\n");
	}

	static boolean[][] visit;
	static Queue<Node> queue;
	static int[][] computer;
	
	public static void marked(int row, int col) {
		System.out.printf("%d, %d\n", row, col);
		queue.offer(new Node(row, col));
		visit[row][col] = true;
	}
	
	public static void compareAround(int row, int col, int n) {
		int standard = computer[row][col];
		// top
		if(row - 1 >= 0 && standard == computer[row - 1][col] && !visit[row - 1][col]) {
			marked(row - 1, col);
		}
		// right
		if(col + 1 < n && standard == computer[row][col + 1] && !visit[row][col + 1]) {
			marked(row, col + 1);
		}
		// down
		if(row + 1 < n && standard == computer[row + 1][col] && !visit[row + 1][col]) {
			marked(row + 1, col);
		}
		// left
		if(col - 1 >= 0 && standard == computer[row][col - 1] && !visit[row][col - 1]) {
			marked(row, col - 1);
		}
	}
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n][n];
        queue = new LinkedList<Node>();
        computer = computers;
        Node node;
       
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		// �̹� �湮�� ���� �ǳʶڴ�.
        		if(visit[i][j]) continue;
        		
        		// queue�� �ƹ��͵� ���ٸ� ��带 �־�� ��
        		if(queue.isEmpty()) {
    				boolean conect = false;

        			// �ڽŰ� ����Ǿ� �ִ� ���
        			if(i == j) {
        				// �ڽŰ� ����� ��尡 �ϳ��� ������ queue�� �ְ�
        				for(int k = 0; k < n; k++) {
        					if(k != i && computer[i][k] == 1) {
        						conect = true;
        					} else if(k != i && computer[k][i] == 1) {
        						conect = true;
        					}
        				}

        				// ����� ��尡 ������ �ǳʶ�
        				if(conect) continue;
        			}
        			
        			if(computer[i][j] == 1 && !visit[i][j]) {
            			System.out.println("queue is empty");
            			marked(i, j);
            			answer++;
            		}
        		}
        		
        		while(!queue.isEmpty()) {
        			node = queue.poll();
        			int row = node.x;
        			int col = node.y;
        			
        			compareAround(row, col, n);
        		}
        	}
        }
        
        return answer;
    }
}
