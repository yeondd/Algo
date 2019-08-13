package programmers;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42588
 */

public class No42588 {

	public static void main(String[] args) {
		int[] heights = {6,9,5,7,4};
		int[] answer = solution(heights);
		for(int i: answer) {
			System.out.print(i + " ");
		}

	}

	public static int[] solution(int[] heights) {
		int size = heights.length;
        int[] answer = new int[size];
        
        for(int i = size - 1; i >= 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				System.out.print("j: " + heights[j] + " \n");
				
				if(heights[i] < heights[j]) {
					System.out.println("\t" + j);
					System.out.println("\ti) " + i);
					answer[i] = j + 1;
					break;
				}
			}
        }
        
        return answer;
    }
}
