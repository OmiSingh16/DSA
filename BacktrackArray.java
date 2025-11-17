public class BacktrackArray {

  public static void fillArray(int arr[] , int i , int value){
    // Base Case
    if(i == arr.length){
      printArr(arr);
      return ;
    }
    // Recursion
    arr[i]= value;
    fillArray(arr, i+1, value+1);
    arr[i]= arr[i]-2;
  }

  public static void printArr(int arr[]){
    for(int i=0; i<arr.length; i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int arr [] = new int [5];
    fillArray(arr , 0 ,1);
    printArr(arr);
  }
}