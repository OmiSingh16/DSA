import java.util.*;


public class PriorityQueues {
  
  static class Student implements Comparable<Student> {
    String name;
    int rank;

    public Student(String name,int rank){
      this.name=name;
      this.rank=rank;
    }
    @Override
    public int compareTo(Student s2){
      return this.rank - s2.rank;
    }
  }

  // Heap implementation Using ArrayList
  static class Heap{
    ArrayList<Integer> al = new ArrayList<>(); 

    public void add(int data) {
      al.add(data);
      int x= al.size()-1; // child index
      int par = (x-1)/2;  // parent index

      while(al.get(par)>al.get(x)){
        //swap
        int temp = al.get(par);
        al.set(par , al.get(x));
        al.set(x, temp);
        x = par;
        par = (x-1)/2;
      }
    }
    // peek
    public int peek(){
      return al.get(0);
    }
    // heapify
    private void heapify(int i){
      int left = 2*i+1;
      int right = 2*i+2;
      int minIdx =i;
      if(left < al.size() && al.get(minIdx)> al.get(left)){
        minIdx = left;
      }
      if(right < al.size() && al.get(minIdx)> al.get(right)){
        minIdx = right;
      }
      if(minIdx !=i){
        int temp = al.get(i);
        al.set(i , al.get(minIdx));
        al.set(minIdx , temp);

        heapify(minIdx);
      }
    }


    // delete element
    public int remove(){
      int data = al.get(0);

      //step-1 -- swap first & last
      int temp = al.get(0);
      al.set(0,al.get(al.size()-1));
      al.set(al.size()-1,temp);

      // step2 --- delete last
      al.remove(al.size()-1);

      // step3 - heapify
      heapify(0);
      return data;
    }

    public boolean isEmpty(){
      return al.size() == 0;
    }
  }


  public static void main(String[] args) {
    /* PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
    pq.add(new Student("A" ,4));  // O(logn)
    pq.add(new Student("B" ,5));
    pq.add(new Student("C" ,2));
    pq.add(new Student("D" ,12));

    while(!pq.isEmpty()){
      System.out.println(pq.peek().name+"->"+pq.peek().rank);  //O(1)
      pq.remove();  //O(logn)
    } */

    Heap h = new Heap();
    h.add(3);
    h.add(4);
    h.add(1);
    h.add(5);

    while(!h.isEmpty()){
      System.out.println(h.peek());
      h.remove();
    }
  }
}
