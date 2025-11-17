import java.util.*;
public class ReverKInt {
  
  public static void reverseKInt(int [] arr , int k){
    Deque<Integer> pq = new LinkedList<>();
    int [] newarr = new  int [arr.length];
    
    // for(int q : arr){
    //   pq.addLast(q);
    // }
    // //  for(int i=k-1; i>=0; i--){
    //   newarr[i]=pq.remove();
    //  }
    //  for(int i=arr.length-1 ; i>=k; i--){
    //   newarr[i]=pq.removeLast();
    //  }
    // Alternative Code 

    // Adding first given elements in reverse order 
    for(int i=0 ; i<k; i++){
      pq.addFirst(arr[i]);
    }
    // putting the element in new arr from Deque
    int index = 0;
    while(!pq.isEmpty()){
      newarr[index++]= pq.removeFirst();
    }
    // copying the remianing elements of orignal array in new array
    for(int i=k; i<arr.length; i++){
      newarr[i]= arr[i];
    }

    // Printing new array
     for(int i=0 ; i<arr.length; i++){
      System.out.print(newarr[i]+" ");
     }
     System.out.println();
  }

  public static void main (String [] args){
    int [] arr = {10,20,30,40,50,60,70,80,90,100};
    int k=5;
    reverseKInt(arr ,k);
  }

}  
