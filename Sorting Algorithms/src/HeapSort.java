/*This code can take in any array of Comparable i.e whose data can be compared and generates the sorted elements using heap sort*/
public class HeapSort<E extends Comparable<? super E>> {
	private int heap_size;
	private E A[];

	private void build_max_heap() { // building max-heap
		heap_size = A.length - 1;
		for (int i = heap_size / 2; i >= 0; i--)
			max_heapify(i);
	}

	private void swap(int i, int j) {
		E tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	private void max_heapify(int i) {
		int l = 2 * i, r = 2 * i + 1; // left and right child
		int largest;
		if (l <= heap_size && A[l].compareTo(A[i]) > 0)
			largest = l;
		else
			largest = i;
		if (r <= heap_size && A[r].compareTo(A[largest]) > 0)
			largest = r;
		if (largest != i) { // finding largest, swapping and then reheapify
			swap(i, largest);
			max_heapify(largest);
		}
	}

	public E[] heap_sort(E[] a) {
		A = a;
		build_max_heap();
		for (int i = A.length - 1; i >= 0; i--) {
			swap(0, i); // swapping with first
			heap_size--; // decreasing size
			max_heapify(0); // reheapify
		}

		return A;
	}
}