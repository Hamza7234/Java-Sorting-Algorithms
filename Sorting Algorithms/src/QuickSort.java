public class QuickSort<E extends Comparable<E>> {
	E[] arr;

	public void quickSort(E[] data, int a, int b) {
		arr = data;
		if (a < b) {
			int i = a, j = b;
			E x = arr[(i + j) / 2];

			do {
				while (arr[i].compareTo(x) < 0)
					i++;
				while (x.compareTo(arr[j]) < 0)
					j--;

				if (i <= j) {
					E tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					i++;
					j--;
				}

			} while (i <= j);

			quickSort(arr, a, j);
			quickSort(arr, i, b);
		}
	}
}