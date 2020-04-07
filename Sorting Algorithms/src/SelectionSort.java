import java.util.Arrays;

class SelectionSort<E extends Comparable<E>> {
	E[] arr;
	void sort(E data[]) {
		arr = data;
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j].compareTo(arr[min_idx])<0)
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			E temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	// Driver code to test above
	public static void main(String args[]) {
		SelectionSort<Integer> ob = new SelectionSort<Integer>();
		Integer arr[] = { 64, 25, 12, 22, 11 };
		ob.sort(arr);
		System.out.println("Sorted array");
		System.out.println(Arrays.toString(arr));
	}
}