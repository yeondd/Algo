package programmersLv3;

import java.util.ArrayList;

public class No1829_kakaoColoringbook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] answer = solution(m, n, picture);
//		System.out.println(answer[0]);
//		System.out.println(answer[1]);
	}
	static int area = 0;
	
	public static void check(int i, int j, int[][] picture, boolean[][] visited) {
		int rowLimit = picture.length;
		int columnLimit = picture[0].length;

		// �ش� �ε����� ��, ���� üũ
		if (!visited[i][j] && i < rowLimit - 1 && j < columnLimit - 1) {
			System.out.printf("%d, %d-> visited? %b\n", i, j, visited[i][j]);
			
			  if(picture[i][j] == picture[i][j + 1]) {
				  System.out.println("\t�� - ��ġ");
				  area++;
				  visited[i][j] = true;
					
				  check(i, j + 1, picture, visited);
			  }
			  
			  // �Ʒ� üũ
			  if(picture[i][j] == picture[i + 1][j]) {
				  System.out.println("\t�� - ��ġ");
				  area++;
				  visited[i][j] = true;
				  check(i + 1, j, picture, visited);
			  }
			  
			  // ���� üũ
			  if(j > 0 && picture[i][j] == picture[i][j - 1]) {
				  System.out.printf("\t��(%d, %d) - ��ġ\n", i , j - 1);
				  area++;
				  visited[i][j] = true;
				  check(i, j - 1, picture, visited);
			  }
			  
			  // �� üũ
			  if(i > 0 && i > 0 && picture[i][j] == picture[i - 1][j]) {
				  System.out.println("\t�� - ��ġ");
				  area++;
				  visited[i][j] = true;
				  check(i - 1, j, picture, visited);
			  }
			  
			  {
				System.out.println(i + ", " + j + " *** out");
			  }
		} 
		
		else {
			System.out.println("\t" + i + ", " + j + "�� �̹� �湮");
			return;
		}
	}

	public static int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      int[] colorCheck = new int[n];
	      boolean[][] check = new boolean[m][n];
	      int tempArea = 0;

		  
//	      ArrayList<Integer> colorCheck = new ArrayList<Integer>();
	      
	      for(int i = 0; i < m; i++) {
	    	  for(int j = 0; j < n; j++) {
		    	  System.out.println();
	    		  if(!check[i][j] && picture[i][j] != 0) check(i, j, picture, check);
	    	  }
	    	  System.out.println(">>>> out");
	      }
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      
	      return answer;
	  }
}
