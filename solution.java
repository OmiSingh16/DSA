public class solution {
  public static int rob (int[] nums){
    int rob1 =0;
    int rob2 =0;
    int max =0;

    for (int i=0; i<nums.length ; i++){
      max = Math.max(rob1+nums[i], rob2);
      rob1 = rob2;
      rob2  = max;
    }
    return max;
  }
  public static void main(String[] args) {
    int nums[] = {2,4,3,9,11,2};
    System.out.println(rob(nums));
  }
}
