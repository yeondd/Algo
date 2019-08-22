package programmersLv2;

/*
 * 주식가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */

public class No42584 {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] answer = solution(prices);
		for(int i: answer) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int[] prices) {
		int size = prices.length;
        int[] answer = new int[size];
        int time = 0;
        
        for(int i = 0; i < size; i++) {
//			System.out.print(i + " >>> ");
        	time = 0;
        	
        	for(int j = i + 1; j < size; j++) {
//    			System.out.print("\n\t" + j + " *** \n");
//    			System.out.println("\t" + time);
    			
        		if(prices[i] > prices[j]) {
            		time++;
        			break;
        		}

        		time++;
        	}
        	
        	answer[i] = time;
        }
        
        return answer;
    }
}
