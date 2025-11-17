import java.util.*;

public class GenerateBinaryNumbers {
  public static void generateBinary(Queue<Integer> q){
    while(!q.isEmpty()){
      String binary = Integer.toBinaryString(q.peek());
      System.out.println("Binary of " + q.remove() + " is: " + binary);
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue<Integer> q =  new LinkedList<>();
    int n = sc.nextInt();
    for(int i=1; i<=n; i++){
      q.add(i);
    }
    generateBinary(q);
    sc.close();
  }
}
