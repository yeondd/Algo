package programmers;

import java.util.Arrays;

/*
 * 제일 작은 수 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12935
 */

public class No12935 {

	public static void main(String[] args) {
		int[] arr = {4, 3, 1};
		for(int i: solution(arr)) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] arr) {
		int size = arr.length;
		int[] answer = {};
		
		if(size == 1) {
			answer = new int[1];
			answer[0] = 1;
			return answer;
		}

		answer = new int[size - 1];
		int minIdx = 0;
		
		// 제일 작은 값이 있는 인덱스 찾기
		for(int i = 0; i < size; i++) {
			if(arr[minIdx] > arr[i]) {
				minIdx = i;
			}
		}

//		System.out.println(minIdx);
		int j = 0;
		for(int i = 0; i < size; i++) {
			if(i == minIdx) {
				continue;
			}
			else {
				answer[j] = arr[i];
				j++;
			}
		}
		
	    return answer;
	}
}
