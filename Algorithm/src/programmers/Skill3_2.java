package programmers;

public class Skill3_2 {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}

	public static int solution(int[][] triangle) {
        int answer = 0;
        int row = triangle.length;
        int column = triangle[row - 1].length;
        
        System.out.printf("row: %d, column: %d\n", row, column);
        
        answer += triangle[0][0];
        int idx = 0;
        // 마지막 행 윗 행에서 max 값으로 갈 수 있는 인덱스 중 큰 값
        for(int i = row - 1; i < 1; i++) {
        	
        }
        
        return answer;
    }
}
