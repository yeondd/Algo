package programmersLv3;

import java.util.LinkedList;

/*
 * 정수 삼각형  
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */

class Node {
	int v;
	int x;
	int y;
	LinkedList<Node> adjacent = new LinkedList<Node>();
	
	public Node() {}
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	public Node(int v, int x, int y) {
		this.v = v;
		this.x = x;
		this.y = y;
	}
}

public class No43105_integerTriangle {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}

	public static int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int maxNum = triangle[height - 1].length;
        Node[][] nodeTriangle = new Node[height][maxNum];
        
        int value = triangle[0][0];
        int left = triangle[0][0];
        int right = triangle[0][0];
        nodeTriangle[0][0] = new Node(value, left, right);
        
        for(int i = 1; i < height; i++) {
        	for(int j = 0; j <=  i; j++) {
        		value = triangle[i][j];
//        		System.out.println("vlaue: " + value);
        		
        		if(j == 0) {
        			right = nodeTriangle[i - 1][j].x + triangle[i][j];
        			left = right;
        		} 
        		else if(j == i) {
            		left = nodeTriangle[i - 1][j - 1].x + triangle[i][j];
            		right = left;
        		}
        		else {
        			left = nodeTriangle[i - 1][j - 1].y + triangle[i][j];
        			right = nodeTriangle[i - 1][j].x + triangle[i][j];
        		}

//        		System.out.println("\tleft: " + left);
//        		System.out.println("\tright: " + right);
        		nodeTriangle[i][j] = new Node(value, left, right);
        	}
//    		System.out.println("==================");
        }
        
        int maxPath = -1;
        for(int i = 0; i < height - 1; i++) {
        	if(nodeTriangle[height - 1][i].x >= maxPath) {
        		maxPath = nodeTriangle[height - 1][i].x;
        	}
        	
        	if(nodeTriangle[height - 1][i].y >= maxPath) {
        		maxPath = nodeTriangle[height - 1][i].y;
        	}
        }
        answer = maxPath;
       
        return answer;
    }
}
