public class ShellSort<E extends Comparable<E>> {
	E[] data;

	public void sort(E[] arr) {
		data = arr;
		// Sort a[] into increasing order.
		int N = data.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;

		// h-sort the array.
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && (data[j].compareTo(data[j - h]) < 0); j -= h) {
					E temp = data[j];
					data[j] = data[j - h];
					data[j - h] = temp;
				}
			}
			h = h / 3;
		}

	}
}