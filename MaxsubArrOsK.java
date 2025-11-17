import java.util.*;

public class MaxsubArrOsK {
  
  public static void findMaxOfAllSubArray(int[] arr , int k){
    Queue<Integer> q = new LinkedList<>();
    for(int i=0 , j=k-1 ; j<arr.length; i++,j++ ){
      int c1 = Math.max(arr[i] ,arr[i+1]);
      int c2 = Math.max(c1,arr[i+2]);
      q.add(c2);
    }
    while(!q.isEmpty()){
      System.out.print(q.remove()+" ");
    }
    System.out.println();

  }

  public static void main(String[] args) {
    int [] arr =  {1,2,3,1,4,5,2,3,6};
    int k=3;
    findMaxOfAllSubArray(arr ,k);
  }
}
