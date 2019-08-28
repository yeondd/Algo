package programmersLv3;

/*
 * 보행자 천국
 * https://programmers.co.kr/learn/courses/30/lessons/1832
 * https://hanxxang.tistory.com/77
 */

public class No1832_pedestrian {
	public static void main(String[] args) {
		int m = 3;
		int n = 6;
//		int[][] cityMap = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
//		int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
		int[][] cityMap = {{0, 0, 0, 0, 0, 2}, {0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0}};
		System.out.println(solution(m, n, cityMap));
	}
	
	static int MOD = 20170805;
	// 자동차는 오른쪽 또는 아래 방향으로 한 칸씩 이동 가능
	public static int solution(int m, int n, int[][] cityMap) {
		int answer = 0;
		int[][] resultArr = new int[m][n];
		
		for(int i = 0; i < n; i++) {
			resultArr[0][i] = 1;
		}
		
		for(int i = 0; i < m; i++) {
			resultArr[i][0] = 1;
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				
				switch(cityMap[i][j]) {
				
				case 0:
					if(i > 0 && j > 0) 
						resultArr[i][j] = (resultArr[i - 1][j] % MOD + resultArr[i][j - 1] % MOD) % MOD;
					break;
					
				case 1:
					resultArr[i][j] = 0;
					break;
					
				case 2: 
					if(i > 0 && j > 0) 
						resultArr[i][j] = (resultArr[i - 1][j] % MOD + resultArr[i][j - 1] % MOD) % MOD;
					
					if(resultArr[i][j] > 0) {
						resultArr[i][j] = (resultArr[i][j] - 1) % MOD;
					}
					break;
				}
			}
		}
		
		answer = resultArr[m-1][n-1] % MOD;
	    return answer;
	}
}
