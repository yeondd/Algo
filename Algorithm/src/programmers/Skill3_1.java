package programmers;

public class Skill3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

	public int solution(int n) {
	    int answer = 0;
	    int horizontal = 0;
	    int vertical = 0;
	    
	    if(n > 60000) return 0;
	    
	    // ���η� �� �簢������ ä�� ������ �ִ�
	    answer++;
	    // ���η� �� �簢������ ä�� ������ �ִ�
	    answer++;
	    
	    // �̶� ���� ���θ�� & ���θ�� �簢���� �ִ� ����
	    horizontal = (n / 2) * 2;
	    vertical = n; // (n % 2 == 0) ? 0 : 1;
	    
	    
	 // ����� ���� 1,000,000,007���� ���� �������� return���ּ���.
	    answer %= 1000000007;
		return answer;
	}
}
