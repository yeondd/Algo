package programmersLv2;

import java.util.ArrayList;

class Truck {
	private int truck_weights;
	private int len;
	
	Truck() {
	}
	
	Truck(int truck_weights) {
		this.truck_weights = truck_weights;
		this.len = 0;
	}
	
	public void go1Step() {
		len++;
	}
	
	public boolean checkLen(int bridge_length) {
		return (len == bridge_length) ? true : false;
	}

	public int getTruck_weights() {
		return truck_weights;
	}

	public void setTruck_weights(int truck_weights) {
		this.truck_weights = truck_weights;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}
	
}

public class No42583 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayList<Truck> queue = new ArrayList<Truck>();
        ArrayList<Truck> crossing = new ArrayList<Truck>();
        
        for(int i: truck_weights) {
        	Truck truck = new Truck(i);
        	queue.add(truck);
        }
        
    	int len = 0;
    	int idx = 0;
        Truck temp = new Truck();
    	
        while(true) {
        	if(queue.isEmpty() && crossing.isEmpty()) break;
        	if(answer > 10) break;
        	
        	// 0. ��������
        	answer++;
            int totalWeight = 0;
        	temp = queue.get(idx);
        	
        	// 1. ���� üũ
        	for(Truck t: crossing) {
            	// ���� �ٸ� ���� �ִ� Ʈ���� ��ü ���� ���ϱ�
        		totalWeight += t.getTruck_weights();
        	}
        	System.out.println("���� ��ü ����: " + totalWeight);
        	
        	// ���� ���Ժ��� ���� ���� ���� -> �ƴϸ� idx �״��
        	if(temp.getTruck_weights() + totalWeight <= weight) {
        		// �ø� �� ������ �� ĭ �̵� �� �ǳʴ� �迭�� �߰�
            	System.out.println("�߰� �� Ʈ�� ����: " + temp.getTruck_weights());
            	totalWeight += temp.getTruck_weights();
            	temp.go1Step();
            	crossing.add(temp);
            	idx++;
        	}
        	else {	// �� �÷����� ���� �ٸ��� �ִ� ��� Ʈ�� �� ĭ �� �̵�
        		for(Truck t: crossing) {
        			if(t.getLen() <= bridge_length) {
            			t.go1Step();
                    	System.out.println("�̵�: " + t.getTruck_weights() + " -> " + t.getLen());
                    	
            		}
        			else {
        				System.out.println("�ǳʰ� �ִ� �迭���� ����");
            			crossing.remove(t);
        			}
        		}
        	}
        }
        
        return answer;
    }
}
