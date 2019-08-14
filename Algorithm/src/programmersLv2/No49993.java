package programmersLv2;

/*
 * 스킬트리
 * https://programmers.co.kr/learn/courses/30/lessons/49993
 */

import java.util.ArrayList;

public class No49993 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "ANM"};
		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Integer> checkOrder = new ArrayList<Integer>();
        
        for(int i = 0; i < skill_trees.length; i++) {
        	String[] str = skill_trees[i].split("");
        	int size = str.length;

        	for(int j = 0; j < size; j++) {
        		if(skill.contains(str[j])) {
        			checkOrder.add(skill.indexOf(str[j]));
        		}
        	}
        	
        	boolean check = false;
        	if(checkOrder.size() == 0) answer++;
        	else {
            	for(int k = 0; k < checkOrder.size(); k++) {
            		if(k != checkOrder.get(k)) {
            			check = false;
            			break;
            		}
            		else {
            			check = true;
            		}
            	}

            	if(check) answer++;
        	}

        	checkOrder.clear();
        }
        
        return answer;
    }
}
