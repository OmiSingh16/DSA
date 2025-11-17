// Its a very very important Question and we need to track the elemnt in reverse order for better optimising.

import java.util.*;
public class StackNextG {
  public static void nextGt(int [] arr, int [] nextG){
    Stack<Integer> s = new Stack<>();

    for(int i=arr.length-1; i>=0; i--){
      while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
        s.pop();
      }
      if(s.isEmpty()){
        nextG[i]= -1;
      }else {
        nextG[i]=arr[s.peek()];
      }
      s.push(i);
    }
    printArr(nextG);
  }
  public static void printArr(int[]newArr){
    for(int i=0; i<newArr.length; i++){
      System.out.print(newArr[i]+" ");
    }
    System.out.println();
  }
  
  public static void main (String[] args){
    int [] arr = {6,8,0,1,3};
    int [] nextG = new int [arr.length];
    printArr(arr);
    nextGt(arr, nextG);
  }
}
 