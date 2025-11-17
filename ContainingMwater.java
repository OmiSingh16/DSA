import java.util.*;

public class ContainingMwater {

  public static int storeWater(ArrayList<Integer> height) {
    int maxWater = 0;
    // brute force -O(n^2)
    for (int i = 0; i < height.size(); i++) {
      for (int j = i + 1; j < height.size(); j++) {
        int ht = Math.min(height.get(i), height.get(j));
        int wt = j - i;
        int currWater = ht * wt;
        maxWater = Math.max(maxWater, currWater);
      }
    }
    return maxWater;
  }

  // 2 pointer approach optimize code -O(n)
  public static int storeWater2(ArrayList<Integer> height) {
    int maxwater = 0;
    int lp = 0;
    int rp = height.size() - 1;
    while (lp < rp) {
      int ht = Math.min(height.get(lp), height.get(rp));
      int wt = rp - lp;
      int currwater = ht * wt;
      maxwater = Math.max(currwater, maxwater);

      if (height.get(lp) < height.get(rp)) {
        lp++;
      } else {
        rp--;
      }
    }
    return maxwater;
  }
  /*
   * crisp version
   * public static int storeWater2(ArrayList<Integer> height) {
   * int maxWater = 0;
   * for (int lp = 0, rp = height.size() - 1; lp < rp; ) {
   * maxWater = Math.max(maxWater, Math.min(height.get(lp), height.get(rp)) * (rp
   * - lp));
   * if (height.get(lp) < height.get(rp)) lp++;
   * else rp--;
   * }
   * return maxWater;
   * }
   */

  /*
   * More crisp code
   * public static int storeWater2(ArrayList<Integer> height) {
   * int maxWater = 0;
   * for (int lp = 0, rp = height.size() - 1; lp < rp; maxWater =
   * Math.max(maxWater, Math.min(height.get(lp), height.get(rp)) * (rp - lp)),
   * (height.get(lp) < height.get(rp) ? lp++ : rp--));
   * return maxWater;
   * }
   * 
   */

  public static void main(String[] args) {
    ArrayList<Integer> height = new ArrayList<>();
    height.add(1);
    height.add(8);
    height.add(6);
    height.add(2);
    height.add(5);
    height.add(4);
    height.add(8);
    height.add(3);
    height.add(7);

    System.out.println("Max water that can be store is " + storeWater2(height) + " unit");
  }
}