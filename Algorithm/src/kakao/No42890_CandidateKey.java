package kakao;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * �ĺ�Ű
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
				
				// ���������� �ϳ��� shift ���ָ� ��Ʈ�� �ϳ��� ������
				n = n >> 1;
			}
			
			return res;
		}
		
		public int compare(Integer a, Integer b) {
			// 1�� �� ��Ʈ ����
			int x = countBit(a);
			int y = countBit(b);
			
			if(x > y) return 1;
			else if (x < y) return -1;
			else return 0;
		}
	};
	
	public static boolean check(String[][] relation, int rowSize, int colSize, int subset) {

		// for��) Ʃ���� ���� ����� ���� ���
		// �� a < rowSize - 1 ���� => ���ϸ鼭 ���Ŵϱ� ������ �ϳ��� ��� ��
		for(int a = 0; a < rowSize - 1; a++) {
			// b�� a �������� ���ҰŴϱ� ������ a + 1�� ��
			for(int b = a + 1; b < rowSize; b++) {
				boolean isSame = true;
				
				/* subset�� �ش��ϴ� �Ӽ� �˾ƺ���
				 * ex) subset == 3
				 * �� ��, k ���� 0, 1�̶�� 1 << k shift ���� �� 0001, 0010�� �ǰ� �̰� �Ӽ��� 1��°, 2��° ���̶� ��.
				 * �� k���� subset�̶� AND �����ϸ� 0�� ���� �����Ƿ� Ʃ�ó��� ������ ���ϰ� ��
				 */
				for(int k = 0; k < colSize; k++) {
					// 1 << k: k��° ��Ʈ �ѱ�
					// subset�� �ش��ϴ� ���� ������ 0�� �ƴ� -> �� �ܿ� �ʿ� �����Ƿ� skip
					if((subset & 1 << k) == 0) continue;
					
					// k��° �Ӽ��� �ش��ϴ� Ʃ�ó��� ��
					if(!relation[a][k].equals(relation[b][k])) {
						isSame = false;
						
						// Ʃ���� ���� �ٸ� ��� k-loop�� �� �ʿ� �����Ƿ� break;
						break;
					}
					// ��� Ʃ�ó��� ������ �� ������ ������ k = 1�� ����
					// ���� �Ӽ� �� �� ����
				}
				
				if(isSame) {
					// ���ϼ��� �������� �������Ƿ� false return
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
        //���ϼ� �����ϴ� �Ӽ�
        List<Integer> candidates = new LinkedList<Integer>();
        
        //�������� �ʿ� ����
        // 1 << colSize -> ��� ����� ��(16����)�� ���� ���� ���
        for(int i = 1; i < 1 << colSize; i++) {
        	// i -> i��° subset
        	if(check(relation, rowSize, colSize, i)) {
        		candidates.add(i);
        	}
        }
        
        // �Ӽ��� ������ ���� ������� ����
        Collections.sort(candidates, comp);
        
        // ���� ó���� �ִ� ���Ұ� ���ϼ��� ������ ����
        while(candidates.size() != 0) {
        	// ó���� ������ ���ϼ��� ���� 
        	int n = candidates.remove(0);
        	answer++;
        	
        	// -> ���Ŀ� �ش� Ű�� ���Ե� ���ҵ��� �����ؾ� ��(�ּҼ� ������ ����)
        	for(Iterator<Integer> it = candidates.iterator(); it.hasNext(); ) {
        		int c = it.next();
        		if((n & c) == n) {	// c�� n�� ������ �Ӽ��� ������ ����(+a)
        			it.remove();
        		}
        	}
        }

        return answer;
    }
	
}
