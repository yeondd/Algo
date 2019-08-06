package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No12982 {
	public static void main(String[] args) {
		int[] d = {1,3,2,5,4};
		int budget = 9;
		System.out.println(solution(d, budget));
	}

	public static int solution(int[] d, int budget) {
		int answer = 0;
		int cost = 0;
		List<Integer> canditate = new LinkedList<Integer>();
		
		// sort
		Arrays.sort(d);
		int i = 0;
		// ���� ���� ������ ���ʷ� ���ؼ� ���꺸�� ũ�ų� ���������� ��
		for(i = 0; i < d.length; i++) {
			// ���� ���� ���ϸ� ���꺸�� ũ����, 
			if(cost + d[i] > budget) break;
			else {
				cost += d[i];
				canditate.add(i);
			}
		}

		i--;
		// ���ϱ� ���� ���꺸�� ���� ��� ���� ū �ε��� ���̶� ��
		// lastIdx: ArrayList�� ���� ������ ��. ����ȭ �� ��.
		int lastIdx = canditate.get(i);
		int maxRangeIdx = d.length;
		
		while(i > 0 || cost < budget) {
			
			for(int j = lastIdx + 1; j < maxRangeIdx; j++) {
				// ������� ���� ������ ���� ū ���� ���� �� �������� ū ���� �������� ������ ���� ������ �� ������ ��ü
				if(cost - d[j - 1] + d[j] <= budget) {
					canditate.remove(i);
					canditate.add(j);
					cost = cost - d[j - 1] + d[j];
				}
				else { break; }
			}
			
			i--;
			lastIdx = canditate.get(i);
			maxRangeIdx = canditate.get(i + 1);
		}
		
		answer = canditate.size();
		return answer;
	}
}
