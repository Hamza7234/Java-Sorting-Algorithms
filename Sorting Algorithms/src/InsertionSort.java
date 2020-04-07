// Java program for implementation of Insertion Sort
class InsertionSort <E extends Comparable<E>> {

	E[] arr;
	/* Function to sort array using insertion sort */
	void sort(E data[]) {
		arr = data;
		int n = data.length;
		for (int i = 1; i < n; ++i) {
			E key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			while (j >= 0 && arr[j].compareTo(key)>0) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

} /* This code is contributed by Rajat Mishra. */
