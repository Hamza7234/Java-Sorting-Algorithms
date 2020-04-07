class BubbleSort<E extends Comparable<E>> {
	E[] arr;
	void bubbleSort(E a[]) {
		arr = a;
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					// swap temp and arr[i]
					E temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}
}