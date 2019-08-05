package programmers;

/*
 * 땅따먹기
 * https://programmers.co.kr/learn/courses/30/lessons/12913
 */

public class No12913 {

	public static void main(String[] args) {
//		int[][] land = {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}, {9, 1, 1, 1}};
		int[][] land = {{1,2,3,5}, {5,6,8,8}, {4,3,3,1}, {9, 1, 1, 8}};
        System.out.println(solution(land));
	}

	public static int solution(int[][] land) {
        if(land.length > 100000) {
        	return 0;
        }
		int answer = 0;

        int maxIdx = -1;
        int temp = 0;
        for(int i = 0; i < land.length; i++) {
            int max = 0;
            
        	for(int j = 0; j < 4; j++) {
//                System.out.print(land[i][j] + " ");
        		
    			System.out.print("<" + j + ">  ");
//        		if(j == maxIdx) System.out.println("이전 행의 max Idx");
//        		if(j != maxIdx) {
//        			if(land[i][j] > max) {
//            			max = land[i][j];
//            			temp = j;	// 다음 행에선 갈 수 없음.
//            		}
//        		}
        		
        		if(land[i][j] > max) {
        			if(j != maxIdx) {
            			max = land[i][j];
            			temp = j;	// 다음 행에선 갈 수 없음.
        			}
        		}

    			System.out.println("maxIdx: " + temp + " / max: " + max);
        	}
			maxIdx = temp;
			answer += max;
			System.out.println("max일 때의 점수: " + max + "  maxIdx: " + maxIdx);
//            System.out.println();
        }

        return answer;
        
    }
}
