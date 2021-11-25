package test.day6;

import java.util.ArrayList;
import java.util.Collections;

public class SortExam2 {

	public static void main(String[] args) {

		int[] arr = {2,4,1,3,7,6,8,5};
		ArrayList<Integer> nums = new ArrayList<>();
		
		ArrayList<String> strings = new ArrayList<>();
		
		
		nums.add(2);
		nums.add(4);
		nums.add(1);
		nums.add(3);
		nums.add(7);
		nums.add(6);
		nums.add(8);
		nums.add(5);
		
		
		for(int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i) + " ");
		}
		System.out.println();
		
		//Collections.sort(nums);
		Collections.sort(nums, Collections.reverseOrder());
		
		for(int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i) + " ");
		}
		System.out.println();
		
		
		strings.add("bbb");
		strings.add("aaa");
		strings.add("ddd");
		strings.add("ccc");
		
		for(int i = 0; i < strings.size(); i++) {
			System.out.print(strings.get(i) + " ");
		}
		System.out.println();
		
		Collections.sort(strings);
		
		for(int i = 0; i < strings.size(); i++) {
			System.out.print(strings.get(i) + " ");
		}
		
	}

}
