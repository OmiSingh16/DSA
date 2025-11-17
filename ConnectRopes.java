/* import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectRopes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of ropes: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter lengths of ropes:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Minimum cost to connect ropes: " + minCost(arr));
        sc.close();
    }

    public static int minCost(int[] arr) {
        // Min-heap to store rope lengths
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all ropes to the priority queue
        for (int length : arr) {
            pq.add(length);
        }

        int totalCost = 0;

        // Continue until only one rope is left
        while (pq.size() > 1) {
            int first = pq.poll();   // smallest rope
            int second = pq.poll();  // next smallest rope

            int cost = first + second;
            totalCost += cost;

            pq.add(cost); // add new rope back into heap
        }

        return totalCost;
    }
}
 */

import java.util.*;

public class ConnectRopes{

  public static int minCost(int[] arr){
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int totalCost = 0;
    for(int values : arr){
      pq.add(values);
    }
    while(pq.size()>1){
      int first = pq.poll();
      int second = pq.poll();
      int cost = first + second;
      totalCost +=cost;
      pq.offer(cost);
    }
    return totalCost;
  }

  public static void main(String[] args) {
    int[] arr = {4, 3, 2, 6};
    System.out.println(minCost(arr));
    
  }
}