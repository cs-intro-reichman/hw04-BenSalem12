public class ArrayOps {
    public static void main(String[] args) {
        int[] arr1 = {0}, arr2 = {1,-2,3,-4,5}, arr31 = {1,2,3,-4,5}, arr32 = {1,3,-4,5}, arr4 = {500,500,1,1,0};
		int check1, check2;
		boolean check3, check4;
		check1 = findMissingInt (arr1);
		System.out.println("The Missing int is: " + check1);
		check2 = secondMaxValue(arr2);
		System.out.println("The second max value is: " + check2);
		check3 = containsTheSameElements(arr31, arr32);
		System.out.println("The answer for if it contains the Same elements is: " + check3);
		check4 = isSorted(arr4);
		System.out.println("The answer for if it is sorted is: " + check4);

    }
    
    public static int findMissingInt (int [] array) {
		int[] arr = new int[array.length + 1];
		int sumOld = 0, sumNew = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
			sumOld += i;
		}
		
        for (int i = 0; i < array.length; i++) {
			sumNew += array[i]; 
		}		
        return sumOld - sumNew;
    }

    public static int secondMaxValue(int [] array) {
        int max = array[0], min = array[0], index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				index = i;
			}
			if (array[i] < min) {
				max = array[i];
				index = i;
			}
		}
		array[index] = min;
		max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}		
        return max;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
		int count = 0;
        for (int i = 0; i < array1.length; i++) {
			count = 0;
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]){
					count ++;
				}
			}
			if (count == 0){
				return false;
			}
		}
        return true;
    }

    public static boolean isSorted(int [] array) {
		int count = 0, temp = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i-1]){
				for (int j = 0; j < array.length / 2; j++) {
					temp = array[j];
					array[j] = array[array.length - j - 1];
					array[array.length - j - 1] = temp;
				}
				break;
			}
		}
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] >= array[i-1]) {
				count++;
			}
		}
		
		if (count == array.length - 1){
			return true;
		}
		else{
			return false;
		}
    }

}
