import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main<E extends Comparable<E>> {

	E[] data;

	@SuppressWarnings({ "resource", "unchecked", "rawtypes" })
	public Main() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter input count to be tested(Ex: 10) : ");
		int number = Integer.parseInt(scanner.nextLine());
		Integer[] data = new Integer[number];

		// randomly generate number and write to file
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * number);
		}
		writeToFile((E[]) data, "rand", number);

		// apply merge sort, then create nearly sorted input and write to file
		MergeSort ms = new MergeSort();
		ms.sort(data);
		shuffleArray((E[]) data);
		writeToFile((E[]) data, "nsor", number);

		// first aplly merge sort then reverse data array
		ms.sort(data);
		reverseArray((E[]) data);
		writeToFile((E[]) data, "sorr", number);

		// randomly generate double values between 0-1
		Double[] double_data = new Double[number];
		for (int i = 0; i < data.length; i++) {
			double_data[i] = Math.random();
		}
		writeToFile((E[]) double_data, "val_btw_0_1", number);

		System.out.println();
		String command = "Start";
		System.out.println("Enter Sorting Algorithm : ");
		scanner = new Scanner(System.in);
		while (true) {

			command = scanner.nextLine();
			switch (command) {
			case "Bubble Sort":
				bubbleSort("rand", "Bubble Sort", number, "Integer");
				bubbleSort("nsor", "Bubble Sort", number, "Integer");
				bubbleSort("sorr", "Bubble Sort", number, "Integer");
				bubbleSort("val_btw_0_1", "Bubble Sort", number, "Double");
				break;
			case "Merge Sort":
				mergeSort("rand", "Merge Sort", number, "Integer");
				mergeSort("nsor", "Merge Sort", number, "Integer");
				mergeSort("sorr", "Merge Sort", number, "Integer");
				mergeSort("val_btw_0_1", "Merge Sort", number, "Double");
				break;
			case "Quick Sort":
				quickSort("rand", "Quick Sort", number, "Integer");
				quickSort("nsor", "Quick Sort", number, "Integer");
				quickSort("sorr", "Quick Sort", number, "Integer");
				quickSort("val_btw_0_1", "Quick Sort", number, "Double");
				break;
			case "Radix Sort":
				radixSort("rand", "Radix Sort", number, "Integer");
				radixSort("nsor", "Radix Sort", number, "Integer");
				radixSort("sorr", "Radix Sort", number, "Integer");
				break;
			case "Heap Sort":
				heapSort("rand", "Heap Sort", number, "Integer");
				heapSort("nsor", "Heap Sort", number, "Integer");
				heapSort("sorr", "Heap Sort", number, "Integer");
				heapSort("val_btw_0_1", "Heap Sort", number, "Double");
				break;
			case "Selection Sort":
				selectionSort("rand", "Selection Sort", number, "Integer");
				selectionSort("nsor", "Selection Sort", number, "Integer");
				selectionSort("sorr", "Selection Sort", number, "Integer");
				selectionSort("val_btw_0_1", "Selection Sort", number, "Double");
				break;
			case "Shell Sort":
				shellSort("rand", "Shell Sort", number, "Integer");
				shellSort("nsor", "Shell Sort", number, "Integer");
				shellSort("sorr", "Shell Sort", number, "Integer");
				shellSort("val_btw_0_1", "Shell Sort", number, "Double");
				break;
			case "Insertion Sort":
				insertionSort("rand", "Insertion Sort", number, "Integer");
				insertionSort("nsor", "Insertion Sort", number, "Integer");
				insertionSort("sorr", "Insertion Sort", number, "Integer");
				insertionSort("val_btw_0_1", "Insertion Sort", number, "Double");
				break;
			case "Bucket Sort":
				bucketSort("rand", "Bucket Sort", number, "Integer");
				bucketSort("nsor", "Bucket Sort", number, "Integer");
				bucketSort("sorr", "Bucket Sort", number, "Integer");
				bucketSort("val_btw_0_1", "Bucket Sort", number, "Double");
				break;
			case "Array Sort":
				arraySort("rand", "Array Sort", number, "Integer");
				arraySort("nsor", "Array Sort", number, "Integer");
				arraySort("sorr", "Array Sort", number, "Integer");
				arraySort("val_btw_0_1", "Array Sort", number, "Double");
				break;
			case "Exit":
				System.exit(0);
				break;

			default:
				System.out.println("\nPlease enter a sorting algortihm (Ex: Bubble Sort) or type Exit");
				break;
			}

		
		}
		
	}

	@SuppressWarnings("unchecked")
	private void arraySort(String source, String destination, int number, String type) {
		Object[] data = getData(source, destination, number, type);
		double start = System.nanoTime();
		Arrays.sort(data);
		double finish = System.nanoTime();
		double duration = (finish - start) / 1000000;
		writeToFile((E[]) data, destination + "/sorted_" + source, number, duration);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void bucketSort(String source, String destination, int number, String type) {
		Object[] data = getData(source, destination, number, type);
		BucketSort bs = new BucketSort();
		double start = System.nanoTime();
		bs.sort((E[]) data, 5);
		double finish = System.nanoTime();
		double duration = (finish - start) / 1000000;
		writeToFile((E[]) data, destination + "/sorted_" + source, number, duration);

	}	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void insertionSort(String source, String destination, int number, String type) {
		Object[] data = getData(source, destination, number, type);
		InsertionSort is = new InsertionSort();
		double start = System.nanoTime();
		is.sort((E[]) data);
		double finish = System.nanoTime();
		double duration = (finish - start) / 1000000;
		writeToFile((E[]) data, destination + "/sorted_" + source, number, duration);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void shellSort(String source, String destination, int number, String type) {
		Object[] data = getData(source, destination, number, type);
		ShellSort ss = new ShellSort();
		double start = System.nanoTime();
		ss.sort((E[]) data);
		double finish = System.nanoTime();
		double duration = (finish - start) / 1000000;
		writeToFile((E[]) data, destination + "/sorted_" + source, number, duration);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void selectionSort(String source, String destination, int number, String type) {
		Object[] data = getData(source, destination, number, type);
		SelectionSort ss = new SelectionSort();
		double start = System.nanoTime();
		ss.sort((E[]) data);
		double finish = System.nanoTime();
		double duration = (finish - start) / 1000000;
		writeToFile((E[]) data, destination + "/sorted_" + source, number, duration);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void heapSort(String source, String destination, int number, String type) {
		Object[] data = getData(source, destination, number, type);
		HeapSort hs = new HeapSort();
		double start = System.nanoTime();
		hs.heap_sort((E[]) data);
		double finish = System.nanoTime();
		double duration = (finish - start) / 1000000;
		writeToFile((E[]) data, destination + "/sorted_" + source, number, duration);
	}

	@SuppressWarnings("unchecked")
	private void radixSort(String source, String destination, int number, String type) {
		Object[] data = getData(source, destination, number, type);
		RadixSort rs = new RadixSort();
		double start = System.nanoTime();
		rs.sort((Integer[]) data);
		double finish = System.nanoTime();
		double duration = (finish - start) / 1000000;
		writeToFile((E[]) data, destination + "/sorted_" + source, number, duration);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void quickSort(String source, String destination, int number, String type) {
		Object[] data = getData(source, destination, number, type);
		QuickSort qs = new QuickSort();
		double start = System.nanoTime();
		qs.quickSort((E[]) data, 0, data.length - 1);
		double finish = System.nanoTime();
		double duration = (finish - start) / 1000000;
		writeToFile((E[]) data, destination + "/sorted_" + source, number, duration);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void mergeSort(String source, String destination, int number, String type) {
		Object[] data = getData(source, destination, number, type);
		MergeSort ms = new MergeSort();
		double start = System.nanoTime();
		ms.sort((E[]) data);
		double finish = System.nanoTime();
		double duration = (finish - start) / 1000000;
		writeToFile((E[]) data, destination + "/sorted_" + source, number, duration);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void bubbleSort(String source, String destination, int number, String type) {
		Object[] data = getData(source, destination, number, type);
		BubbleSort bs = new BubbleSort();
		double start = System.nanoTime();
		bs.bubbleSort((E[]) data);
		double finish = System.nanoTime();
		double duration = (finish - start) / 1000000;
		writeToFile((E[]) data, destination + "/sorted_" + source, number, duration);
	}

	private Object[] getData(String source, String destination, int number, String type) {
		Object[] data;
		if (type.equals("Integer")) {
			data = new Integer[number];
			readFromFile(data, source, number, type);
		} else {
			data = new Double[number];
			readFromFile(data, source, number, type);
		}
		return data;
	}

	private void writeToFile(E[] data, String path, int number, double duration) {
		File file = new File("files/" + path + "_" + number + ".txt");
		try {
			PrintWriter writer = new PrintWriter(file);
			writer.println((path.split("/")[0]) + " :");
			System.out.println(path + " : " + duration);
			for (int i = 0; i < data.length; i++) {
				writer.println(data[i]);
			}
			writer.println("Time elapsed : " + duration + "    ms");
			writer.close();
		} catch (Exception e) {
			System.out.println("File not found!!");
		}

	}

	public void reverseArray(E[] data) {
		for (int i = 0; i < data.length / 2; i++) {
			E temp = data[i];
			data[i] = data[data.length - 1 - i];
			data[data.length - 1 - i] = temp;
		}
	}

	public void shuffleArray(E[] ar) {
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = ThreadLocalRandom.current();
		for (int i = (ar.length * 10) / 100; i > 0; i--) {
			int index = rnd.nextInt(ar.length - 1);
			int index2 = rnd.nextInt(ar.length - 1);
			// Simple swap
			E a = ar[index];
			ar[index] = ar[index2];
			ar[index2] = a;
		}
	}

	public void writeToFile(E[] arr, String path, int number) {
		data = arr;
		File file = new File("files/" + path + "_" + number + ".txt");
		try {
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0; i < data.length; i++) {
				writer.println(data[i]);
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("File not found!!");
		}
	}

	@SuppressWarnings("resource")
	public void readFromFile(Object[] data, String path, int number, String type) {
		File file = new File("files/" + path + "_" + number + ".txt");
		try {
			
			Scanner sc = new Scanner(file);
			int index = 0;
			while (sc.hasNextLine()) {
				if (type.equals("Integer")) {
					data[index] = Integer.parseInt(sc.nextLine());
				} else {
					data[index] = Double.parseDouble(sc.nextLine());
				}
				index++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found while reading !!");
		}

	}
	
	@SuppressWarnings("rawtypes" )
	public static void main(String[] args) {
		new Main();
	}

}
