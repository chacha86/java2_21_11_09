package test.day7;

public class SortExam {

	public static void main(String[] args) {
		
		
		// 거품정렬
		int[] arr = {2,4,1,3,7,6,8,5};
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		for(int j = 0; j < arr.length - 1; j++) {			
			for(int i = 0; i < arr.length - 1 ; i++) {
				if(arr[i] < arr[i + 1]) {
					
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					
				}
			}
		}
		
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
		
	}

}
