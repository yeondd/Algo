package kakao;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * 후보키
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 */

public class No42890_CandidateKey {

	public static void main(String[] args) {
		String[][] relation = {
				{"100","ryan","music","2"}, {"200","apeach","math","2"},
				{"300","tube","computer","3"}, {"400","con","computer","4"},
				{"500","muzi","music","3"},{"600","apeach","music","2"}
				};
		System.out.println("answer: " + solution(relation));

	}
	
	static Comparator<Integer> comp = new Comparator<Integer>() {
		int countBit(int n) {
			int res = 0;
			while(n != 0) {
				if((n & 1) != 0) res++; 
				
				// 오른쪽으로 하나씩 shift 해주면 비트가 하나씩 없어짐
				n = n >> 1;
			}
			
			return res;
		}
		
		public int compare(Integer a, Integer b) {
			// 1로 된 비트 세기
			int x = countBit(a);
			int y = countBit(b);
			
			if(x > y) return 1;
			else if (x < y) return -1;
			else return 0;
		}
	};
	
	public static boolean check(String[][] relation, int rowSize, int colSize, int subset) {

		// for문) 튜플의 쌍을 만들기 위해 사용
		// 왜 a < rowSize - 1 인지 => 비교하면서 갈거니까 마지막 하나는 없어도 됨
		for(int a = 0; a < rowSize - 1; a++) {
			// b는 a 다음부터 비교할거니까 시작을 a + 1로 함
			for(int b = a + 1; b < rowSize; b++) {
				boolean isSame = true;
				
				/* subset에 해당하는 속성 알아보기
				 * ex) subset == 3
				 * 이 때, k 값이 0, 1이라면 1 << k shift 연산 후 0001, 0010이 되고 이건 속성의 1번째, 2번째 값이란 뜻.
				 * 이 k값을 subset이랑 AND 연산하면 0이 되지 않으므로 튜플끼리 같은지 비교하게 됨
				 */
				for(int k = 0; k < colSize; k++) {
					// 1 << k: k번째 비트 켜기
					// subset에 해당하는 값이 있으면 0이 아님 -> 그 외엔 필요 없으므로 skip
					if((subset & 1 << k) == 0) continue;
					
					// k번째 속성에 해당하는 튜플끼리 비교
					if(!relation[a][k].equals(relation[b][k])) {
						isSame = false;
						
						// 튜플이 서로 다른 경우 k-loop를 돌 필요 없으므로 break;
						break;
					}
					// 모든 튜플끼리 비교했을 때 같은게 나오면 k = 1로 증가
					// 다음 속성 값 비교 가능
				}
				
				if(isSame) {
					// 유일성을 만족하지 못했으므로 false return
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static int solution(String[][] relation) {
        int answer = 0;
        int rowSize = relation.length;
        int colSize = relation[0].length;
        
        System.out.println("row size: " + rowSize + "\tcolSize: " + colSize);
        //유일성 만족하는 속성
        List<Integer> candidates = new LinkedList<Integer>();
        
        //공집합은 필요 없음
        // 1 << colSize -> 모든 경우의 수(16가지)를 돌기 위해 사용
        for(int i = 1; i < 1 << colSize; i++) {
        	// i -> i번째 subset
        	if(check(relation, rowSize, colSize, i)) {
        		candidates.add(i);
        	}
        }
        
        // 속성의 개수가 적은 순서대로 정렬
        Collections.sort(candidates, comp);
        
        // 제일 처음에 있는 원소가 유일성을 만족할 것임
        while(candidates.size() != 0) {
        	// 처음엔 무조건 유일성을 만족 
        	int n = candidates.remove(0);
        	answer++;
        	
        	// -> 이후에 해당 키가 포함된 원소들을 제거해야 함(최소성 유지를 위해)
        	for(Iterator<Integer> it = candidates.iterator(); it.hasNext(); ) {
        		int c = it.next();
        		if((n & c) == n) {	// c는 n이 가지는 속성을 가지고 있음(+a)
        			it.remove();
        		}
        	}
        }

        return answer;
    }
	
}
