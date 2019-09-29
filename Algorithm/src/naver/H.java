package naver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class H {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] movies = {"a", "x","v","v","c","c"};
		String[] answer = solution(movies);
	}

	public static String[] solution(String[] movies) {
		String[] answer;
		ArrayList<MoiveData> list = new ArrayList<MoiveData>();
		Arrays.sort(movies);
		
		String str = movies[0];
		int count = 0;
		
		for(int i = 0; i < movies.length; i++) {
			if(movies[i].equals(str)) {
				count++;
			}
			else {
				MoiveData md = new MoiveData();
				md.movie = str;
				md.count = count;
				list.add(md);
				
				str = movies[i];
				count = 1;
			}
		}
		
		MoiveData md = new MoiveData();
		md.movie = str;
		md.count = count;
		list.add(md);

		answer = new String[list.size()];
		
		Collections.sort(list, new Comparator<MoiveData>() {

			@Override
			public int compare(MoiveData o1, MoiveData o2) {
				// TODO Auto-generated method stub
				if(o1.count > o2.count) {
					return -1;
				}
				else if (o1.count < o2.count){
					return 1;
				}
				else {
					return 0;
				}
			}
			
		});

		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).movie + "  " + list.get(i).count);
			answer[i] = list.get(i).movie;
		}
		
		
		return answer;
	}
}

class MoiveData {
	String movie;
	int count;
}
