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
		int m = 5;
		int n = 10;
		int[][] picture = { { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 }, { 1, 1, 2, 1, 2, 1, 1, 2, 1, 2 } };;

//		int[][] picture = {{1,1,1,1}, {1,0,0,0}, {0,0,1,0}, {0,0,0,0}};
//		int[][] picture = {{0, 0,0,0,0,0,0,1,1,0,0,0,0,0,0,0}, {0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0}};
//		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

		int[] answer = solution(m, n, picture);
		System.out.println(answer[0] + ", " + answer[1]);
	}

	public static int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      int area = 0;
	      
	      boolean[][] visited = new boolean[m][n];
	      Stack<Node> stack = new Stack<Node>();
	      
	      for(int i = 0; i < m; i++) {
	    	  for(int j = 0; j < n; j++) {
    			  System.out.println("i: " + i + "\tj: " + j);
    			  
    			  if(picture[i][j] != 0 && !visited[i][j]) {
	    			  numberOfArea++;
	    			  System.out.println("number of area: " + numberOfArea);
	    			  System.out.println("PUSH > " + i + ", " + j);
	    			  stack.push(new Node(i, j));
	    			  visited[i][j] = true;
	    			  
	    			  if(maxSizeOfOneArea < area) {
	    				  maxSizeOfOneArea = area;
	    			  }
	    			  area = 0;
    			  }
    			  else {
    				  continue;
    			  }
    			  
	    		  while (!stack.isEmpty()) {
	    			  Node node = stack.pop();
		    		  System.out.println(">>>> POP > " + node.getI() + ", " + node.getJ());
		    		  int row = node.getI();
		    		  int column = node.getJ();
		    		  area++;
		    		  
		    		  // ╩С
		    		  if(row - 1 >= 0 && picture[row][column] == picture[row - 1][column] && !visited[row - 1][column]) {
		    			  System.out.println("PUSH > " + (row - 1) + ", " + column);
		    			  stack.push(new Node(row - 1, column));
		    			  visited[row - 1][column] = true;
		    		  }
		    		  // го
		    		  if(row + 1 <= m - 1 && picture[row][column] == picture[row + 1][column] && !visited[row + 1][column]) {
		    			  System.out.println("PUSH > " + (row + 1) + ", " + column);
		    			  stack.push(new Node(row + 1, column));
		    			  visited[row + 1][column] = true;
		    		  }
		    		  // аб
		    		  if(column - 1 >= 0 && picture[row][column] == picture[row][column - 1] && !visited[row][column - 1]) {
		    			  System.out.println("PUSH > " + row + ", " + (column - 1));
		    			  stack.push(new Node(row, column - 1));
		    			  visited[row][column - 1] = true;
		    		  }
		    		  // ©Л
		    		  if(column + 1 <= n - 1 && picture[row][column] == picture[row][column + 1] && !visited[row][column + 1]) {
		    			  System.out.println("PUSH > " + row + ", " + (column + 1));
		    			  stack.push(new Node(row, column + 1));
		    			  visited[row][column + 1] = true;
		    		  }
	    		  }
	    	  }
	      }
	      
	      if(numberOfArea == 1) maxSizeOfOneArea = area;
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      
	      return answer;
	  }
}
