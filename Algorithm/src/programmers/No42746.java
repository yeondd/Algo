package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 가장 큰 수
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */

public class No42746 {

	public static void main(String[] args) {
//		int[] numbers = {3, 30, 34, 5, 9};
		int[] numbers = {9, 11111};
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;
        /*
        List<String> numberStr = new ArrayList<String>();
        
        Arrays.sort(numbers);
        for(int i = size - 1; i >= 0; i--) {
    		System.out.print(numbers[i] + " ");
        	numberStr.add(Integer.toString(numbers[i]));
        }
//        Collections.sort(numberStr);
        Collections.sort(numberStr, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				
				return arg1.charAt(0) - arg0.charAt(0);
			}
        });

        for(int i = 0; i < size; i++) {
    		System.out.print(numberStr.get(i) + " ");
        	answer += numberStr.get(i) + "/";
        }
		System.out.println(" ");
		*/

        String[] numStr = new String[size];
        Arrays.sort(numbers);
        for(int i = size - 1; i >= 0; i--) {
    		numStr[size - i - 1] = Integer.toString(numbers[i]);
//    		System.out.print(numStr[size - i - 1] + " ");
        }
        
        int maxJari = numStr[0].length();
        int jari = 1;        
        for(int i = 0; i < size; i++) {
    		System.out.println("jari: " + jari);
        	for(int j = 0; j < size; j++) {
        		String temp = numStr[j];
        		if(!temp.equals("") && temp.length() == jari) {
            		System.out.println(" -> " + temp);
            		answer += temp;
            		numStr[j] = "";
            	}
        	}
    		jari++;
        }
        
        return answer;
    }
}
