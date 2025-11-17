public class sorting {

  public static void insertionSort(int arr[]) {
    for (int i = 1; i < arr.length; i++) {
      int curr = arr[i];   // ✅ fix: store value
      int prev = i - 1;

      while (prev >= 0 && arr[prev] > curr) {
        arr[prev + 1] = arr[prev]; // shift right
        prev--;
      }
      arr[prev + 1] = curr; // insert curr
    }
  }

  public static void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String args[]) {
    int arr[] = {22, 4, 1, 3, 2 ,9,5};
    insertionSort(arr);
    printArray(arr);
  }
}
