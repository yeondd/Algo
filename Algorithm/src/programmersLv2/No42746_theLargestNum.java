package programmersLv2;

import java.util.Arrays;
import java.util.Comparator;

// https://programmers.co.kr/learn/courses/30/lessons/42746
// 가장 큰 수 
public class No42746_theLargestNum {

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		String answer = solution(numbers);
		System.out.println(answer);
	}
	
	public static String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;
        String[] strArr = new String[size];

        // convert int arr to string arr
        for(int i = 0; i < size; i++) {
        	strArr[i] = Integer.toString(numbers[i]);
        }

        // sorting
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
            	if(s1.charAt(0) != s2.charAt(0)) {
            		return s2.compareTo(s1);
            	}
            	
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        if(strArr[0].equals("0")) return "0";
        
        for(int i = 0; i < size; i++) {
        	answer += strArr[i];
        }
        
        return answer;
	}
	
}
