import java.util.*;
public class maxRectangleArea {

  public static int maxArea(int[] arr){
    int area = 0;
    int n = arr.length;
    int nsl[]= new int[n];
    int nsr[]= new int[n];
    // Next smaller Right
    Stack<Integer> s = new Stack<>();
    for(int i=n-1; i>=0; i--){
      while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
        s.pop();
      }
      if(s.isEmpty()){
        nsr[i]=n;
      }else{
        nsr[i]= s.peek();
      }
      s.push(i);  
    }

    // Next smaller Right
     s = new Stack<>();
    for(int i=0; i<n; i++){
      while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
        s.pop();
      }
      if(s.isEmpty()){
        nsl[i]=-1;
      }else{
        nsl[i]= s.peek();
      }
      s.push(i);  
    }
    // Current Area
    for(int i=0; i<n; i++){
      int height = arr[i];
      int width = nsr[i]-nsl[i]-1;
      int currArea = height*width;
      area = Math.max(area , currArea);
    }
     
    return area;
  }

  public static void main (String[] args){
    // int[] heights = {2, 1, 5, 6, 2, 3};
    int[] heights = {2, 4};
    int result = maxArea(heights);
    System.out.println("Maximun Area present in Histogram is : "+result+".sqUnits");
  }
  
}
