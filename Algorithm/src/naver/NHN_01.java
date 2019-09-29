package naver;

import java.util.*;

public class NHN_01 {

	public static void main(String[] args) {
		boolean answer = false;
		
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int cardNum = scan.nextInt();
		HashMap<String, Integer> set = new HashMap<>();

		System.out.println(cardNum);

		int count = 0;
		int max = 0;
		for(int i = 0; i < cardNum; i++) {
			String str = scan.next();
			
			if(set.containsKey(str)) {
				count = set.get(str) + 1;
				set.put(str, count);
			}
			else {
				count = 1;
				set.put(str, count);
			}
			
			if(max < count) max = count;
		}

        int sum = 0;
        boolean flag = false;
		for(String key : set.keySet()){
            int value = set.get(key);
//            System.out.println(key + "  " + value);
            sum += value;
            
            if(max != value) {
            	if(flag) {
            		answer = false;
            		break;
            	}
            	else {
            		flag = true;
            		answer = true;
            		sum++;
            	}
            }
            else {
            	answer = true;
            }
        }

        int var = set.keySet().size();
		if(answer) {
	        System.out.println("Y");
	        System.out.println(sum);
	        System.out.println(var);
		}
		else {
	        System.out.println("N");
	        System.out.println(cardNum);
	        System.out.println(var);
		}
	}

}
