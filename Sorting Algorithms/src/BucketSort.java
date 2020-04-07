import java.util.ArrayList;
import java.util.Collections;

public class BucketSort<E extends Comparable<E>> {

	public void sort(E[] a, int bucketCount) {
		if (bucketCount <= 0)
			throw new IllegalArgumentException("Invalid bucket count");
	

		E high = a[0];
		E low = a[0];

		for (int i = 1; i < a.length; i++) { // find the range of input elements
			if (a[i].compareTo(high) > 0)
				high = a[i];
			if (a[i].compareTo(low) < 0)
				low = a[i];
		}

		// int interval = ((int)high - (int)low + 1)/bucketCount; //range of one bucket

		@SuppressWarnings("unchecked")
		ArrayList<E> buckets[] = new ArrayList[bucketCount];
		for (int i = 0; i < bucketCount; i++) { // initialize buckets
			buckets[i] = new ArrayList<E>();
		}

		for (int i = 0; i < a.length; i++) { // partition the input array

			buckets[0].add(a[i]);
		}

		int pointer = 0;
		for (int i = 0; i < buckets.length; i++) {
			Collections.sort(buckets[i]); // mergeSort
			for (int j = 0; j < buckets[i].size(); j++) { // merge the buckets
				a[pointer] = buckets[i].get(j);
				pointer++;
			}
		}
	}
}