package programmers;

/*
 * Çà·ÄÀÇ µ¡¼À
 * https://programmers.co.kr/learn/courses/30/lessons/12950
 */

public class No12950 {

	public static void main(String[] args) {
	}

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = {};
		int rowSize = arr1.length;
		int columnSize = arr1[0].length;
		answer = new int[rowSize][columnSize];
		
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < columnSize; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		
	    return answer;
	}
}
