// import java.util.ArrayList;
// import java.util.List;

public class Recursion {  

  // check if an array is sorted or not.
public static boolean checkSorted(int arr[], int i){

  int n = arr.length-1;

  if(i==n) return true;
  if(arr[i]> arr[i+1]) return false;
  return checkSorted(arr, i+1);
}

// First occurence of a number in an array.
public static int firstOccurence(int arr[], int i, int key){
  int n = arr.length-1;
  if(i==n) return -1;
  if(arr[i]==key) return i;
  return firstOccurence(arr, i+1, key);
}

// last occurence of a number in an array.
// public static int lastOccurence(int arr[], int i, int key){
//   int n = arr.length-1;
//   if(i==n)  return -1;
//   int isFound = lastOccurence(arr , i+1, key);
//   if(isFound == -1 && arr[i] == key) return i;
//   return isFound;
// }

// more  cleaner version.
public static int lastOccurrence(int[] arr, int i, int key) {
    if (i == arr.length) return -1;            // base: past last index -> not found
    int foundInSuffix = lastOccurrence(arr, i + 1, key);
    if (foundInSuffix != -1) return foundInSuffix;
    return (arr[i] == key) ? i : -1;
}

public static int lastOccurrence(int[] arr, int key) {
    return lastOccurrence(arr, 0, key);        // wrapper
}
  
/* 
Stack analysis for lastOccurrence code;

Step 2: Recursive calls (going forward)
We keep calling until base case (i == arr.length).

i=0 → arr[0]=8 → call lastOccurrence(arr,1,5)
i=1 → arr[1]=3 → call lastOccurrence(arr,2,5)
i=2 → arr[2]=6 → call lastOccurrence(arr,3,5)
i=3 → arr[3]=9 → call lastOccurrence(arr,4,5)
i=4 → arr[4]=5 → call lastOccurrence(arr,5,5)
i=5 → arr[5]=10 → call lastOccurrence(arr,6,5)
i=6 → arr[6]=2 → call lastOccurrence(arr,7,5)
i=7 → arr[7]=5 → call lastOccurrence(arr,8,5)
i=8 → arr[8]=3 → call lastOccurrence(arr,9,5)
i=9 → i==arr.length → return -1

  Step 3: Returning (coming back up)

Now recursion unwinds step by step:

i=8 → foundInSuffix=-1, arr[8]=3 ≠ key → return -1

i=7 → foundInSuffix=-1, arr[7]=5 == key → return 7

i=6 → foundInSuffix=7 → return 7

i=5 → foundInSuffix=7 → return 7

i=4 → foundInSuffix=7 (even though arr[4]=5, we keep 7) → return 7

i=3 → foundInSuffix=7 → return 7

i=2 → foundInSuffix=7 → return 7

i=1 → foundInSuffix=7 → return 7

i=0 → foundInSuffix=7 → return 7
 */

 // Binary Stirng Problem
public static void printBinaryString(int n, int lastPlace, String str){
  if(n==0){
    System.out.println(str);
    return;
  }  
  printBinaryString(n-1, 0, str+"0");
  if(lastPlace == 0){
    printBinaryString(n-1, 1, str+"1");
  }
}

/* 
   Alternative
   public class BinaryStrings {
    public static void printBinaryString(int n) {
        helper(n, 0, "");  // start with lastPlace = 0
    }

    private static void helper(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // Always can place '0'
        helper(n - 1, 0, str + "0");

        // Place '1' only if last was '0'
        if (lastPlace == 0) {
            helper(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        printBinaryString(3);
    }
}

 */

 /* using list solve the binary string problem.
 
 public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        helper(n, 0, "", result);
        return result;
    }

    private static void helper(int n, int lastPlace, String str, List<String> result) {
        if (n == 0) {
            result.add(str);
            return;
        }
        // Always can place '0'
        helper(n - 1, 0, str + "0", result);

        // Place '1' only if last was '0'
        if (lastPlace == 0) {
            helper(n - 1, 1, str + "1", result);
        }
    } */

    // Homework Assignment

    // Ques 1;
   /*
    public static void printOcuurence1(int arr[],int key , int i){
      int n = arr.length;

      if(i==n) return;
      if(arr[i]==key) System.out.print(i+" ");
      printOcuurence1(arr, key, i+1);
    } */


    // Ques 2:

    public static final String [] numword = {
      "zero","one","two","three","four","five","six","seven","eight","nine"
    };

    public static  void PrintNumWord(int n){

      if(n==0) return;
      PrintNumWord(n/10);
      System.out.print(numword[n%10]+" ");
    }



public static void main(String[] args) {
    
  // int arr[,]={1,2,3,4,5};
  // int arr[]={8,3,6,9,5,10,2,5,3};
  // System.out.println(lastOccurrence(arr,5));
  printBinaryString(3, 0, "");
  // List<String> binaries = generateBinaryStrings(3);
  //       System.out.println(binaries);

  // int arr[]={3, 2, 4, 5, 6, 2, 7, 2, 2};
  // int arr[]={2};
  // printOcuurence1(arr, 2, 0);

  // PrintNumWord(1988);

  }
}
