import java.util.*;
public class Practice {
  
  public static int trapWater(int[] arr){
    Stack<Integer> st = new Stack<>();
    int water = 0;
    int n=arr.length;

    for(int i=0; i<n; i++){
      while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
        int top = st.pop();

        if(st.isEmpty()) break;
        
        int width = i-st.peek()-1;
        int height = Math.min(arr[i],arr[st.peek()])-arr[top];
        water+= height*width;
      }
      st.push(i);
    }
    return water;
  }
  public static void main(String[] args) {
    int[] arr = {7, 0, 4, 2, 5, 0, 6, 4, 0, 6};
        System.out.println("Total water trapped: " + trapWater(arr)+" units");
  }
}
