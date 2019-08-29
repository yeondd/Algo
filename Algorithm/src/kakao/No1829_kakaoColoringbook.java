package kakao;

/*
 * īī�� ������ �÷�����
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	private int i;
	private int j;
	
	public Node(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
}

public class No1829_kakaoColoringbook {

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		
//		int[][] picture = { { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },
//        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 }, { 1, 1, 2, 1, 2, 1, 1, 2, 1, 2 } };;
//		int[][] picture = {{0, 0,0,0,0,0,0,1,1,0,0,0,0,0,0,0}, {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0}};
//		int[][] picture = {{ 1, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 3, 3, 3, 1 }, { 3, 3, 3, 1 }};

		int[] answer = solutionDFS(m, n, picture);
		System.out.println("DFS > " + answer[0] + ", " + answer[1]);

		int[] BFSanswer = solutionBFS(m, n, picture);
		System.out.println("BFS > " + BFSanswer[0] + ", " + BFSanswer[1]);
	}
	
	public static int[] solutionBFS(int m, int n, int[][] picture) {
		int area = 0;
		int numberOfArea = 0;
	    int maxSizeOfOneArea = 0;
	    
		Queue<Node> queue = new LinkedList<Node>();
		boolean[][] visited = new boolean[m][n];

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j]) {
					continue;
				}
				
				if(queue.isEmpty()) {
					if(picture[i][j] != 0 && !visited[i][j]) {
//						System.out.printf(">>>>>>>>>(%d, %d) queue is empty AND Not visited\n", i, j);
						queue.offer(new Node(i, j));
						visited[i][j] = true;
						
						if(maxSizeOfOneArea < area) {
							maxSizeOfOneArea = area;
		    			}
						
						area = 0;
						numberOfArea++;
					}
				}
				
				while(!queue.isEmpty()) {
					Node temp = queue.poll();
					int row = temp.getI();
					int col = temp.getJ();
					area++;
//					System.out.printf("POP (%d, %d) \n", row, col);
					
					// ���� ��� ��� �ֱ�
					if(row - 1 >= 0 && picture[row][col] == picture[row - 1][col] && !visited[row - 1][col]) {
//						System.out.printf("push %d, %d\n", row - 1, col);
						queue.offer(new Node(row - 1, col));
						visited[row - 1][col] = true;
					}
					if(col + 1 < n && picture[row][col] == picture[row][col + 1] && !visited[row][col + 1]) {
//						System.out.printf("push %d, %d\n", row, col + 1);
						queue.offer(new Node(row, col + 1));
						visited[row][col + 1] = true;
					}
					if(row + 1 < m && picture[row][col] == picture[row + 1][col] && !visited[row + 1][col]) {
//						System.out.printf("push %d, %d\n", row + 1, col);
						queue.offer(new Node(row + 1, col));
						visited[row + 1][col] = true;
					}
					if(col - 1 >= 0 && picture[row][col] == picture[row][col - 1] && !visited[row][col - 1]) {
//						System.out.printf("push %d, %d\n", row, col - 1);
						queue.offer(new Node(row, col - 1));
						visited[row][col - 1] = true;
					}
				}
			}
		}
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		
		return answer;
	}

	public static int[] solutionDFS(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      int area = 0;
	      
	      boolean[][] visited = new boolean[m][n];
	      Stack<Node> stack = new Stack<Node>();
	      
	      // ó������ �ϳ��ϳ� üũ�ϸ鼭
	      for(int i = 0; i < m; i++) {
	    	  for(int j = 0; j < n; j++) {
	    		  if(visited[i][j]) {
						continue;
	    		  }
	    		  
	    		  // �湮�� �� ���� ��带 ã��
	    		  if(stack.isEmpty()) {
	    			  if(picture[i][j] != 0 && !visited[i][j]) {
		    			  numberOfArea++;
//		    			  System.out.println("number of area: " + numberOfArea);
//		    			  System.out.println("PUSH > " + i + ", " + j);
		    			  
		    			  // ���ÿ� �־��ְ� �湮�ߴٰ� ǥ����
		    			  stack.push(new Node(i, j));
		    			  visited[i][j] = true;
		    			  
		    			  if(maxSizeOfOneArea < area) {
		    				  maxSizeOfOneArea = area;
		    			  }
		    			  
		    			  // �湮�� ���� �����Ƿ� ������ �ٽ� Ȯ���ؾߵ�
		    			  area = 0;
	    			  }
	    		  }
    			  
    			  // ���ÿ� ó�� �� ���� �������� �̾����� ��� ������ ���ÿ� �ְ� ���鼭 ����Ȯ��
	    		  while (!stack.isEmpty()) {
	    			  Node node = stack.pop();
		    		  area++;
//		    		  System.out.println(">>>> POP > " + node.getI() + ", " + node.getJ());
		    		  int row = node.getI();
		    		  int column = node.getJ();
		    		  
		    		  // ��ü ũ�� ���� �ְ� && ���� ��ġ�� �����ؼ� ���� ���̰� && �湮������ ���� ��� ã�Ƽ� ���ÿ� push
		    		  // ��
		    		  if(row - 1 >= 0 && picture[row][column] == picture[row - 1][column] && !visited[row - 1][column]) {
//		    			  System.out.println("PUSH > " + (row - 1) + ", " + column);
		    			  stack.push(new Node(row - 1, column));
		    			  visited[row - 1][column] = true;
		    		  }
		    		  // ��
		    		  if(row + 1 <= m - 1 && picture[row][column] == picture[row + 1][column] && !visited[row + 1][column]) {
//		    			  System.out.println("PUSH > " + (row + 1) + ", " + column);
		    			  stack.push(new Node(row + 1, column));
		    			  visited[row + 1][column] = true;
		    		  }
		    		  // ��
		    		  if(column - 1 >= 0 && picture[row][column] == picture[row][column - 1] && !visited[row][column - 1]) {
//		    			  System.out.println("PUSH > " + row + ", " + (column - 1));
		    			  stack.push(new Node(row, column - 1));
		    			  visited[row][column - 1] = true;
		    		  }
		    		  // ��
		    		  if(column + 1 <= n - 1 && picture[row][column] == picture[row][column + 1] && !visited[row][column + 1]) {
//		    			  System.out.println("PUSH > " + row + ", " + (column + 1));
		    			  stack.push(new Node(row, column + 1));
		    			  visited[row][column + 1] = true;
		    		  }
	    		  }
	    	  }
	      }
	      
//	      if(numberOfArea == 1) maxSizeOfOneArea = area;
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      
	      return answer;
	  }
}
