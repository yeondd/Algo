package programmersLv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 오픈 채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */

class Tuple {
	protected String key;
	protected String value;
	
	public Tuple(String k, String v) {
		this.key = k;
		this.value = v;
	}
}

public class No42888_openChat {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo", "Leave uid1234","Change uid4567 Ryan"};
		String[] answer = solution(record);
		for(String str: answer) {
			System.out.println(str);
		}
	}
	
	public static String[] solution(String[] record) {
        String[] answer = {};
        int size = record.length;
        // record를 단어 / 유저아이디 / 닉네임 으로 변경하기 위한 배열
        String[][] table = new String[size][3];
        // 위 배열을 uid순서대로 정렬해서 저장할 배열
        String[][] SortedTable = new String[size][3];
        ArrayList<String> finAnswerArr = new ArrayList<String>();
        
        // 단어 별로 저장
        for(int i = 0; i < size; i++) {
        	String[] temp = record[i].split(" ");
        	for(int j = 0; j < temp.length; j++) {
        		table[i][j] = temp[j];
        		SortedTable[i][j] = temp[j];
        	}
        }
        
        Arrays.sort(SortedTable, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[1];
                final String time2 = entry2[1];
                return time1.compareTo(time2);
            }
        });
        
        // 최종 변경된 닉네임을 uid별로 저장하기 위한 arraylist
        ArrayList<Tuple> al = new ArrayList<Tuple>();
        
        String uid = table[0][1];
        String userName = table[0][2];
        int idx = 0;

        while(idx < size) {
        	if(SortedTable[idx][1].equals(uid)) {
        		if(SortedTable[idx][0].equals("Enter") || SortedTable[idx][0].equals("Change")) {
        			userName = SortedTable[idx][2];
//    	    		System.out.println("\tUserName : " + userName);
        		}
        		
        		idx++;
        	}
        	else {
//	    		System.out.println(">>> add " + userName);
				al.add(new Tuple(uid, userName));
				uid = SortedTable[idx][1];
        	}
        }
        al.add(new Tuple(uid, userName));
        
        idx = 0;
        for(int i = 0; i < size; i++) {
        	String finAnswer = "";

    		switch(table[i][0]) {
    		case "Enter":
    			finAnswer = "님이 들어왔습니다.";
    			break;
    			
    		case "Leave":
    			finAnswer = "님이 나갔습니다.";
    			break;
    			
    		case "Change":
    			break;
    		}

        	if(table[i][1].equals(al.get(idx).key)) {
        		table[i][2] = al.get(idx).value;
        	}
        	else {
        		idx++;
        	}
        	
        	finAnswer = table[i][2] + finAnswer;
        	finAnswerArr.add(finAnswer);
        }
        
        answer = (String[]) finAnswerArr.toArray();
        
        return answer;
    }
}
