package naver;

import java.util.*;

public class NHN_02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		HashMap<Integer, Integer> set = new HashMap<>();
		Queue<Integer> qu = new LinkedList<Integer>();
		
		int count = 0;
		int max = 0;
		int maxKey = 0;
		for(int i = 0; i < num; i++) {
			String command = scan.next();
			
			if(command.equals("enqueue")) {
				int key = scan.nextInt();
				qu.offer(key);
				
				if(set.containsKey(key)) {
					count = set.get(key) + 1;
					set.put(key, count);
				}
				else {
					count = 1;
					set.put(key, count);
				}

				if(max < count) {
					max = count;
					maxKey = key;
				}
			}
			
			else if(command.equals("dequeue")) {
				while(true) {
					if(qu.peek() == maxKey) {
						System.out.print(qu.poll());
						set.put(maxKey, set.get(maxKey) - 1);
					}
				}
			}

		}

	}

}
