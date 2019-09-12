package kakao;

public class Programming4 {

	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] answer = solution(words, queries);
		
		for(int i: answer) {
			System.out.println(i);
		}
	}

	public static int[] solution(String[] words, String[] queries) {
        int[] answer;
        int wordSize = words.length;
        int queriesSize = queries.length;
        answer = new int[queriesSize];
        int markIdx = 0;
        int charIdx = 0;
        
       boolean strBool = false;
       boolean questionBool = false;
       int count = 0;
        for(int i = 0; i < queriesSize; i++) {
            String query = queries[i];
//        	System.out.println(">>> " + query);
        	
            for(int j = 0; j < wordSize; j++) {
            	String word = words[j];
//            	System.out.println(query);
                
                // 두 문자열의 길이가 일치해야 함
                if(query.length() != word.length()) {
                	answer[i] = 0;
                	continue;
                }
                int questionLen = 0;
                markIdx = query.indexOf('?');
                if(markIdx != 0) {
                    int charLastIdx = markIdx;
                	questionLen = query.length() - markIdx;
                	
                	strBool = word.substring(0, charLastIdx).equals(query.substring(0, charLastIdx));
                	questionBool = word.substring(markIdx).length() == questionLen ? true : false;
                }
                else {
                	int charStartIdx = query.lastIndexOf('?') + 1;
                	questionLen = charStartIdx;
                	
                	// 문자부분이 일치하는 경우 
                	strBool = word.substring(charStartIdx).equals(query.substring(charStartIdx));
                	// 물음표개수와 나머지 문자의 개수가 일치하는 경우 
                	questionBool = word.substring(0, charStartIdx).length() == questionLen ? true : false;
                	
                }
                
                if(strBool && questionBool) {
                	count++;
                }
            }
        	answer[i] = count;
            count = 0;
        } 
        
        return answer;
    }
}
