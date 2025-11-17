import java.util.*;
public class assignments {
  // Ques 1 --------
  public static boolean checkDistinct(int nums[]){   //TC O(n) , SC O(1)

    HashSet<Integer> set = new HashSet<>();
    for(int i=0 ; i<nums.length; i++){
      if(set.contains(nums[i])) return true;
      else{
        set.add(nums[i]);
      }
    }
    return false;
  }

  // Ques 2 --------

  
  public static  void main(String args[]){
    int nums[]={1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
    System.out.println(checkDistinct(nums));
  }
}
