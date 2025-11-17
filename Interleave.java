import java.util.*;

public class Interleave {
  public static void InterleaveQ(Queue<Integer> q){
    if(q.size()%2 != 0){
      System.out.println("Queue must have even number of elements");
      return;
    }
    Queue<Integer> qu = new LinkedList<>();
    int n = q.size()/2;
    int i =1;
    while(i<=n){
      qu.add(q.remove());
      i++;
    }
    while(!qu.isEmpty()){   
    q.add(qu.remove());
    q.add(q.remove());
    }
  }
  
  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();
    int i =1;
    while(i<=10){
      q.add(i);
      i++;
    }
    InterleaveQ(q);
    while(!q.isEmpty())
    System.out.print(q.remove()+" ");
    System.out.println();
  }
}
