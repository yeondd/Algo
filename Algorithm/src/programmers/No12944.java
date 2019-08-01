package programmers;

/*
 * Æò±Õ ±¸ÇÏ±â
 * https://programmers.co.kr/learn/courses/30/lessons/12944
 */

public class No12944 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		System.out.println(solution(arr));
	}
	
	public static double solution(int[] arr) {
		double answer = 0;
		int size = arr.length;
		double sum = 0;
		
		for(int i = 0; i < size; i++) {
			sum += arr[i];
		}
		
		answer = sum / size;
		// int / double -> int·Î ¹ÝÈ¯µÊ!
		
        return answer;
    }
}
