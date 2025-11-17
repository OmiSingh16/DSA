import java.util.PriorityQueue;

public class SlidingWindowMax {
  
  static class slideWind implements Comparable<slideWind>{
    int curr;
    int  idx;
    public slideWind(int curr ,int idx){
      this.curr = curr;
      this.idx=idx;
    }
    @Override
    public int compareTo(slideWind sd2){
      return sd2.curr - this.curr;
    }
  }
  public static void main(String[] args) {  // O(nlogk)
    int wind[] = {1,3,-1,-3,5,3,6,7};
    int k=3;
    int res[]= new int[wind.length-k+1];
    PriorityQueue<slideWind> pq = new PriorityQueue<>();
    for(int i=0; i<k; i++){
      pq.add(new slideWind(wind[i], i));
    }
    res[0] = pq.peek().curr;

    for(int i=k ; i<wind.length; i++){
      while(pq.size()>0 && pq.peek().idx <= (i-k)){
        pq.remove();
    }
      pq.add(new slideWind(wind[i],i));
      res[i-k+1] = pq.peek().curr;
    }  
    // print
    for(int i=0; i<res.length; i++){
      System.out.print(res[i]+" ");
    }
    System.out.println();
  }
}
