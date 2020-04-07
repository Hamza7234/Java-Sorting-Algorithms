import java.util.ArrayList;

public class RadixSort {
  public void  sort(Integer[] inputArray) {
    final int RADIX = 10;
 
    @SuppressWarnings("unchecked")
	ArrayList<Integer> bucketsArray[] = new ArrayList[RADIX];
    for (int count = 0; count < bucketsArray.length; count++) {
      bucketsArray[count] = new ArrayList<>();
    }
 
    boolean maxDigitsLengthReached = false;
    int temp = -1, placeValue = 1;
    while (!maxDigitsLengthReached) {
      maxDigitsLengthReached = true;
      for (Integer element : inputArray) {
        temp = element / placeValue;
        bucketsArray[temp % RADIX].add(element);
        if (maxDigitsLengthReached && temp > 0) {
          maxDigitsLengthReached = false;
        }
      }
      int a = 0;
      for (int b = 0; b < RADIX; b++) {
        for (Integer i : bucketsArray[b]) {
          inputArray[a++] = i;
        }
        bucketsArray[b].clear();
      }
      placeValue = placeValue * RADIX;
    }
  }
}