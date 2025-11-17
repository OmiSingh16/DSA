public class DividenConquer {
  
  public static void printArray(int arr[]){
    for(int i=0; i<arr.length; i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }

   public static void mergesort(int arr[]){
    int ei = arr.length-1;
    mergerSortone(arr,0,ei);
   }

  public static void mergerSortone(int arr[],int si,int ei){
    if(si>=ei){
      return;
    }
    int mid= si+(ei-si)/2;
    mergerSortone(arr, si, mid); // left part
    mergerSortone(arr, mid+1, ei); // right part
    merge(arr,si,mid,ei);
  }
  
  public static void merge(int arr[],int si, int mid, int ei){
    int temp[] = new int[ei-si+1];
    int i = si; // iterator for left part
    int j = mid+1; // iterator for right part
    int k = 0; // iterator for temp arr

    while (i<=mid && j<=ei) {
      if(arr[i]<arr[j]){
        temp[k]=arr[i];
        i++;
      } else{
        temp[k]=arr[j];
        j++;       
      }
      k++;
    }
    // left part
    while(i<=mid){
      temp[k++]=arr[i++];
    }
    // right part
    while(j<= ei){
      temp[k++]=arr[j++];
    }

    for(k=0, i=si; k<temp.length; k++,i++){
        arr[i]=temp[k];
    }
  } 

  public static void main(String[] args) {
    int arr[]={6,3,9,5,2,8};
    mergesort(arr);
    printArray(arr);
  }




// Apply merge sort on array of stringd


    // Merge function
    public static void merge(String arr[], int si, int mid, int ei) {
        System.out.println("🔹 Merging from si=" + si + " mid=" + mid + " ei=" + ei);

        String temp[] = new String[ei - si + 1];
        int i = si, j = mid + 1, k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= ei) temp[k++] = arr[j++];

        for (k = 0; k < temp.length; k++) {
            arr[si + k] = temp[k];
        }

        System.out.print("   ✅ Array after merging [" + si + "," + ei + "]: ");
        printArray(arr);
    }

    // Recursive MergeSort function with left/right indication
    public static void mergeSort(String arr[], int si, int ei) {
        System.out.println("mergeSort called: si=" + si + " ei=" + ei);

        if (si >= ei) {
            System.out.println("   ⚪ Base case reached: si=" + si + " ei=" + ei);
            return;
        }

        int mid = si + (ei - si) / 2;
        System.out.println("   ✂ Splitting: si=" + si + " mid=" + mid + " ei=" + ei);

        System.out.println("➡ Going LEFT: si=" + si + " mid=" + mid);
        mergeSort(arr, si, mid);

        System.out.println("➡ Going RIGHT: mid+1=" + (mid + 1) + " ei=" + ei);
        mergeSort(arr, mid + 1, ei);

        System.out.println("⬅ Now MERGING: si=" + si + " mid=" + mid + " ei=" + ei);
        merge(arr, si, mid, ei);
    }

    // Print array
    public static void printArray(String arr[]) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    // // Main function
    // public static void main(String[] args) {
    //     String arr[] = { "sun", "earth", "mars", "mercury" };

    //     System.out.println("Original array:");
    //     printArray(arr);

    //     mergeSort(arr, 0, arr.length - 1);

    //     System.out.println("Final sorted array:");
    //     printArray(arr);
    // }
  }

