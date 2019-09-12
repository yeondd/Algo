package kakao;

public class StringCompression {

	public static void main(String[] args) {

		String s = "ababcdcdababcdcd";
		System.out.println("solution: " + solution(s));
	}

	public static int solution(String s) {
        int answer = 0;
        int size = s.length();
        String answerStr = "";
        
        int k = 1;
        int count = 0;
        answer = size;
        
        for(k = 1; k < size; k++) {
        	String standard = s.substring(0, k);
//        	System.out.println("k: " + k);
//        	System.out.println("standard: " + standard);
        	int i = 0;
           	for(i = 0; i + k <= size; i += k) {
           		String compare = s.substring(i, i + k);
//            	System.out.println(i + "/ compare: " + compare);
        		if(compare.equals(standard)) {
        			count++;
        		}
        		else {
        			if(count >= 2) {
            			answerStr += count;
        			}
        			answerStr += standard;
        			
        			standard = s.substring(i, i + k);
        			count = 1;
//        			System.out.println(answerStr);
//                	System.out.println("standard: " + standard);
        		}
        	}
           	if(count >= 2) {
    			answerStr += count;
			}
			answerStr += standard;

			String last = s.substring(i);
//			System.out.println("last: " + last);
			answerStr += last;
//			System.out.println("\t>>>> " + answerStr);
			answer = Math.min(answerStr.length(), answer);
			answerStr = "";
			count = 0;
        }
        
        return answer;
    }
}
