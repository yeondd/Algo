package programmersLv3;

/*
 * 정수 삼각형  
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */

public class No43105_integerTriangle {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}

	public static int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        
        int value = triangle[0][0];
        
        for(int i = 1; i < height; i++) {
        	for(int j = 0; j <=  i; j++) {
        		value = triangle[i][j];
        		
        		if(j == 0) {
        			value += triangle[i - 1][j];
        		}
        		else if(j == i) {
        			value += triangle[i - 1][j - 1];
        		}
        		else {
        			int temp1 = value + triangle[i - 1][j - 1];
        			int temp2 = value + triangle[i - 1][j];
        			value = Math.max(temp1, temp2);
        		}

        		triangle[i][j] = value;
//        		System.out.println("vlaue: " + value);
        	}
        }
        
        for(int i = 0; i < height - 1; i++) {
        	if(triangle[height - 1][i] >= answer) {
        		answer = triangle[height - 1][i];
        	}
        }
        return answer;
    }
}
