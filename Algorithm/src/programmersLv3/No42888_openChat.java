package programmersLv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/*
 * 오픈채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */

class Tuple {
	protected String key;
	protected String value;
	
	public Tuple(String k, String v) {
		this.key = k;
		this.value = v;
	}
	
	public String toString() {
		return key + " " + value;
	}
}

public class No42888_openChat {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer = solutionArr(record);
//		for(String str: answer) {
//			System.out.println(str);
//		}
		
		answer = solution(record);
		for(String str: answer) {
			System.out.println(str);
		}
	}
	
	public static String[] solution(String[] record) {
		String[] answer = {};
		int size = record.length;
		HashMap<String, String> set = new HashMap<String, String>();
        String[][] table = new String[size][3];
        ArrayList<String> finAnswerArr = new ArrayList<String>();
        
        for(int i = 0; i < size; i++) {
        	String[] temp = record[i].split(" ");
        	for(int j = 0; j < temp.length; j++) {
        		table[i][j] = temp[j];
        	}

            if(table[i][0].compareTo("Leave") != 0) {
	    		set.put(table[i][1], table[i][2]);
            }
        }
        
        String answerStr = "";
        for(int i = 0; i < size; i++) {
        	if(table[i][0].equals("Enter")) {
        		answerStr = "님이 들어왔습니다.";
        		answerStr = (String) set.get(table[i][1]) + answerStr;
            	finAnswerArr.add(answerStr);
        	}
        	else if(table[i][0].equals("Leave")) {
        		answerStr = "님이 나갔습니다.";
        		answerStr = (String) set.get(table[i][1]) + answerStr;
            	finAnswerArr.add(answerStr);
        	}
        	else if(table[i][0].equals("Change")) {
        		
        	}
        	
        }
        
        answer = finAnswerArr.toArray(new String[finAnswerArr.size()]);
		return answer;
	}
	
	public static String[] solutionArr(String[] record) {
        String[] answer = {};
        int size = record.length;
        // record占쏙옙 占쌤억옙 / 占쏙옙占쏙옙占쏙옙占싱듸옙 / 占싻놂옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싹깍옙 占쏙옙占쏙옙 占썼열
        String[][] table = new String[size][3];
        // 占쏙옙 占썼열占쏙옙 uid占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙占쌔쇽옙 占쏙옙占쏙옙占쏙옙 占썼열
        String[][] SortedTable = new String[size][3];
        ArrayList<String> finAnswerArr = new ArrayList<String>();
        
        // 占쌤억옙 占쏙옙占쏙옙 占쏙옙占쏙옙
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
        
        // 占쏙옙占쏙옙 占쏙옙占쏙옙占� 占싻놂옙占쏙옙占쏙옙 uid占쏙옙占쏙옙 占쏙옙占쏙옙占싹깍옙 占쏙옙占쏙옙 arraylist
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
        
		for(int j = 0; j < al.size(); j++) {
    		String tempUid = al.get(j).key;
    		String tempUserName = al.get(j).value;
    		
            for(int i = 0; i < size; i++) {
            	if(table[i][1].equals(tempUid)) {
            		table[i][2] = tempUserName;
            	}
            }
		}

		idx = 0;
		while(idx < size) {
			String finAnswer = "";

        	if(table[idx][0].equals("Enter")) {
        		finAnswer = "�떂�씠 �뱾�뼱�솕�뒿�땲�떎.";
            	finAnswer = table[idx][2] + finAnswer;
            	finAnswerArr.add(finAnswer);
        		idx++;
        	}
        	else if(table[idx][0].equals("Leave")) {
        		finAnswer = "�떂�씠 �굹媛붿뒿�땲�떎.";
            	finAnswer = table[idx][2] + finAnswer;
            	finAnswerArr.add(finAnswer);
        		idx++;
        	}
        	else if(table[idx][0].equals("Change")) {
        		idx++;
        	}
        	
		}
		answer = finAnswerArr.toArray(new String[finAnswerArr.size()]);
        
        return answer;
    }
}
