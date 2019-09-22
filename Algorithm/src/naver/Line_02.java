package naver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Permutation { 
	static int idx = 0;
	static ArrayList<String> list = new ArrayList<String>();
	public static ArrayList returnList() {
		return list;
	}
	
	public static void perm(String[] arr, int pivot, int k) {
		if(idx == k + 5) return;
		if (pivot == arr.length) {
			idx++;
			String s = print(arr);
			return;
		} 

		for (int i = pivot; i < arr.length; i++) { 
			swap(arr, i, pivot); 
			perm(arr, pivot + 1, k); 
			swap(arr, i, pivot); 
		} 
	}
	
	public static void swap(String[] arr, int i, int j) { 
		String temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp; 
	} 
	
	public static String print(String[] arr) { 
		String str = "";
		for (int i = 0; i < arr.length; i++) { 
			if (i == arr.length - 1) {
				str += arr[i];
				list.add(str);
				return str;
			}
			else {
				str += arr[i];
			}
		}

		return str; 
	} 
}

public class Line_02 {
	public static int k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        k = sc.nextInt();
        int size = (a.length() / 2) + 1;
        String[] numbers = new String[size];
        
        int idx = 0;
        for(int i = 0; i < a.length(); i++) {
        	if(a.charAt(i) != ' ') {
        		numbers[idx] = Character.toString(a.charAt(i));
        		idx++;
        	}
        }
        Arrays.sort(numbers);
        
        Permutation perm = new Permutation();
        perm.perm(numbers, 0, k);
        ArrayList permList = perm.returnList();
        int listSize = permList.size();

        Collections.sort(permList);
        
        System.out.println(permList.get(k - 1));
	}

}

