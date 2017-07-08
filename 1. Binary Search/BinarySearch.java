import java.util.*;

public class BinarySearch {
	public static boolean binarySearch(int[] arr, int val) {
		return binarySearchHelper(arr, val, 0, arr.length - 1);
	}

	private static boolean binarySearchHelper(int[] arr, int val, int low, int high) {
		if(low > high) return false;
		int mid = (int)(low + high)/2;
		if(arr[mid] == val) {
			return true;
		}
		else if(arr[mid] > val) return binarySearchHelper(arr, val, low, mid);
		else return binarySearchHelper(arr, val, mid+1, high);
	}

	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};

		assert binarySearch(arr, 2): "failed at checking 2";
		assert binarySearch(arr, 7): "failed at checking 7";
		assert (binarySearch(arr, 10) == false) : "failed at checking 10";
		assert (binarySearch(arr, 8) == false) : "failed at checking 8";
	}
}