package kakao;

/*
 * 카카오 프렌즈 컬러링북
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
					
					// 인접 노드 모두 넣기
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
	      
	      // 처음부터 하나하나 체크하면서
	      for(int i = 0; i < m; i++) {
	    	  for(int j = 0; j < n; j++) {
	    		  if(visited[i][j]) {
						continue;
	    		  }
	    		  
	    		  // 방문한 적 없는 노드를 찾음
	    		  if(stack.isEmpty()) {
	    			  if(picture[i][j] != 0 && !visited[i][j]) {
		    			  numberOfArea++;
//		    			  System.out.println("number of area: " + numberOfArea);
//		    			  System.out.println("PUSH > " + i + ", " + j);
		    			  
		    			  // 스택에 넣어주고 방문했다고 표시함
		    			  stack.push(new Node(i, j));
		    			  visited[i][j] = true;
		    			  
		    			  if(maxSizeOfOneArea < area) {
		    				  maxSizeOfOneArea = area;
		    			  }
		    			  
		    			  // 방문한 적이 없으므로 영역은 다시 확인해야됨
		    			  area = 0;
	    			  }
	    		  }
    			  
    			  // 스택에 처음 들어간 값을 시작으로 이어지는 모든 노드들을 스택에 넣고 빼면서 영역확인
	    		  while (!stack.isEmpty()) {
	    			  Node node = stack.pop();
		    		  area++;
//		    		  System.out.println(">>>> POP > " + node.getI() + ", " + node.getJ());
		    		  int row = node.getI();
		    		  int column = node.getJ();
		    		  
		    		  // 전체 크기 내에 있고 && 현재 위치에 인접해서 같은 값이고 && 방문한적이 없는 노드 찾아서 스택에 push
		    		  // 상
		    		  if(row - 1 >= 0 && picture[row][column] == picture[row - 1][column] && !visited[row - 1][column]) {
//		    			  System.out.println("PUSH > " + (row - 1) + ", " + column);
		    			  stack.push(new Node(row - 1, column));
		    			  visited[row - 1][column] = true;
		    		  }
		    		  // 하
		    		  if(row + 1 <= m - 1 && picture[row][column] == picture[row + 1][column] && !visited[row + 1][column]) {
//		    			  System.out.println("PUSH > " + (row + 1) + ", " + column);
		    			  stack.push(new Node(row + 1, column));
		    			  visited[row + 1][column] = true;
		    		  }
		    		  // 좌
		    		  if(column - 1 >= 0 && picture[row][column] == picture[row][column - 1] && !visited[row][column - 1]) {
//		    			  System.out.println("PUSH > " + row + ", " + (column - 1));
		    			  stack.push(new Node(row, column - 1));
		    			  visited[row][column - 1] = true;
		    		  }
		    		  // 우
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
