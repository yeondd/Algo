package programmersLv3;

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
//		int[][] picture = { { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },
//        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 }, { 1, 1, 2, 1, 2, 1, 1, 2, 1, 2 } };;
//		int[][] picture = {{0, 0,0,0,0,0,0,1,1,0,0,0,0,0,0,0}, {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0}};
//		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[][] picture = {{ 1, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 3, 3, 3, 1 }, { 3, 3, 3, 1 }};

		int[] answer = solution(m, n, picture);
		System.out.println(answer[0] + ", " + answer[1]);
	}

	public static int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      int area = 0;
	      
	      boolean[][] visited = new boolean[m][n];
	      Stack<Node> stack = new Stack<Node>();
	      
	      // 처음부터 하나하나 체크하면서
	      for(int i = 0; i < m; i++) {
	    	  for(int j = 0; j < n; j++) {
	    		  // 방문한 적 없는 노드를 찾음
    			  if(picture[i][j] != 0 && !visited[i][j]) {
	    			  numberOfArea++;
//	    			  System.out.println("number of area: " + numberOfArea);
//	    			  System.out.println("PUSH > " + i + ", " + j);
	    			  
	    			  // 스택에 넣어주고 방문했다고 표시함
	    			  stack.push(new Node(i, j));
	    			  visited[i][j] = true;
	    			  
	    			  if(maxSizeOfOneArea < area) {
	    				  maxSizeOfOneArea = area;
	    			  }
	    			  
	    			  // 방문한 적이 없으므로 영역은 다시 확인해야됨
	    			  area = 0;
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
